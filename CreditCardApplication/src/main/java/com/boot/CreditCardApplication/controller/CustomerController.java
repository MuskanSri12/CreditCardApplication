package com.boot.CreditCardApplication.controller;


import com.boot.CreditCardApplication.entities.Customers;
import com.boot.CreditCardApplication.services.CustomerCreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerCreditCardService customerCreditCardService;

    @GetMapping
    public List<Customers> getEmployeeByIdResponse()
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
}
