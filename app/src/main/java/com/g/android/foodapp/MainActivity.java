package com.g.android.foodapp;

import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    Button customerButton;
    Button settingsButton;
    Button chefButton;
    private FirebaseAuth firebaseAuth;

    Customer thisCustomer = new Customer();

    Chef thisChef = new Chef();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue("Hello, World!");

        customerButton = (Button) findViewById(R.id.customerButton);
        settingsButton = (Button) findViewById(R.id.settingsButton);
        chefButton = (Button) findViewById(R.id.chefButton);


        customerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebaseAuth = FirebaseAuth.getInstance();
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if(user == null){
                    Intent startCustomerLogin = new Intent(MainActivity.this, customer_login.class);
                    startActivity(startCustomerLogin);
                } else {
                    Intent startCustomerProfile = new Intent(MainActivity.this, customerProfile.class);
                    startActivity(startCustomerProfile);
                }

            }
        });

        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        chefButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startLogin = new Intent(MainActivity.this, chef_login.class);
                startActivity(startLogin);
            }
        });


        thisCustomer.setCustomerAge(40);

        Log.d("BRANDON","The customer age is "  + thisCustomer.getCustomerAge());






    }
}
