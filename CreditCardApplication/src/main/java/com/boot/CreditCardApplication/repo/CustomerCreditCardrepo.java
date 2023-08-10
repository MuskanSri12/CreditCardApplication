package com.boot.CreditCardApplication.repo;


import com.boot.CreditCardApplication.entities.Customers;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface CustomerCreditCardrepo extends MongoRepository<Customers, String > {


    @Query("{'firstname':'?0'}")
    List<Customers> findByFirstName(String firstName);



}
