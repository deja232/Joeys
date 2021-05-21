package com.example.joeys;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import model.account;

public class Register extends AppCompatActivity {

    private EditText name,pass,email;
    private TextView loginlink;
    private Button regis;
    private boolean em,pas,uname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().hide();

        name = findViewById(R.id.register_nama);
        email = findViewById(R.id.register_email);
        pass = findViewById(R.id.regis_pword);
        loginlink = findViewById(R.id.loginlink);
        regis = findViewById(R.id.button_register);
        final Loadlog loading = new Loadlog(Register.this);

        loginlink.setEnabled(false);

        name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


                String registernama = name.getText().toString().trim();
                if (!registernama.isEmpty()) {
                    uname = true;
                }
                if (em == true && pas == true && uname == true) {
                    loginlink.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        pass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


                String registerpass = pass.getText().toString().trim();
                if (!registerpass.isEmpty()) {
                    pas = true;
                }
                if (em == true && pas == true && uname == true) {
                    loginlink.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                String registeremail = email.getText().toString().trim();
                if (!registeremail.isEmpty()) {
                    em = true;
                }
                if (em == true && pas == true && uname == true) {
                    loginlink.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user = name.getText().toString().trim();
                String emaill = email.getText().toString().trim();
                String pword = pass.getText().toString().trim();
                account temp = new account(user,emaill,pword);
                loading.dialogalert();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (!user.isEmpty() && !emaill.isEmpty() && !pword.isEmpty()) {
                            loading.gone();
                            Intent intent = new Intent();
                            intent.putExtra("needed",temp);
                            setResult(200,intent);
                            finish();
                            finish();
                        } else {
                            Toast.makeText(getApplicationContext(), "Register Failed, Try Again!", Toast.LENGTH_SHORT).show();
                        }
                    }
                },3000);

            }
        });
        loginlink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
}
}

