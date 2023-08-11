package com.boot.CreditCardApplication.services;

import com.boot.CreditCardApplication.entities.Transactions;
import com.boot.CreditCardApplication.repo.TransactionCreditCardrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionCreditCardService implements ITransactionCreditCardService{


    @Autowired
    private TransactionCreditCardrepo transactionsrep;

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
}
