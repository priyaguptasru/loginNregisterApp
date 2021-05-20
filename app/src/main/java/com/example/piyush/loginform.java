package com.example.piyush;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class loginform extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginform);
        getSupportActionBar().setTitle("Login Form");
    }
    public void btn_register(View view)
    {
        startActivity(new Intent(getApplicationContext(), registrationform.class));
    }
}