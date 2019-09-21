package com.example.pbp_progress_e_kelc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DaftarPengguna extends AppCompatActivity {

    EditText email;
    EditText password;
    EditText nama;
    Button signup;
    Button login;
    FirebaseDatabase database;
    DatabaseReference ref;
    Pengguna pengguna;

    FirebaseAuth firebaseAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_pengguna);

        nama = findViewById(R.id.nama);
        email = findViewById(R.id.email);
        password = findViewById(R.id.kataSandi);
        signup = (Button) findViewById(R.id.btnDaftar);
        login = findViewById(R.id.btnMasukRegistrasi);

        database = FirebaseDatabase.getInstance();
        ref=database.getReference("Pengguna");
        pengguna = new Pengguna();

        firebaseAuth = FirebaseAuth.getInstance();


            signup.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {

                    if (nama.getText().toString().trim().length() <= 0 || email.getText().toString().trim().length() <= 0  || password.getText().toString().trim().length() <= 0  ) {
                        Toast.makeText(DaftarPengguna.this, "Masih ada data yang kosong!", Toast.LENGTH_SHORT).show();
                    }else {
                        final  FirebaseUser user = firebaseAuth.getCurrentUser();
                    firebaseAuth.createUserWithEmailAndPassword(email.getText().toString(), password.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (task.isSuccessful()) {
                                firebaseAuth.getCurrentUser().sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful()) {
                                            getValues();
                                            ref.child(user.getUid()).setValue(pengguna);
                                            Toast.makeText(DaftarPengguna.this, "Registrasi Berhasil, Silahkan cek Email anda untuk mengaktifkan akun anda!", Toast.LENGTH_LONG).show();
                                            email.setText("");
                                            password.setText("");
                                            nama.setText("");
                                            startActivity(new Intent(DaftarPengguna.this, emailVerif.class));
                                        } else {
                                            Toast.makeText(DaftarPengguna.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                                        }

                                    }
                                });
                            } else {
                                Toast.makeText(DaftarPengguna.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                            }
                        }
                    });}
                }
            });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DaftarPengguna.this, LoginPengguna.class));
            }
        });


    }

    private void getValues()
    {
        pengguna.setNama(nama.getText().toString());
        pengguna.setEmail(email.getText().toString());
        pengguna.setPassword(password.getText().toString());
    }


}

