package com.boot.CreditCardApplication.services;

import com.boot.CreditCardApplication.entities.Customers;
import com.boot.CreditCardApplication.exceptions.CustomerExistsException;
import com.boot.CreditCardApplication.exceptions.CustomerNotFoundException;

import java.util.List;

public interface ICustomerCreditCardService {

    public List<Customers> getAllCustomers();

    public List<Customers> getCustomerByGender(String gender);

    public Customers addCustomer(Customers customer) throws CustomerExistsException;

    public void updateCustomer( Customers custToUpdate) throws CustomerNotFoundException;

    public void deleteCustomer(String custId) throws CustomerNotFoundException;

    public List<Customers> getCustomerByFirstName(String firstName);

    public String addFirstName();
    public String addlastName();

}
