package com.example.kalkulator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private TextView tvHasil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tvHasil = findViewById(R.id.tv_Hasil);
        Double Hasil = getIntent().getDoubleExtra("Volume", 0);
        tvHasil.setText(String.valueOf(Hasil));
    }
}
