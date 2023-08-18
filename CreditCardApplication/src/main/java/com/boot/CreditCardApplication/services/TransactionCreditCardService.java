package com.boot.CreditCardApplication.services;

import com.boot.CreditCardApplication.dao.TransactionDALMongoTemplate;
import com.boot.CreditCardApplication.dto.*;
import com.boot.CreditCardApplication.entities.Transactions;
import com.boot.CreditCardApplication.repo.TransactionCreditCardrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import javax.management.Query;
import java.util.List;

@Service
public class TransactionCreditCardService implements ITransactionCreditCardService{

    @Autowired
    private TransactionCreditCardrepo transactionsrep;

    @Autowired
    private TransactionDALMongoTemplate transactionDALMongoTemplate;

    @Override
    public List<Transactions> getAllTransactions() {
        return transactionsrep.findAll();
    }

    @Override
    public List<Transactions> getTransactionByGender(String gender) {
        return transactionsrep.findTransactionByGender(gender);
    }


    @Override
    public List<Transactions> getTransactionByFirstName(String firstName) {
        return transactionsrep.findByFirstName(firstName);
    }

    @Override
    public String addFirstName() {
        return null;
    }

    @Override
    public String addlastName() {
        return null;
    }


    public List<SpendingByCity> getCityAmt()
    {
        return transactionDALMongoTemplate.getAmtForCity();
    }


    //spending by Gender
    public List<SpendingByGender> getSpendingForGender(){
        return transactionDALMongoTemplate.getSpendingByGender();
    }

    public List<SpendingByMerchant> getSpendingForMerchant() {
        return transactionDALMongoTemplate.getSpendingByMerchant();
    }

    public List<SpendingByState> getSpendingForState() {
        return transactionDALMongoTemplate.getSpendingByState();
    }

    public List<SpendingByCategory> getSpendingForCategory() {
        return transactionDALMongoTemplate.getSpendingByCategory();
    }
    public List<SpendingByProfession> getSpendingForProfession() {
        return transactionDALMongoTemplate.getSpendingByProfession();
    }
//    public List<Transactions> getAllTransactionByRange(double from, double to) {
//        return this.transactionsrep.findTransactionInRange(from, to);

    public List<SpendingAnalysis> getSpendingByAmount(double low, double high) {
        return transactionDALMongoTemplate.getSpendingByAmount(low,high);
    }
    public List<Transactions> getTransactionByMerchant(String merchant) {
        return transactionsrep.findTransactionByMerchant(merchant);
    }
    public List<Transactions> getTransactionByCity(String city) {
        return transactionsrep.findTransactionByCity(city);
    }
    public List<Transactions> getTransactionByCategory(String category) {
        return transactionsrep.findTransactionByCategory(category);
    }
}
