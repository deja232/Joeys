package com.example.joeys;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity {

    private EditText name,pass,email;
    private TextView loginlink;
    private Button regis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name = findViewById(R.id.register_nama);
        email = findViewById(R.id.register_email);
        pass = findViewById(R.id.regis_pword);
        loginlink = findViewById(R.id.loginlink);
        regis = findViewById(R.id.button_register);














































}
}