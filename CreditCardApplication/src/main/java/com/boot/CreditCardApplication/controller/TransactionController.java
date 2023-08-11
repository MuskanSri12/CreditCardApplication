package com.boot.CreditCardApplication.controller;


import com.boot.CreditCardApplication.entities.Transactions;
import com.boot.CreditCardApplication.services.TransactionCreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    @Autowired
    private TransactionCreditCardService transactionCreditCardService;

    @GetMapping
    public List<Transactions> getAllTransactions()
    {
        try {
            List<Transactions> transactions = this.transactionCreditCardService.getAllTransactions();
//            return ResponseEntity.status(HttpStatus.FOUND).body(customers);
            return transactions;
        } catch (Exception e) {
            // throw new RuntimeException(e);
//            return ResponseEntity.noContent().build();
            return null;
        }
    }

    @GetMapping("/{gender}")
    public List<Transactions> getTransactionByGender(@PathVariable String gender)
    {
        try {
            List<Transactions> transactions = this.transactionCreditCardService.getTransactionByGender(gender);
//            return ResponseEntity.status(HttpStatus.FOUND).body(customers);
            return transactions;
        } catch (Exception e) {
            // throw new RuntimeException(e);
//            return ResponseEntity.noContent().build();
            return null;
        }
    }
}
