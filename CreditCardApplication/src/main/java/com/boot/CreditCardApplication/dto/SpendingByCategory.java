package com.boot.CreditCardApplication.dto;

public class SpendingByCategory {
    private String category;
    double totalAmt;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getTotalAmt() {
        return totalAmt;
    }

    public void setTotalAmt(double totalAmt) {
        this.totalAmt = totalAmt;
    }
}
