package com.boot.CreditCardApplication.exceptions;

public class CustomerExistsException extends Exception{

    public CustomerExistsException(String message) {
        super(message);
    }
}
