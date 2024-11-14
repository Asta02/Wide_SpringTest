package astratech.latihanspring010.service;

import astratech.latihanspring010.model.Mahasiswa;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MahasiswaService {
    private List<Mahasiswa> mahasiswas = new ArrayList<>();

    // Menambahkan mahasiswa baru
    public Mahasiswa addMahasiswa(String nim, String nama, Date tglLahir, int jk, int status) {
        Mahasiswa mahasiswa = new Mahasiswa(nim, nama, tglLahir, jk, status);
        mahasiswas.add(mahasiswa);
        return mahasiswa;
    }

    // Mendapatkan daftar semua mahasiswa
    public List<Mahasiswa> getMahasiswas() {
        return mahasiswas;
    }

    // Mendapatkan detail mahasiswa berdasarkan NIM
    public Mahasiswa getMahasiswaByNim(String nim) {
        for (Mahasiswa mahasiswa : mahasiswas) {
            if (mahasiswa.getNimMahasiswa().equals(nim)) {
                return mahasiswa;
            }
        }
        return null;
    }

    // Mengupdate data mahasiswa berdasarkan NIM
    public Mahasiswa updateMahasiswaByNim(String nim, String nama, Date tglLahir, int jk, int status) {
        for (Mahasiswa mahasiswa : mahasiswas) {
            if (mahasiswa.getNimMahasiswa().equals(nim)) {
                mahasiswa.setNamaMahasiswa(nama);
                mahasiswa.setTanggalLahir(tglLahir);
                mahasiswa.setJenisKelamin(jk);
                mahasiswa.setStatus(status);

                return mahasiswa;
            }
        }

        return null;
    }

    // Menghapus data mahasiswa berdasarkan NIM
    public boolean deleteMahasiswaByNim(String nim) {
        Mahasiswa mahasiswaToRemove = null;
        for (Mahasiswa mahasiswa : mahasiswas) {
            if (mahasiswa.getNimMahasiswa().equals(nim)) {
                mahasiswaToRemove = mahasiswa;
                break;
            }
        }
        if (mahasiswaToRemove != null) {
            mahasiswas.remove(mahasiswaToRemove);
            return true;
        }
        return false;
    }
}
