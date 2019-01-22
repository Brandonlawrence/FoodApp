package com.g.android.foodapp;

import java.util.ArrayList;

public class Customer {

    private String customerName;
    private String customerEmail;
    private int customerAge;
    private int customerPhoneNumber;

    private ArrayList<Customer> customerList;

    public Customer(){

        customerName = "";
        customerEmail = "";
        customerAge = 0;
        customerPhoneNumber = 0;


    }




    public ArrayList<Customer> getCustomerList() {
        return customerList;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public int getCustomerAge() {
        return customerAge;
    }

    public void setCustomerAge(int customerAge) {
        this.customerAge = customerAge;
    }

    public int getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public void setCustomerPhoneNumber(int customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }

    public void setCustomerList(ArrayList<Customer> customerList) {
        this.customerList = customerList;
    }
}
