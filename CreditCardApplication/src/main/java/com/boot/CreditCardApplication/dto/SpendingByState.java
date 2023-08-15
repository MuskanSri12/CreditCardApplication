package com.boot.CreditCardApplication.dto;

public class SpendingByState {
    private String state;
    private double totalAmt;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public double getTotalAmt() {
        return totalAmt;
    }

    public void setTotalAmt(double totalAmt) {
        this.totalAmt = totalAmt;
    }
}
