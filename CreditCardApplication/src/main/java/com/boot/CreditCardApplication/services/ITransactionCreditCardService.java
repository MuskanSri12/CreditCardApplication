package com.boot.CreditCardApplication.services;

import com.boot.CreditCardApplication.entities.Transactions;

import java.util.List;

public interface ITransactionCreditCardService {

    public List<Transactions> getAllTransactions();

    public List<Transactions> getTransactionByGender(String gender);

    public List<Transactions> getTransactionByFirstName(String firstName);

    public String addFirstName();
    public String addlastName();

}
