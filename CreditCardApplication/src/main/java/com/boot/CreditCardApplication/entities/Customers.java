package com.boot.CreditCardApplication.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
@Document("CreditCardUsers")
public class Customers {
    @Id
    String customer_Id;
    String first;
    String last;
    String gender;
    Date dob;


   public Customers(){

   }
   public Customers(String firstName,String lastName, Date dob, String gender){
       this.first=firstName;
       this.last=lastName;
       this.dob=dob;
       this.gender=gender;
   }
   public Customers(String firstName, String lastName, Date dob, String gender, String customer_Id){
       this.first=firstName;
       this.last=lastName;
       this.dob=dob;
       this.gender=gender;
       this.customer_Id=customer_Id;
   }

    public String getCustomer_Id() {
        return customer_Id;
    }

    public void setCustomer_Id(String customer_Id) {
        this.customer_Id = customer_Id;
    }

    public String getFirstName() {
        return first;
    }

    public void setFirstName(String firstName) {
        this.first = firstName;
    }

    public String getLastName() {
        return last;
    }

    public void setLastName(String lastName) {
        this.last = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
}
