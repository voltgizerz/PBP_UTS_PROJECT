package com.example.pbp_progress_e_kelc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuAdmin extends AppCompatActivity {

    private Button btnDaftarPesanan;
    private Button btnKeluar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_admin);

        btnDaftarPesanan = (Button) findViewById(R.id.btnDaftarPesanan);
        btnDaftarPesanan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent (MenuAdmin.this,ListPemesananAdmin.class);
                startActivity(i);
            }
        });

        btnKeluar = (Button) findViewById(R.id.btnKeluarAdmin);
        btnKeluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent (MenuAdmin.this,MainActivity.class);
                startActivity(i);
            }
        });
    }
}
