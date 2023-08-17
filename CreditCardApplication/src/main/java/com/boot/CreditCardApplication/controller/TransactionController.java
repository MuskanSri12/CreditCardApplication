package com.boot.CreditCardApplication.controller;


import com.boot.CreditCardApplication.dto.*;
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

//    @GetMapping("/{gender}")
//    public List<Transactions> getTransactionByGender(@PathVariable String gender)
//    {
//        try {
//            List<Transactions> transactions = this.transactionCreditCardService.getTransactionByGender(gender);
////            return ResponseEntity.status(HttpStatus.FOUND).body(customers);
//            return transactions;
//        } catch (Exception e) {
//            // throw new RuntimeException(e);
////            return ResponseEntity.noContent().build();
//            return null;
//        }
//    }

    //spending by city
    @GetMapping("/city")
    public List<SpendingByCity> getTransactionAmtByCity()
    {
        return transactionCreditCardService.getCityAmt();
    }

    //spending for gender

    @GetMapping("/gender")
    public List<SpendingByGender> getTransactionAmtByGender(){
        return transactionCreditCardService.getSpendingForGender();
    }
    //spending by merchant
    @GetMapping("/merchant")
    public List<SpendingByMerchant> getTransactionAmtByMerchant(){
        return transactionCreditCardService.getSpendingForMerchant();
    }
    //spending by state
    @GetMapping("/state")
    public List<SpendingByState> getTransactionAmtByState(){
        return transactionCreditCardService.getSpendingForState();
    }

    //spending by category
    @GetMapping("/category")
    public List<SpendingByCategory> getTransactionAmtByCategory(){
        return transactionCreditCardService.getSpendingForCategory();
    }

    @GetMapping("/Job")
    public List<SpendingByProfession> getTransactionAmtByProfession(){
        return transactionCreditCardService.getSpendingForProfession();
    }

    @GetMapping("/spendingByAmt/{low}/{high}")
    public List<SpendingAnalysis> getSpendingByAmt(@PathVariable double low, @PathVariable double high){
        return transactionCreditCardService.getSpendingByAmount(low, high);

    }

//    @GetMapping("/AmountBySpending(low vs high)")
//    public List<GroupingByAmountOfSpending> getTransactionAmountByLowVsHigh(){
//        return  transactionCreditCardService.getSpendingByAmountLowVsHigh();
//    }

}
