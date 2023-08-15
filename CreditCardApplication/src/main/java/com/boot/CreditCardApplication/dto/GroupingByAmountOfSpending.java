package com.boot.CreditCardApplication.dto;

public class GroupingByAmountOfSpending {
 private double totalAmt;
 private String typeOfSpending;

    public GroupingByAmountOfSpending(String typeOfSpending, double totalAmt) {
        this.typeOfSpending=typeOfSpending;
        this.totalAmt = totalAmt;
    }

    public double getTotalAmt() {
        return totalAmt;
    }

    public void setTotalAmt(double totalAmt) {
        this.totalAmt = totalAmt;
    }

    public String getTypeOfValue() {
        return typeOfSpending;
    }

    public void setTypeOfValue(String typeOfSpending) {
        this.typeOfSpending=typeOfSpending;
    }
}
