package astratech.latihanspring010.model;

import java.util.Date;

public class TransaksiPeminjamanRuangan {
    private int idTransaksi;
    private Mahasiswa mahasiswa;
    private String ruangan;
    private Date tanggalAwal;
    private Date tanggalAkhir;

    // Konstruktor, Getter, dan Setter
    public TransaksiPeminjamanRuangan(int idTransaksi, Mahasiswa mahasiswa, String ruangan, Date tanggalAwal, Date tanggalAkhir) {
        this.idTransaksi = idTransaksi;
        this.mahasiswa = mahasiswa;
        this.ruangan = ruangan;
        this.tanggalAwal = tanggalAwal;
        this.tanggalAkhir = tanggalAkhir;
    }

    public int getIdTransaksi() {
        return idTransaksi;
    }

    public void setIdTransaksi(int idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    public Mahasiswa getMahasiswa() {
        return mahasiswa;
    }

    public void setMahasiswa(Mahasiswa mahasiswa) {
        this.mahasiswa = mahasiswa;
    }

    public String getRuangan() {
        return ruangan;
    }

    public void setRuangan(String ruangan) {
        this.ruangan = ruangan;
    }

    public Date getTanggalAwal() {
        return tanggalAwal;
    }

    public void setTanggalAwal(Date tanggalAwal) {
        this.tanggalAwal = tanggalAwal;
    }

    public Date getTanggalAkhir() {
        return tanggalAkhir;
    }

    public void setTanggalAkhir(Date tanggalAkhir) {
        this.tanggalAkhir = tanggalAkhir;
    }
}
