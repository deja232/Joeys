package com.example.joeys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import model.array;
import model.kamar;

public class checkout extends AppCompatActivity {

    private TextView satu,dua,tiga,empat,lima;
    private int toto;
    private Button chekot;
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
        chekot = findViewById(R.id.button_checkout);
        intent = getIntent();


        toto = intent.getIntExtra("IDuser",0);
        joey = intent.getParcelableArrayListExtra("data");


        int hargakamar = (int) joey.get(0);
        int lama = (int) joey.get(3) ;

        satu.setText(array.list.get(toto).getNamauser());
        dua.setText((String) joey.get(2));
        tiga.setText(String.valueOf(lama));
        empat.setText((String) joey.get(1));
        lima.setText(String.valueOf(hargakamar*lama));



        chekot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tim = new Intent(getBaseContext(),lastpage.class);
                startActivity(tim);
                finish();
            }
        });
    }
}