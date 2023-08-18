package com.boot.CreditCardApplication.repo;


import com.boot.CreditCardApplication.dto.SpendingAnalysis;
import com.boot.CreditCardApplication.entities.Customers;
import com.boot.CreditCardApplication.entities.Transactions;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface TransactionCreditCardrepo extends MongoRepository<Transactions, String > {
    @Query("{'first':'?0'}")
    List<Transactions> findByFirstName(String first);

    @Query("{'gender':'?0'}")
    List<Transactions> findTransactionByGender(String gender);
    @Query("{'merchant':'?0'}")
    List<Transactions> findTransactionByMerchant(String merchant);

    @Query("{'city':'?0'}")
    List<Transactions> findTransactionByCity(String city);

    @Query("{'category':'?0'}")
    List<Transactions> findTransactionByCategory(String category);

//    List<Transactions> findByMerchant(String merchant);

//    @Query("{'merchant':'?0'}")
//    List<Transactions> findTransactionByMerchant(String merchant);
//    List<Employee> findEmployeesByRegion(String region);
//    @Query("{'dosh' : {$gte : ?0, $lte : ?1}}")
//    List<Transactions> findTransactionInRange(double from, double to);

}
