package com.boot.CreditCardApplication.dto;

public class SpendingByCity {
    private String city;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Double getAmt() {
        return totalAmt;
    }

    public void setAmt(Double amt) {
        this.totalAmt = amt;
    }

    private Double totalAmt;
}
