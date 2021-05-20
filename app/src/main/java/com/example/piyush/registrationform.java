package com.example.piyush;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SlidingDrawer;
import android.util.Patterns;
import android.widget.Toast;
import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import com.google.common.collect.Range;
import static com.basgeekball.awesomevalidation.ValidationStyle.UNDERLABEL;

public class registrationform extends AppCompatActivity implements View.OnClickListener{

    private EditText UserName;
    private EditText ContactNumber;
    private EditText AdharNumber;
    private EditText EmailAddress;
    private EditText Password;
    private EditText ConfrimPassword;
    private  Button Register;
    private AwesomeValidation awesomeValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrationform);
        getSupportActionBar().setTitle("Registeration Form");

        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        initView();
    }
    private void initView() {
        UserName = (EditText) findViewById(R.id.etusername);
        ContactNumber = (EditText) findViewById(R.id.etcontactnumber);
        AdharNumber = (EditText) findViewById(R.id.etadharnumber);
        EmailAddress = (EditText) findViewById(R.id.etemailaddress);
        Password = (EditText) findViewById(R.id.etpassword);
        ConfrimPassword = (EditText) findViewById(R.id.etconfirmpassword);
        Register = (Button) findViewById(R.id.btregister);
        Register.setOnClickListener(this);
        addValidationToViews();
    }

    private void addValidationToViews() {

        awesomeValidation.addValidation(this, R.id.etusername, RegexTemplate.NOT_EMPTY, R.string.invalid_UserName);
        awesomeValidation.addValidation(this, R.id.etemailaddress, Patterns.EMAIL_ADDRESS, R.string.invalid_EmailAddress);
        String regexPassword = ".{8,}";
        awesomeValidation.addValidation(this, R.id.etpassword, regexPassword, R.string.invalid_Password);
        awesomeValidation.addValidation(this, R.id.etconfirmpassword, R.id.etpassword, R.string.invalid_ConfirmPassword);
        awesomeValidation.addValidation(this, R.id.etcontactnumber, "^[+]?[0-9]{10,13}$", R.string.invalid_ContactNumber);
    }

    private void registerForm() {
        if (awesomeValidation.validate()) {
            Toast.makeText(this, "Successfully Registered!", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btregister:
                registerForm();
                break;
        }
    }
    public void perform_action(View v)
    {
        startActivity(new Intent(getApplicationContext(),loginform.class));
    }
}