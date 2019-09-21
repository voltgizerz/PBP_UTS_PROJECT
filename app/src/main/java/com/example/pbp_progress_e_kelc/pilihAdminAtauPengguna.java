package com.example.pbp_progress_e_kelc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class pilihAdminAtauPengguna extends AppCompatActivity {

    private Button btnAdmin;
    private Button btnPengguna;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilih_admin_atau_pengguna);

        btnAdmin = (Button) findViewById(R.id.btnAdmin);
        btnAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent (pilihAdminAtauPengguna.this,LoginAdmin.class);
                startActivity(i);
            }
        });

        btnPengguna = (Button) findViewById(R.id.btnPengguna);
        btnPengguna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent (pilihAdminAtauPengguna.this,LoginPengguna.class);
                startActivity(i);
            }
        });
    }
}
