package astratech.latihanspring010.controller;

import astratech.latihanspring010.model.Mahasiswa;
import astratech.latihanspring010.model.TransaksiPeminjamanRuangan;
import astratech.latihanspring010.service.MahasiswaService;
import astratech.latihanspring010.service.TransaksiPeminjamanRuanganService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class TransaksiPeminjamanRuanganController {
    @Autowired
    private TransaksiPeminjamanRuanganService ruanganService;
    @Autowired
    private MahasiswaService mahasiswaService;

    // Mendapatkan daftar semua transaksi ruangan
    @GetMapping("/getTransaksiRuangans")
    public List<TransaksiPeminjamanRuangan> getTransaksiRuangans() {
        List<TransaksiPeminjamanRuangan> transaksiPeminjamanRuangans = ruanganService.getAllTransaksi();
        return transaksiPeminjamanRuangans;
    }

    // Menambahkan transaksi peminjaman ruangan baru
    @PostMapping("/addPeminjaman")
    public ModelAndView addTransaksiRuangan(@RequestParam(value = "idTransaksi") int idTransaksi,
                                                          @RequestParam(value = "mahasiswa") String mahasiswa,
                                                          @RequestParam(value = "ruangan") String ruangan,
                                                          @RequestParam(value = "tanggalAwal") String tanggalAwal,
                                                          @RequestParam(value = "tanggalAkhir") String tanggalAkhir) throws ParseException {
        Mahasiswa mahasiswa1 = mahasiswaService.getMahasiswaByNim(mahasiswa);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        Date tglAwal = sdf.parse(tanggalAwal);
        Date tglAkhir = sdf.parse(tanggalAkhir);

        TransaksiPeminjamanRuangan transaksiPeminjamanRuangan = ruanganService.addTransaksi(idTransaksi, mahasiswa1, ruangan, tglAwal, tglAkhir);

        ModelAndView mav = new ModelAndView("redirect:/transaksiPeminjamanRuangan/index.html"); // Mengarahkan ke halaman /transaksiPeminjamanRuangan/index.html
        return mav;
    }

    // Mendapatkan detail transaksi peminjaman ruangan berdasarkan ID
    @GetMapping("/getTransaksiRuangan")
    public TransaksiPeminjamanRuangan getTransaksiRuangan(@RequestParam(value = "idTransaksi") int idTransaksi) {
        TransaksiPeminjamanRuangan transaksiPeminjamanRuangan = ruanganService.getTransaksiById(idTransaksi);
        return transaksiPeminjamanRuangan;
    }
}
