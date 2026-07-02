package controller;

import entity.Mahasiswa;
import service.MahasiswaService;
import view.MainFrame;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.util.List;

public class MahasiswaController {
    private final MainFrame view;
    private final MahasiswaService service;

    public MahasiswaController(MainFrame view, MahasiswaService service) {
        this.view = view;
        this.service = service;
        
        // Menghubungkan event klik tombol simpan di MainFrame ke method aksiSimpan
        this.view.btnSimpan.addActionListener(e -> aksiSimpan());
        
        // Tampilkan data ke tabel saat aplikasi pertama kali dibuka
        loadDataTabel();
    }

    private void loadDataTabel() {
        DefaultTableModel model = (DefaultTableModel) view.tableMahasiswa.getModel();
        model.setRowCount(0);
        try {
            List<Mahasiswa> list = service.getAllMahasiswa();
            for (Mahasiswa m : list) {
                model.addRow(new Object[]{m.getNim(), m.getNama(), m.getJurusan()});
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, "Gagal memuat data dari database: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void aksiSimpan() {
        try {
            String nim = view.txtNim.getText();
            String nama = view.txtNama.getText();
            String jurusan = view.txtJurusan.getText();

            // Membungkus data ke dalam objek Entity
            Mahasiswa m = new Mahasiswa(nim, nama, jurusan);
            
            // Eksekusi via Service
            service.addMahasiswa(m); 
            
            JOptionPane.showMessageDialog(view, "Data Mahasiswa Berhasil Disimpan!");
            loadDataTabel(); // Refresh tampilan tabel
            
            // Reset form input
            view.txtNim.setText("");
            view.txtNama.setText("");
            view.txtJurusan.setText("");
            
        } catch (IllegalArgumentException ex) {
            // Menangkap error validasi dari layer service
            JOptionPane.showMessageDialog(view, ex.getMessage(), "Validasi Gagal", JOptionPane.WARNING_MESSAGE);
        } catch (SQLException ex) {
            // Menangkap error database agar aplikasi tidak crash mendadak
            JOptionPane.showMessageDialog(view, "Error Database: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}