package astratech.latihanspring010.controller;

import astratech.latihanspring010.model.Mahasiswa;
import astratech.latihanspring010.service.MahasiswaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class MahasiswaController {
    @Autowired
    MahasiswaService mahasiswaService;

    // Mendapatkan daftar semua mahasiswa
    @GetMapping("/getMahasiswas")
    public List<Mahasiswa> getMahasiswas() {
        List<Mahasiswa> mahasiswas = mahasiswaService.getMahasiswas();
        return mahasiswas;
    }

    // Menambahkan mahasiswa baru
    @PostMapping("/addMahasiswa")
    public ModelAndView addMahasiswa(@RequestParam(value = "nimMahasiswa") String nim,
                                     @RequestParam(value = "namaMahasiswa") String nama,
                                     @RequestParam(value = "tanggalLahir") String tgll,
                                     @RequestParam(value = "jenisKelamin") int jk,
                                     @RequestParam(value = "status") int status) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        Date tgl = sdf.parse(tgll);
        Mahasiswa mahasiswa = mahasiswaService.addMahasiswa(nim, nama, tgl, jk, status);

        ModelAndView mav = new ModelAndView("redirect:/mahasiswa/index.html"); // Mengarahkan ke halaman /mahasiswa/index.html
        return mav;
    }

    // Mendapatkan detail mahasiswa berdasarkan NIM
    @GetMapping("/getMahasiswa")
    public Mahasiswa getMahasiswa(@RequestParam(value = "nimMahasiswa") String nim) {
        Mahasiswa mahasiswa = mahasiswaService.getMahasiswaByNim(nim);
        return mahasiswa;
    }

    // Mengupdate data mahasiswa berdasarkan NIM
    @PostMapping("/updateMahasiswa")
    public ModelAndView updateMahasiswa(@RequestParam(value = "nimMahasiswa") String nim,
                                     @RequestParam(value = "namaMahasiswa") String nama,
                                     @RequestParam(value = "tanggalLahir") String tgll,
                                     @RequestParam(value = "jenisKelamin") int jk,
                                     @RequestParam(value = "status") int status,
                                     @RequestParam(value = "_method") String method) throws ParseException {

        if ("PUT".equalsIgnoreCase(method)) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
            Date tgl = sdf.parse(tgll);
            Mahasiswa mahasiswa = mahasiswaService.updateMahasiswaByNim(nim, nama, tgl, jk, status);
        }

        ModelAndView mav = new ModelAndView("redirect:/mahasiswa/index.html"); // Mengarahkan ke halaman /mahasiswa/index.html
        return mav;
    }

    // Menghapus data mahasiswa berdasarkan NIM
    @DeleteMapping("/deleteMahasiswa")
    public String deleteMahasiswa(@RequestParam(value = "nimMahasiswa") String nim) {
        mahasiswaService.deleteMahasiswaByNim(nim);
        return "Mahasiswa dengan NIM " + nim + " telah dihapus.";
    }
}
