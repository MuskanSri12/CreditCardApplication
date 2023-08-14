package com.boot.CreditCardApplication.services;

import com.boot.CreditCardApplication.entities.Customers;
import com.boot.CreditCardApplication.exceptions.CustomerExistsException;
import com.boot.CreditCardApplication.exceptions.CustomerNotFoundException;
import com.boot.CreditCardApplication.repo.CustomerCreditCardrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerCreditCardService implements ICustomerCreditCardService {


    @Autowired
    private CustomerCreditCardrepo customerrep;

    @Override
    public List<Customers> getAllCustomers() {
        return customerrep.findAll();
    }

    @Override
    public List<Customers> getCustomerByGender(String gender) {
        return customerrep.findCustomerByGender(gender);
    }

    @Override
    public List<Customers> getCustomerByFirstName(String firstName) {
        return customerrep.findCustomerByFirst(firstName);
    }

    public Customers addCustomer(Customers customer) throws CustomerExistsException
    {
        if(customerrep.existsById(customer.getCustomer_Id()))
            throw new CustomerExistsException("Employee with "+customer.getCustomer_Id()+"already exists");
        long count = this.customerrep.count();
        customer.setCustomer_Id(String.valueOf(count+1));
        Customers savedCust = customerrep.save(customer);
        System.out.printf("There are now %d customers\n", customerrep.count());
        return  savedCust;
    }

    @Override
    public void updateCustomer( Customers custToUpdate) throws CustomerNotFoundException {
        System.out.println("UPDATE "+custToUpdate.getCustomer_Id());
        if(! customerrep.existsById(custToUpdate.getCustomer_Id()))
            throw new CustomerNotFoundException("Customer with "+custToUpdate.getCustomer_Id()+" does not exist");
        customerrep.save(custToUpdate);
    }

    @Override
    public void deleteCustomer(String custId) throws CustomerNotFoundException {

        if(!customerrep.existsById(custId))
            throw new CustomerNotFoundException("Customer with "+custId+" does not exist");
        customerrep.deleteById(custId);
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
