package com.example.pbp_progress_e_kelc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginAdmin extends AppCompatActivity {

    private Button btnMasukAdmin;
    private EditText ed1;
    private EditText ed2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_admin);

        ed1 = (EditText)findViewById(R.id.email2);
        ed2 = (EditText)findViewById(R.id.kataSandi2);

        btnMasukAdmin = (Button) findViewById(R.id.btnMasukAdmin);
        btnMasukAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ed1.getText().toString().equals("admin") && ed2.getText().toString().equals("admin")) {
                    Toast.makeText(getApplicationContext(), "Berhasil Login Admin...",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginAdmin.this, MenuAdmin.class));

                }else{
                    Toast.makeText(getApplicationContext(), "Username atau Password Salah!",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}