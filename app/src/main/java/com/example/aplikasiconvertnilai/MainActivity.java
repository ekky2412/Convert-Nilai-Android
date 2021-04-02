package com.example.aplikasiconvertnilai;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button btnSubmit;
    private TextView tvNama,tvNIM,tvNilai;
    private EditText etNama,etNIM,etNilai;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSubmit = findViewById(R.id.btnSubmit);
        etNama = findViewById(R.id.etNama);
        etNIM = findViewById(R.id.etNIM);
        etNilai = findViewById(R.id.etNilai);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sNama = etNama.getText().toString();
                String sNIM = etNIM.getText().toString();
                String sNilai = etNilai.getText().toString();


                if(TextUtils.isEmpty(sNama)){
                    etNama.setError("Nama Tidak Boleh Kosong!");
                }
                else if(TextUtils.isEmpty(sNIM)){
                    etNIM.setError("NIM Tidak Boleh Kosong!");
                }
                else if(TextUtils.isEmpty(sNilai)){
                    etNilai.setError("Nilai Tidak Boleh Kosong!");
                }
                else {
                    double nilai = Double.parseDouble(sNilai);
                    sNilai = hitungNilai(nilai);
                    setContentView(R.layout.hasil);
                    tvNama = findViewById(R.id.tvNama);
                    tvNIM = findViewById(R.id.tvNIM);
                    tvNilai = findViewById(R.id.tvNilai);

                    tvNama.setText("Nama : " + sNama);
                    tvNIM.setText("NIM : " + sNIM);
                    tvNilai.setText("Nilai : " + sNilai);

                }
            }
        });


    }

    protected String hitungNilai(double nilai){
        if (nilai > 3.66 && nilai <= 4 ){
            return "A";
        }
        else if(nilai > 3.33 && nilai <= 3.66 ){
            return "A-";
        }
        else if(nilai > 3 && nilai <= 3.33 ){
            return "B+";
        }
        else if(nilai > 2.66 && nilai <= 3 ){
            return "B";
        }
        else if(nilai > 2.33 && nilai <= 2.66 ){
            return "B-";
        }
        else if(nilai > 2 && nilai <= 2.33 ){
            return "C+";
        }
        else if(nilai > 1.66 && nilai <= 2 ){
            return "C";
        }
        else if(nilai > 1.33 && nilai <= 1.66 ){
            return "C-";
        }
        else if(nilai > 1 && nilai <= 1.33 ){
            return "D+";
        }
        else if(nilai >= 0 && nilai <= 1 ){
            return "D";
        }
        else{
            return "Nilai yang dimasukkan tidak sesuai!";
        }

    }

}