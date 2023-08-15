package com.boot.CreditCardApplication.dto;

public class SpendingByGender {
    private String gender;
    private double totalAmt;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getTotalAmt() {
        return totalAmt;
    }

    public void setTotalAmt(double totalAmt) {
        this.totalAmt = totalAmt;
    }
}
