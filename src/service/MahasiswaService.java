package service;

import entity.Mahasiswa;
import repository.MahasiswaRepository;
import java.sql.SQLException;
import java.util.List;

public class MahasiswaService {
    private final MahasiswaRepository repository;

    public MahasiswaService() {
        this.repository = new MahasiswaRepository();
    }

    public List<Mahasiswa> getAllMahasiswa() throws SQLException {
        return repository.findAll();
    }

    public void addMahasiswa(Mahasiswa m) throws SQLException, IllegalArgumentException {
        // Validasi Aturan Praktikum: Input wajib divalidasi
        if (m.getNim().trim().isEmpty() || m.getNama().trim().isEmpty()) {
            throw new IllegalArgumentException("NIM dan Nama tidak boleh kosong!");
        }
        repository.save(m);
    }
}