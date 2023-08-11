package com.boot.CreditCardApplication.repo;


import com.boot.CreditCardApplication.entities.Customers;
import com.boot.CreditCardApplication.entities.Transactions;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface TransactionCreditCardrepo extends MongoRepository<Transactions, String > {
    @Query("{'first':'?0'}")
    List<Transactions> findByFirstName(String first);

    @Query("{'gender':'?0'}")
    List<Transactions> findTransactionByGender(String gender);



}
