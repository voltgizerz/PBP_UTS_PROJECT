package com.example.pbp_progress_e_kelc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class MenuPengguna extends AppCompatActivity {

    private Button btnPesanP;
    private Button btnKeluar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_pengguna);

        btnPesanP = findViewById(R.id.btnPesanPgn);
        btnKeluar = findViewById(R.id.btnKeluarPengguna);

        btnPesanP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MenuPengguna.this, MenuPemesanan.class);
                startActivity(i);
            }
        });

        btnKeluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MenuPengguna.this, MainActivity.class);
                startActivity(i);
            }
        });


    }
}
