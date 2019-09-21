package com.example.pbp_progress_e_kelc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class emailVerif extends AppCompatActivity {

    private Button btnlanjut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_verif);

        btnlanjut =findViewById(R.id.buttonLanjut);

        btnlanjut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent (emailVerif.this,LoginPengguna.class);
                startActivity(i);
            }
        });
    }
}
