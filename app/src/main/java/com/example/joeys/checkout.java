package com.example.joeys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

import model.array;
import model.kamar;

public class checkout extends AppCompatActivity {

    private TextView satu,dua,tiga,empat,lima;
    private int toto;
    private  ArrayList joey  = new ArrayList();
    Intent intent = new Intent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        getSupportActionBar().hide();

        satu = findViewById(R.id.isinama);
        dua = findViewById(R.id.isitang);
        tiga = findViewById(R.id.isilama);
        empat = findViewById(R.id.isijen);
        lima = findViewById(R.id.isihar);
        intent = getIntent();

        toto = intent.getIntExtra("IDuser",0);
        joey = intent.getParcelableArrayListExtra("data");

        satu.setText(array.list.get(toto).getNamauser());
        dua.setText((Integer) joey.get(2));
        tiga.setText((Integer) joey.get(3));
        empat.setText((Integer) joey.get(1));
        lima.setText((Integer) joey.get(0));
    }
}