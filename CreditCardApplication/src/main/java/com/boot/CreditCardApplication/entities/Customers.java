package com.boot.CreditCardApplication.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
@Document("CreditCardUsers")
public class Customers {
    @Id
    Integer customer_Id;

    String firstName;
    String lastName;
    String gender;
    Date dob;


   public Customers(){

   }
   public Customers(String firstName,String lastName, Date dob, String gender){
       this.firstName=firstName;
       this.lastName=lastName;
       this.dob=dob;
       this.gender=gender;
   }
   public Customers(String firstName, String lastName, Date dob, String gender, Integer customer_Id){
       this.firstName=firstName;
       this.lastName=lastName;
       this.dob=dob;
       this.gender=gender;
       this.customer_Id=customer_Id;
   }

    public Integer getCustomer_Id() {
        return customer_Id;
    }

    public void setCustomer_Id(Integer customer_Id) {
        this.customer_Id = customer_Id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
