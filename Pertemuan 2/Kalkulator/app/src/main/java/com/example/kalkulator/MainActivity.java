package com.example.kalkulator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnHasil, btnPindah;
    private TextView tvHasil;
    private EditText etPanjang, etLebar, etTinggi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPindah = findViewById(R.id.btnPindah);
        btnHasil = findViewById(R.id.btn_Hasil);
        tvHasil = findViewById(R.id.tv_Hasil);
        etPanjang = findViewById(R.id.et_Panjang);
        etLebar = findViewById(R.id.et_Lebar);
        etTinggi = findViewById(R.id.et_Tinggi);

        btnHasil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    double nPanjang = Double.parseDouble(etPanjang.getText().toString());
                    double nLebar = Double.parseDouble(etLebar.getText().toString());
                    double nTinggi = Double.parseDouble(etTinggi.getText().toString());

                    final Double Hasil = nPanjang * nLebar * nTinggi;

                    tvHasil.setText(String.valueOf(Hasil));

                    Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
                    intent.putExtra("Volume", Hasil);
                    startActivity(intent);
                } catch (NumberFormatException nfs) {
                    Toast.makeText(getApplicationContext(), "Field Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
                }

            }
        });

//        btnPindah.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getApplicationContext(),Main2Activity.class);
//                startActivity(intent);
//            }
//        });

    }
}
