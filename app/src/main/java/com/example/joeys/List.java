package com.example.joeys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class List extends AppCompatActivity {

    private ImageView single,doublee,king,sut,psut;
    private TextView s1,d2,k3,s4,ps5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        getSupportActionBar().hide();

        single = findViewById(R.id.sb);
        doublee = findViewById(R.id.db);
        king = findViewById(R.id.ks);
        sut = findViewById(R.id.s);
        psut = findViewById(R.id.ps);
        s1 = findViewById(R.id.sbt);
        d2 = findViewById(R.id.dbt);
        k3 = findViewById(R.id.kst);
        s4 = findViewById(R.id.st);
        ps5 = findViewById(R.id.pst);

        single.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),form.class);
                startActivity(intent);
                finish();
            }
        });
        doublee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),form.class);
                startActivity(intent);
                finish();
            }
        });
        king.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),form.class);
                startActivity(intent);
                finish();
            }
        });
        sut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),form.class);
                startActivity(intent);
                finish();
            }
        });
        psut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),form.class);
                startActivity(intent);
                finish();
            }
        });
        s1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),form.class);
                startActivity(intent);
                finish();
            }
        });
        d2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),form.class);
                startActivity(intent);
                finish();
            }
        });
        k3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),form.class);
                startActivity(intent);
                finish();
            }
        });
        s4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),form.class);
                startActivity(intent);
                finish();
            }
        });
        ps5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),form.class);
                startActivity(intent);
                finish();
            }
        });
    }
}