package com.example.pbp_progress_e_kelc;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Pengguna {
    private String nama;
    private String email;
    private String password;

    public Pengguna() {
    }

    public Pengguna(String nama, String email, String password) {
        this.nama = nama;
        this.email = email;
        this.password = password;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
