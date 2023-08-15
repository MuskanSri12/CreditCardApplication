package com.boot.CreditCardApplication.dao;

import com.boot.CreditCardApplication.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;
import java.util.List;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;

@Repository
public class TransactionDALMongoTemplate {

    @Autowired
    private MongoTemplate mongoTemplate;

    //for SpendingByCity
    public List<SpendingByCity> getAmtForCity() {

        GroupOperation groupByCitySumAmt = group("city").sum("amt").as("totalAmt");
        MatchOperation allCities = match(new Criteria("city").exists(true));
        ProjectionOperation includes = project("totalAmt").and("city").previousOperation();
        SortOperation sortByAmtDesc = sort(Sort.by(Sort.Direction.DESC,"total_transactionAmt"));
        Aggregation aggregation = newAggregation(allCities,groupByCitySumAmt,sortByAmtDesc,includes);
        AggregationResults<SpendingByCity> groupResults = mongoTemplate.aggregate(aggregation, "CreditCardTransactions", SpendingByCity.class);
        List<SpendingByCity> result = groupResults.getMappedResults();
        return result;
    }



    //for SpendingByGender
    public List<SpendingByGender> getSpendingByGender(){
        GroupOperation groupByGenderSumAmt = group("gender").sum("amt").as("totalAmt"); //check for total amt
        MatchOperation allGender= match(new Criteria("gender").exists(true));
        ProjectionOperation includes = project("totalAmt").and("gender").previousOperation();
        SortOperation sortByAmtDesc = sort(Sort.by(Sort.Direction.DESC, "totalAmt"));
        Aggregation aggregation = newAggregation(allGender, groupByGenderSumAmt, sortByAmtDesc, includes);
        AggregationResults<SpendingByGender> groupResults = mongoTemplate.aggregate(aggregation, "CreditCardTransactions", SpendingByGender.class);
        List<SpendingByGender> result = groupResults.getMappedResults();
        return result;
    }


    //for SpendingByMerchant
    public List<SpendingByMerchant> getSpendingByMerchant() {
        GroupOperation groupByMerchantSumAmt = group("merchant").sum("amt").as("totalAmt"); //check for total amt
        MatchOperation allMerchant= match(new Criteria("merchant").exists(true));
        ProjectionOperation includes = project("totalAmt").and("merchant").previousOperation();
        SortOperation sortByAmtDesc = sort(Sort.by(Sort.Direction.DESC, "totalAmt"));
        Aggregation aggregation = newAggregation(allMerchant, groupByMerchantSumAmt, sortByAmtDesc, includes);
        AggregationResults<SpendingByMerchant> groupResults = mongoTemplate.aggregate(aggregation, "CreditCardTransactions", SpendingByMerchant.class);
        List<SpendingByMerchant> result = groupResults.getMappedResults();
        return result;

    }

    //for SpendingByState
    public List<SpendingByState> getSpendingByState() {
        GroupOperation groupByStateSumAmt = group("state").sum("amt").as("totalAmt"); //check for total amt
        MatchOperation allState= match(new Criteria("state").exists(true));
        ProjectionOperation includes = project("totalAmt").and("state").previousOperation();
        SortOperation sortByAmtDesc = sort(Sort.by(Sort.Direction.DESC, "totalAmt"));


        Aggregation aggregation = newAggregation(allState, groupByStateSumAmt, sortByAmtDesc, includes);
        AggregationResults<SpendingByState> groupResults = mongoTemplate.aggregate(aggregation, "CreditCardTransactions", SpendingByState.class);
        List<SpendingByState> result = groupResults.getMappedResults();
        return result;
    }
    //for SpendingByCategory
    public List<SpendingByCategory> getSpendingByCategory() {
        GroupOperation groupByCategorySumAmt = group("category").sum("amt").as("totalAmt"); //check for total amt
        MatchOperation allCategory= match(new Criteria("category").exists(true));
        ProjectionOperation includes = project("totalAmt").and("category").previousOperation();
        SortOperation sortByAmtDesc = sort(Sort.by(Sort.Direction.DESC, "totalAmt"));
        Aggregation aggregation = newAggregation(allCategory, groupByCategorySumAmt, sortByAmtDesc, includes);
        AggregationResults<SpendingByCategory> groupResults = mongoTemplate.aggregate(aggregation, "CreditCardTransactions", SpendingByCategory.class);
        List<SpendingByCategory> result = groupResults.getMappedResults();
        return result;
    }

    public List<SpendingByProfession> getSpendingByProfession() {
        GroupOperation groupByProfessionSumAmt = group("Job").sum("amt").as("totalAmt"); //check for total amt
        MatchOperation allProfession= match(new Criteria("Job").exists(true));
        ProjectionOperation includes = project("totalAmt").and("Job").previousOperation();
        SortOperation sortByAmtDesc = sort(Sort.by(Sort.Direction.DESC, "totalAmt"));
        Aggregation aggregation = newAggregation(allProfession, groupByProfessionSumAmt, sortByAmtDesc, includes);
        AggregationResults<SpendingByProfession> groupResults = mongoTemplate.aggregate(aggregation, "CreditCardTransactions", SpendingByProfession.class);
        List<SpendingByProfession> result = groupResults.getMappedResults();
        return result;
    }

  //function need to be written
    //public List<GroupingByAmountOfSpending> getSpendingByAmountLowVsHigh(){}
}

