package com.example.pbp_progress_e_kelc;

public class Pemesanan {
    private String namaPemesan;
    private String alamat;
    private String notelp;
    private String jumlah;
    private String paket;
    private String harga;


    public Pemesanan() {
    }

    public Pemesanan(String namaPemesan, String alamat, String notelp, String jumlah, String paket, String harga) {
        this.namaPemesan = namaPemesan;
        this.alamat = alamat;
        this.notelp = notelp;
        this.jumlah = jumlah;
        this.paket = paket;
        this.harga = harga;
    }

    public String getNamaPemesan() {
        return namaPemesan;
    }

    public void setNamaPemesan(String namaPemesan) {
        this.namaPemesan = namaPemesan;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNotelp() {
        return notelp;
    }

    public void setNotelp(String notelp) {
        this.notelp = notelp;
    }

    public String getJumlah() {
        return jumlah;
    }

    public void setJumlah(String jumlah) {
        this.jumlah = jumlah;
    }

    public String getPaket() {
        return paket;
    }

    public void setPaket(String paket) {
        this.paket = paket;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }
}
