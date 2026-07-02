package view;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class MainFrame extends JFrame {
    // Deklarasi Komponen UI (Public agar bisa diakses oleh Controller)
    public JTextField txtNim = new JTextField(20);
    public JTextField txtNama = new JTextField(20);
    public JTextField txtJurusan = new JTextField(20);
    public JButton btnSimpan = new JButton("Simpan Data");
    public JTable tableMahasiswa = new JTable(new DefaultTableModel(new Object[]{"NIM", "Nama", "Jurusan"}, 0));

    public MainFrame() {
        setTitle("Legacy CRUD Mahasiswa");
        setSize(900, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Judul Atas
        JLabel labelJudul = new JLabel("Legacy CRUD Mahasiswa (Clean Code Version)", SwingConstants.CENTER);
        labelJudul.setFont(new Font("Arial", Font.BOLD, 16));
        add(labelJudul, BorderLayout.NORTH);

        // Panel Form Input (Kiri)
        JPanel panelInput = new JPanel(new GridBagLayout());
        panelInput.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0; gbc.gridy = 0; panelInput.add(new JLabel("NIM:"), gbc);
        gbc.gridx = 1; panelInput.add(txtNim, gbc);

        gbc.gridx = 0; gbc.gridy = 1; panelInput.add(new JLabel("Nama:"), gbc);
        gbc.gridx = 1; panelInput.add(txtNama, gbc);

        gbc.gridx = 0; gbc.gridy = 2; panelInput.add(new JLabel("Jurusan:"), gbc);
        gbc.gridx = 1; panelInput.add(txtJurusan, gbc);

        gbc.gridx = 1; gbc.gridy = 3; 
        panelInput.add(btnSimpan, gbc);

        add(panelInput, BorderLayout.WEST);

        // Panel Tabel Data (Kanan)
        JScrollPane scrollPane = new JScrollPane(tableMahasiswa);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Data Mahasiswa"));
        add(scrollPane, BorderLayout.CENTER);
    }
}