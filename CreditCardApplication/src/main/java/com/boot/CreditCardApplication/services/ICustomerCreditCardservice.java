package com.boot.CreditCardApplication.services;

import com.boot.CreditCardApplication.entities.Customers;

import java.util.List;

public interface ICustomerCreditCardservice {

    public List<Customers> getAllCustomers();

    public List<Customers> getCustomerByFirstName(String firstName);

    public String addFirstName();
    public String addlastName();

}
