package com.example.joeys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class form extends AppCompatActivity {

    private ImageView back;
    private EditText stay,kapan;
    private Button subbut;
    private boolean tetap,tanggal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        getSupportActionBar().hide();

        back = findViewById(R.id.backk);
        stay = findViewById(R.id.stay);
        kapan = findViewById(R.id.date);
        subbut = findViewById(R.id.Submit);

        subbut.setEnabled(false);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent(getBaseContext(), List.class);
                    startActivity(intent);
                    finish();
                }
            });
        stay.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String regisstay = stay.getText().toString().trim();
                if (!regisstay.isEmpty()) {
                    tetap = true;
                }
                if (tetap == true && tanggal == true ) {
                    subbut.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        kapan.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String registang = kapan.getText().toString().trim();
                if (!registang.isEmpty()) {
                    tanggal = true;
                }
                if (tetap == true && tanggal == true ) {
                    subbut.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        subbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}