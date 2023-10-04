package com.example.newapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText mobileEd, passwordEd;
    Button loginBtn;

    TextView txt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mobileEd = findViewById(R.id.mobile_edittext);
        passwordEd = findViewById(R.id.password_edittext);
        loginBtn = findViewById(R.id.LOGIN);
        txt = findViewById(R.id.admin);

        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Admin Panel", Toast.LENGTH_SHORT).show();
                //intent
                Intent View = new Intent(MainActivity.this, AdminActivity.class);
                startActivity(View);
            }
        });


        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mobile = mobileEd.getText().toString();
                String password = passwordEd.getText().toString();

                if (!mobile.isEmpty()) {
                    //continue
                    if (!password.isEmpty()) {

                        if (mobileEd.length() == 10) {
                            if (password.equals("0987654321")) {
                                //success
                                Toast.makeText(MainActivity.this, "Login Successfull", Toast.LENGTH_SHORT).show();
                                //intent
                                Intent View = new Intent(MainActivity.this, HomeActivity.class);
                                startActivity(View);
                                finish();
                            } else {
                                passwordEd.setError("invalid password");
                            }
                        } else {
                            mobileEd.setError("Enter 10 Digits");
                            Toast.makeText(MainActivity.this, "Enter Valid Mobile Number", Toast.LENGTH_SHORT).show();
                        }
                        //continue
                        Toast.makeText(MainActivity.this, "Mobile:" + mobile + "\n Password:" + password, Toast.LENGTH_SHORT).show();
                    } else {
                        //empty
                        Toast.makeText(MainActivity.this, "Password is required", Toast.LENGTH_SHORT).show();
                        passwordEd.setError("Password is Required");
                    }
                } else {
                    //empty
                    Toast.makeText(MainActivity.this, "Mobile is Required", Toast.LENGTH_SHORT).show();
                    mobileEd.setError("Mobile is Required");
                }
            }
        });

    }
}