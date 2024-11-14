package astratech.latihanspring010.model;

import java.util.Date;

public class Mahasiswa {
    private String nimMahasiswa;
    private String namaMahasiswa;
    private Date tanggalLahir;
    private int jenisKelamin;
    private int status;

    // Konstruktor, Getter, dan Setter
    public Mahasiswa(String nimMahasiswa, String namaMahasiswa, Date tanggalLahir, int jenisKelamin, int status) {
        this.nimMahasiswa = nimMahasiswa;
        this.namaMahasiswa = namaMahasiswa;
        this.tanggalLahir = tanggalLahir;
        this.jenisKelamin = jenisKelamin;
        this.status = status;
    }

    public String getNimMahasiswa() {
        return nimMahasiswa;
    }

    public void setNimMahasiswa(String nimMahasiswa) {
        this.nimMahasiswa = nimMahasiswa;
    }

    public String getNamaMahasiswa() {
        return namaMahasiswa;
    }

    public void setNamaMahasiswa(String namaMahasiswa) {
        this.namaMahasiswa = namaMahasiswa;
    }

    public Date getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(Date tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public int getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(int jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
