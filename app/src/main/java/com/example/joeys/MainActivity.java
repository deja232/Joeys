package com.example.joeys;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.regex.Pattern;

import model.account;
import model.array;

import static model.array.list;

public class MainActivity extends AppCompatActivity {

    private EditText login_email, login_password;
    private Button button_login;
    private TextView signuplink;
    private Boolean validateEmail , validatePassword = false;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        login_email = findViewById(R.id.login_email);
        login_password = findViewById(R.id.login_password);
        button_login = findViewById(R.id.button_login);
        signuplink = findViewById(R.id.signuplink);
        intent = getIntent();


        signuplink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), Register.class);
                startActivity(intent);
                finish();
            }
        });

        button_login.setEnabled(false);
        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = login_email.getText().toString().trim();
                String password = login_password.getText().toString().trim();
                ArrayList<account> coba = array.list;
                if (validateEmail && validatePassword) {
                    for (int i = 0; i <coba.size(); i++) {
                            account tempuser = coba.get(i);
                        if ((tempuser.getEmailuser().equalsIgnoreCase(email)) && tempuser.getPassword().equalsIgnoreCase(password)) {
                            Intent intent = new Intent(getBaseContext(), List.class);
                            intent.putExtra("IDuser", tempuser);
                            startActivity(intent);
                            Toast.makeText(getApplicationContext(), "Successfully Login", Toast.LENGTH_SHORT).show();
                            break;
                        } else {
                            Toast.makeText(getApplicationContext(), "Login Failed, Please Try Again..", Toast.LENGTH_SHORT).show();
                        }
                    }
                } else {
                    login_email.setError("Please correct the email column");
                    login_password.setError("Please correct the password column");
                }
            }
        });
        login_email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String email = login_email.getText().toString().trim();
                Pattern EMAIL_ADDRESS_PATTERN = Pattern.compile("[a-zA-Z0-9+._%-+]{1,256}" + "@"
                        + "[a-zA-Z0-9][a-zA-Z0-9-]{0,64}" + "(" + "."
                        + "[a-zA-Z0-9][a-zA-Z0-9-]{0,25}" + ")+");

                if (email.isEmpty()) {
                    login_email.setError("Please fill the email column");
                    validateEmail = false;
                } else {
                    if (!EMAIL_ADDRESS_PATTERN.matcher(email).matches()){
                        login_email.setError("Wrong format email");
                        validateEmail = false;
                    }else{
                        login_email.setError(null);
                        validateEmail = true;
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (validateEmail && validatePassword) {
                    button_login.setEnabled(true);
                    button_login.setClickable(true);
                }
            }
        });

        login_password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String password = login_password.getText().toString().trim();
                Pattern PASSWORD_PATTERN = Pattern.compile("[a-zA-Z0-9\\!\\@\\#\\$]{0,20}");

                if (password.isEmpty()) {
                    login_password.setError("Password Required");
                    validatePassword = false;
                } else {
                    if (password.length() < 5 || password.length() > 20){
                        login_password.setError("Password must be 5 to 20 characters");
                        validatePassword = false;
                    }else{
                        login_password.setError(null);
                        validatePassword = true;
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                if(validateEmail && validatePassword){
                    button_login.setEnabled(true);
                    button_login.setClickable(true);
                }

            }
        });
    }
}