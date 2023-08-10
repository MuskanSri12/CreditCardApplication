package com.boot.CreditCardApplication.services;

import com.boot.CreditCardApplication.entities.Customers;

import java.util.List;

public interface ICustomerCreditCardservice {

    public List<Customers> getAllUsers();
    public String getFirstName();
    public String addFirstName();
    public String addlastName();

}
