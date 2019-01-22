package com.g.android.foodapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.w3c.dom.Text;


public class customerProfile extends AppCompatActivity {

    TextView cUserHeader;
    TextView cProfileNameEmail;
    Button cProfileMainMenuButton;
    Button cProfileBackButton;
    Button cSignOutButton;

    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_profile);





        cProfileMainMenuButton = (Button) findViewById(R.id.cProfileMainMenuButton);
        cProfileBackButton = (Button) findViewById(R.id.cProfileBackButton);
        cSignOutButton = (Button) findViewById(R.id.cSignOutButton);
        cUserHeader = (TextView) findViewById(R.id.cProfileHeader);
        cProfileNameEmail = (TextView) findViewById(R.id.cProfileEmailText);

        headerChange();
        cProfileMainMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startMainMenu = new Intent(customerProfile.this, MainActivity.class);
                startActivity(startMainMenu);
            }
        });

        cProfileBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goBack = new Intent(customerProfile.this, MainActivity.class);
                startActivity(goBack);
            }
        });

        cSignOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebaseAuth = FirebaseAuth.getInstance();
                FirebaseUser user = firebaseAuth.getCurrentUser();
                firebaseAuth.signOut();
                Intent startMainMenu = new Intent(customerProfile.this, MainActivity.class);
                startActivity(startMainMenu);
                Log.d("BRANDON",  user.getEmail() + " Has Logged Out!");
            }
        });


    }

    private void headerChange(){
        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser user = firebaseAuth.getCurrentUser();

        cUserHeader.setText(String.valueOf(user.getEmail()) + " Profile");
        cProfileNameEmail.setText(String.valueOf(user.getEmail()));


    }
}
