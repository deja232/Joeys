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

import java.util.regex.Pattern;

import model.account;
import model.array;

public class MainActivity extends AppCompatActivity {

    private EditText login_email, login_password;
    private Button button_login;
    private TextView signuplink;
    private Boolean validateEmail, validatePassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        login_email = findViewById(R.id.login_email);
        login_password = findViewById(R.id.login_password);
        button_login = findViewById(R.id.button_login);
        signuplink = findViewById(R.id.signuplink);
        validateEmail = false;
        validatePassword = false;

        signuplink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), Register.class);
                startActivity(intent);
            }
        });

        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = login_email.getText().toString().trim();
                String password = login_password.getText().toString().trim();

                if (validateEmail && validatePassword) {
                    for (int i = 0; i < array.list.size(); i++) {
                        account tempuser = array.list.get(i);
                        if ((tempuser.getNamauser().equalsIgnoreCase(email) || tempuser.getEmailuser().equalsIgnoreCase(email)) && tempuser.getPassword().equalsIgnoreCase(password)) {
                            Intent intent = new Intent(getBaseContext(), List.class);
                            intent.putExtra("IDuser", tempuser);
                            finish();
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
                        login_email.setError("");
                        validateEmail = true;
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = login_email.getText().toString().trim();
                String password = login_password.getText().toString().trim();

                if (validateEmail && validatePassword) {
                    for (int i = 0; i < array.list.size(); i++) {
                        account tempuser = array.list.get(i);
                        if ((tempuser.getNamauser().equalsIgnoreCase(email) || tempuser.getEmailuser().equalsIgnoreCase(email)) && tempuser.getPassword().equalsIgnoreCase(password)) {
                            Intent intent = new Intent(getBaseContext(), List.class);
                            intent.putExtra("IDuser", tempuser);
                            finish();
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
                        login_email.setError("");
                        validateEmail = true;
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

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
                    if (password.length() < 8 || password.length() > 20){
                        login_password.setError("Password must be 8 to 20 characters");
                        validatePassword = false;
                    }else{
                        login_password.setError("");
                        validatePassword = true;
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

}