package com.boot.CreditCardApplication.controller;


import com.boot.CreditCardApplication.entities.Customers;
import com.boot.CreditCardApplication.exceptions.CustomerExistsException;
import com.boot.CreditCardApplication.exceptions.CustomerNotFoundException;
import com.boot.CreditCardApplication.services.CustomerCreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerCreditCardService customerCreditCardService;

    @GetMapping
    public List<Customers> getAllCustomers()
    {
        try {
            List<Customers> customers = this.customerCreditCardService.getAllCustomers();
//            return ResponseEntity.status(HttpStatus.FOUND).body(customers);
            return customers;
        } catch (Exception e) {
            // throw new RuntimeException(e);
//            return ResponseEntity.noContent().build();
            return null;
        }
    }

    @GetMapping("/{customer_Id}")
    public Customers getCustomerById(@PathVariable("customer_Id") String customer_Id)
    {
        try {
            return this.customerCreditCardService.getCustomerById(customer_Id);
        } catch (CustomerNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/gender/{gender}")
    public List<Customers> getCustomerByGender(@PathVariable String gender)
    {
        try {
            List<Customers> customers = this.customerCreditCardService.getCustomerByGender(gender);
//            return ResponseEntity.status(HttpStatus.FOUND).body(customers);
            return customers;
        } catch (Exception e) {
            // throw new RuntimeException(e);
//            return ResponseEntity.noContent().build();
            return null;
        }
    }

    @PostMapping
    public Customers addCustomer(@RequestBody Customers customer)
    {
        try {
            Customers customer1 = this.customerCreditCardService.addCustomer(customer);
//            return ResponseEntity.status(HttpStatus.CREATED).body(employee1);
            return customer1;
        } catch (CustomerExistsException e) {
//            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e.getMessage());
            return null;
        }
    }

    @PutMapping
    public boolean updateEmployee(@RequestBody Customers customers)
    {
//        Map<StatusMessages , String> map = new HashMap<>();
        try {
            this.customerCreditCardService.updateCustomer(customers);
//            map.put(StatusMessages.SUCCESS, "Employee updated successfully");
//            return ResponseEntity.status(HttpStatus.ACCEPTED).body(map);
             return true;
        } catch (CustomerNotFoundException e) {
//            map.put(StatusMessages.FAILURE, e.getMessage());
//            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(map);
            return false;
        }
    }

    @DeleteMapping("/{custId}")
    public boolean deleteCustomerById(@PathVariable String custId)
    {
//        Map<StatusMessages , String> map = new HashMap<>();
        try {
//            map.put(StatusMessages.SUCCESS, "Employee deleted successfully");
            this.customerCreditCardService.deleteCustomer(custId);
//            return ResponseEntity.status(HttpStatus.ACCEPTED).body(map);
            return true;
        } catch (CustomerNotFoundException e) {
//            map.put(StatusMessages.FAILURE, e.getMessage());
//            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(map);
            return false;
        }
    }
}
