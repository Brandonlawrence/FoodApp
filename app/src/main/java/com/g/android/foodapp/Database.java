package com.g.android.foodapp;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Database {


    private FirebaseAuth mAuth;

    public void writeNewUser(String email, String password, String name, int age, int phoneNumber, DatabaseReference mDatabase) {
        Customer customer = new Customer();

        customer.setCustomerEmail(email);
        customer.setCustomerAge(age);
        customer.setCustomerName(name);
        customer.setCustomerPhoneNumber(phoneNumber);

        mDatabase.child("users").child(name).setValue(customer);
    }

}
