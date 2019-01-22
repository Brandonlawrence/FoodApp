package com.g.android.foodapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class customer_login extends AppCompatActivity {

    Database databaseConnect = new Database();
    EditText customerEmailField;
    EditText customerPasswordField;
    TextView customerRegisterTextView;
    Button customerLoginButton;
    private DatabaseReference mDatabase;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_login);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        firebaseAuth = FirebaseAuth.getInstance();
        customerRegisterTextView = (TextView) findViewById(R.id.customerRegisterTextView);
        customerLoginButton = (Button) findViewById(R.id.customerLoginButton);
        customerEmailField = (EditText)findViewById(R.id.customerEmailField);
        customerPasswordField = (EditText)findViewById(R.id.customerPasswordField);


        customerRegisterTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startCustomerRegister = new Intent(customer_login.this, customer_register.class);
                startActivity(startCustomerRegister);
            }
        });
        customerLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = customerEmailField.getText().toString();
                String password  = customerPasswordField.getText().toString();

                Log.d("BRANDON", "The email for this user is " + email + " The password for this user is " + password);
                createUser(email, password);
                databaseConnect.writeNewUser(email, password, "Brandon", 24, 20, mDatabase);

            }
        });
    }
    private void createUser(String email, String password) {

        email = customerEmailField.getText().toString();
        password = customerPasswordField.getText().toString();

        if (!email.contains("@")) {
            Toast.makeText(getApplicationContext(), "You need a @",
                    Toast.LENGTH_LONG).show();
        } else if (!email.contains("com")) {
            Toast.makeText(getApplicationContext(), "You're missing a .com",
                    Toast.LENGTH_LONG).show();
        } else if (email == "") {
            Toast.makeText(getApplicationContext(), "Please enter your Email in the Email Field",
                    Toast.LENGTH_LONG).show();
        } else if (email.length() < 6) {
            Toast.makeText(getApplicationContext(), "Your Email Is Too Short",
                    Toast.LENGTH_LONG).show();
        } else if (password == "") {
            Toast.makeText(getApplicationContext(), "Please enter your Password in the Password Field",
                    Toast.LENGTH_LONG).show();
        } else if (password.length() <= 6) {
            Toast.makeText(getApplicationContext(), "Your Password Is Too Short",
                    Toast.LENGTH_LONG).show();
        } else {

            firebaseAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Log.d("BRANDON", "createUserWithEmail:success");
                                FirebaseUser user = firebaseAuth.getCurrentUser();
                                Intent startUserProfile = new Intent(customer_login.this, customerProfile.class);
                                startUserProfile.putExtra("UniqueUser", user);
                                startActivity(startUserProfile);
                                Log.d("BRANDON", "Sign in SUCCESS!");
                            } else {
                                // If sign in fails, display a message to the user.
                                Log.w("BRANDON", "createUserWithEmail:failure", task.getException());

                            }

                            // ...
                        }
                    });
        }
    }
    private void validateForm(){

        String email = customerEmailField.getText().toString();
        String password  = customerPasswordField.getText().toString();

        if (!email.contains("@")) {
            Toast.makeText(getApplicationContext(), "You need a @",
                    Toast.LENGTH_LONG).show();
        } else if (!email.contains("mail.com")) {
            Toast.makeText(getApplicationContext(), "You're missing a .com",
                    Toast.LENGTH_LONG).show();
        } else if (email == "") {
            Toast.makeText(getApplicationContext(), "Please enter your Email in the Email Field",
                    Toast.LENGTH_LONG).show();
        } else if (email.length() < 6) {
            Toast.makeText(getApplicationContext(), "Your Email Is Too Short",
                    Toast.LENGTH_LONG).show();
        } else if (password  == "") {
            Toast.makeText(getApplicationContext(), "Please enter your Password in the Password Field",
                    Toast.LENGTH_LONG).show();
        } else if (password.length() < 6) {
            Toast.makeText(getApplicationContext(), "Your Password Is Too Short",
                    Toast.LENGTH_LONG).show();
        } else {

        }


    }
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = firebaseAuth.getCurrentUser();

    }





}
