package com.example.pbp_progress_e_kelc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MenuPemesanan extends AppCompatActivity {

    private Button btnPesan;
    private EditText namaPemesan;
    private EditText alamat;
    private EditText notelp;
    private EditText jumlah;
    private Spinner  paket;
    private Integer tempHarga1;
    private Integer jumlah1;
    private Integer tempJumlah1;
    private String  harga;
    private DatabaseReference mDatabase;

    FirebaseDatabase database;
    DatabaseReference ref;
    Pemesanan pemesanan;


    FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_pemesanan);

        namaPemesan = findViewById(R.id.etNamaPemesan);
        alamat = findViewById(R.id.etAlamat);
        notelp = findViewById(R.id.etNotelp);
        jumlah = findViewById(R.id.etJumlahPesanan);
        paket= (Spinner) findViewById(R.id.spinnerKategoriPaket);
        btnPesan = findViewById(R.id.btnPesan);


        firebaseAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        ref=database.getReference("Pemesanan");
        pemesanan = new Pemesanan();


        btnPesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getValues();
                FirebaseUser user = firebaseAuth.getCurrentUser();
                ref.child(user.getUid()).setValue(pemesanan);
                Toast.makeText(MenuPemesanan.this, "Data Pemesanan Anda berhasil ditambahkan!", Toast.LENGTH_LONG).show();
            }
        });

    }

    private void getValues()
    {
        if(paket.getSelectedItem().toString().equals("Paket Standar (Nasi+1 Lauk+1 Sayur+Air Mineral)")){
            int total =Integer.parseInt(jumlah.getText().toString());
            int tempHarga1=13000*total;
            harga = Integer.toString(tempHarga1);
        } else if(paket.getSelectedItem().toString().equals("Paket Silver (Nasi+1 Sayur+2 Lauk+Air Mineral)")){
            int total =Integer.parseInt(jumlah.getText().toString());
            int tempHarga1=15000*total;
            harga = Integer.toString(tempHarga1);
        } else if(paket.getSelectedItem().toString().equals("Paket Gold (Nasi+2 Sayur+2 Lauk+Air Mineral+Aneka Jus)")){
            int total =Integer.parseInt(jumlah.getText().toString());
            int tempHarga1=20000*total;
            harga = Integer.toString(tempHarga1);

        } else if(paket.getSelectedItem().toString().equals("Paket Platinum (Nasi+3 Sayur+2 Lauk+Air Mineral+Aneka Jus)")){
            int total =Integer.parseInt(jumlah.getText().toString());
            int tempHarga1=25000*total;
            harga = Integer.toString(tempHarga1);
        }

        pemesanan.setNamaPemesan(namaPemesan.getText().toString());
        pemesanan.setAlamat(alamat.getText().toString());
        pemesanan.setNotelp(notelp.getText().toString());
        pemesanan.setPaket(paket.getSelectedItem().toString());
        pemesanan.setHarga(harga);
        pemesanan.setJumlah(jumlah.getText().toString());
    }
}



