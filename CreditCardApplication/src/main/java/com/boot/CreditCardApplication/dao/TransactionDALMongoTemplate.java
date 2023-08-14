package com.boot.CreditCardApplication.dao;

import com.boot.CreditCardApplication.dto.CityAmt;
import com.boot.CreditCardApplication.entities.Transactions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;

@Repository
public class TransactionDALMongoTemplate {

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Transactions> getTransactionsByGender(String gender)
    {
        Query query = new Query();
        query.addCriteria(Criteria.where("gender").is(gender));
        return mongoTemplate.find(query, Transactions.class);
    }

    public List<Transactions> getAllTransactions() {
        return mongoTemplate.findAll(Transactions.class);
    }


    public Transactions getTransactionsById(String transactionID) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(transactionID));
        return mongoTemplate.findOne(query, Transactions.class);
    }


    public List<CityAmt> getAmtForCity() {

        GroupOperation groupByCitySumAmt = group("city").sum("amt").as("total_transactionAmt");
        MatchOperation allCities = match(new Criteria("city").exists(true));

        ProjectionOperation includes = project("total_transactionAmt").and("city").previousOperation();
        SortOperation sortByAmtDesc = sort(Sort.by(Sort.Direction.DESC,"total_transactionAmt"));
        Aggregation aggregation = newAggregation(allCities,groupByCitySumAmt,sortByAmtDesc,includes);
        AggregationResults<CityAmt> groupResults = mongoTemplate.aggregate(aggregation, "CreditCardTransactions", CityAmt.class);
        List<CityAmt> result = groupResults.getMappedResults();
        return result;
    }
}
