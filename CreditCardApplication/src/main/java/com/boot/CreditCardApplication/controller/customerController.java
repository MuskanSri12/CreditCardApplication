package com.boot.CreditCardApplication.controller;


import com.boot.CreditCardApplication.entities.Customers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class customerController {
    @Autowired
    private Customers customer;

    @GetMapping
    public ResponseEntity<List<Customers>>
}