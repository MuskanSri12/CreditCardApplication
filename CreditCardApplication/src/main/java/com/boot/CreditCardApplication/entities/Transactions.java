package com.boot.CreditCardApplication.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("CreditCardTransactions")
public class Transactions {
    @Id
    String transaction_Id;
    String trans_date_trans_time;
    Double amt;
    int trans_num;
    int customer_id;
    String city;
    String state;
    int city_population;
   String merchant;
   String category;
   String first;

    String last;
    String gender;
    String Job;

    public Transactions(String transaction_Id, String trans_date_trans_time, Double amt, int trans_num, int customer_id, String city, String state, int city_population, String merchant, String category, String first, String last, String gender, String Job, String dob) {
        this.transaction_Id = transaction_Id;
        this.trans_date_trans_time = trans_date_trans_time;
        this.amt = amt;
        this.trans_num = trans_num;
        this.customer_id = customer_id;
        this.city = city;
        this.state = state;
        this.city_population = city_population;
        this.merchant = merchant;
        this.category = category;
        this.first = first;
        this.last = last;
        this.gender = gender;
        this.Job = Job;
        this.dob = dob;
    }



    public String getTransaction_Id() {
        return transaction_Id;
    }

    @Override
    public String toString() {
        return "Transactions{" +
                "transaction_Id='" + transaction_Id + '\'' +
                ", trans_date_trans_time='" + trans_date_trans_time + '\'' +
                ", amt=" + amt +
                ", trans_num=" + trans_num +
                ", customer_id=" + customer_id +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", city_population=" + city_population +
                ", merchant='" + merchant + '\'' +
                ", category='" + category + '\'' +
                ", first='" + first + '\'' +
                ", last='" + last + '\'' +
                ", gender='" + gender + '\'' +
                ", Job='" + Job + '\'' +
                ", dob='" + dob + '\'' +
                '}';
    }

    public void setTransaction_Id(String transaction_Id) {
        this.transaction_Id = transaction_Id;
    }

    public String getTrans_date_trans_time() {
        return trans_date_trans_time;
    }

    public void setTrans_date_trans_time(String trans_date_trans_time) {
        this.trans_date_trans_time = trans_date_trans_time;
    }

    public Double getAmt() {
        return amt;
    }

    public void setAmt(Double amt) {
        this.amt = amt;
    }

    public int getTrans_num() {
        return trans_num;
    }

    public void setTrans_num(int trans_num) {
        this.trans_num = trans_num;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getCity_population() {
        return city_population;
    }

    public void setCity_population(int city_population) {
        this.city_population = city_population;
    }

    public String getMerchant() {
        return merchant;
    }

    public void setMerchant(String merchant) {
        this.merchant = merchant;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getJob() {
        return Job;
    }

    public void setJob(String Job) {
        this.Job = Job;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    String dob;
}
