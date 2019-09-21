package com.example.pbp_progress_e_kelc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginPengguna extends AppCompatActivity {

    EditText userEmail;
    EditText userPass;
    Button userLogin;
    Button btnDaftar;

    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_pengguna);


        userEmail = findViewById(R.id.email);
        userPass = findViewById(R.id.kataSandi);
        userLogin = findViewById(R.id.btnMasukPengguna);
        btnDaftar=findViewById(R.id.btnDaftarPengguna);

        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginPengguna.this, DaftarPengguna.class);
                startActivity(i);
            }
        });


        firebaseAuth = FirebaseAuth.getInstance();

        userLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(userEmail.getText().toString().trim().length() <= 0  && userPass.getText().toString().trim().length() <= 0  ) {
                    Toast.makeText(LoginPengguna.this, "Email dan Kata Sandi masih Kosong!", Toast.LENGTH_SHORT).show();
                } else if(userEmail.getText().toString().trim().length() <= 0)
                {
                    Toast.makeText(LoginPengguna.this, "Email masih Kosong!", Toast.LENGTH_SHORT).show();
                } else if (userPass.getText().toString().trim().length() <= 0)
                {
                    Toast.makeText(LoginPengguna.this, "Kata Sandi masih Kosong!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                firebaseAuth.signInWithEmailAndPassword(userEmail.getText().toString(), userPass.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                if(task.isSuccessful()){
                                    if(firebaseAuth.getCurrentUser().isEmailVerified()){
                                        startActivity(new Intent(LoginPengguna.this, MenuPengguna.class));
                                    }else{
                                        Toast.makeText(LoginPengguna.this, "Silahkan Buka Email Anda dan Verifikasi Email Anda!", Toast.LENGTH_LONG).show();
                                    }
                                }else{
                                    Toast.makeText(LoginPengguna.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                                }
                            }
                });
                }

            }
        });
    }
}