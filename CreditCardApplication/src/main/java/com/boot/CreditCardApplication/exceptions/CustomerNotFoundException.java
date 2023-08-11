package com.boot.CreditCardApplication.exceptions;

public class CustomerNotFoundException extends  Exception{

    public CustomerNotFoundException(String message) {
        super(message);
    }
}
