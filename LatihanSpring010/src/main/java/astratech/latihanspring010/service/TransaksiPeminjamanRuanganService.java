package astratech.latihanspring010.service;

import astratech.latihanspring010.model.Mahasiswa;
import astratech.latihanspring010.model.TransaksiPeminjamanRuangan;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TransaksiPeminjamanRuanganService {
    private List<TransaksiPeminjamanRuangan> transaksiList = new ArrayList<>();

    // Menambahkan transaksi peminjaman ruangan baru
    public TransaksiPeminjamanRuangan addTransaksi(int idTransaksi, Mahasiswa mahasiswa, String ruangan, Date tanggalAwal, Date tanggalAkhir) {
        TransaksiPeminjamanRuangan transaksi = new TransaksiPeminjamanRuangan(idTransaksi, mahasiswa, ruangan, tanggalAwal, tanggalAkhir);
        transaksiList.add(transaksi);
        return transaksi;
    }

    // Mendapatkan daftar semua transaksi peminjaman ruangan
    public List<TransaksiPeminjamanRuangan> getAllTransaksi() {
        return transaksiList;
    }

    // Mendapatkan detail transaksi peminjaman ruangan berdasarkan ID transaksi
    public TransaksiPeminjamanRuangan getTransaksiById(int idTransaksi) {
        for (TransaksiPeminjamanRuangan transaksi : transaksiList) {
            if (transaksi.getIdTransaksi() == idTransaksi) {
                return transaksi;
            }
        }
        return null;
    }
}
