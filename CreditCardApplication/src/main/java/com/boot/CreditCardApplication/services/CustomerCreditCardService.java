package com.boot.CreditCardApplication.services;

import com.boot.CreditCardApplication.entities.Customers;
import com.boot.CreditCardApplication.repo.CustomerCreditCardrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerCreditCardService implements ICustomerCreditCardservice{


    @Autowired
    private CustomerCreditCardrepo customerrep;

    @Override
    public List<Customers> getAllCustomers() {
        return customerrep.findAll();
    }

    @Override
    public List<Customers> getCustomerByFirstName(String firstName) {
        return customerrep.findByFirstName(firstName);
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
