package com.boot.CreditCardApplication.dto;

import org.springframework.data.mongodb.core.mapping.Field;

public class SpendingByProfession{
    @Field("Job")
    private String job;
    private double totalAmt;

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public double getTotalAmt() {
        return totalAmt;
    }

    public void setTotalAmt(double totalAmt) {
        this.totalAmt = totalAmt;
    }
}
