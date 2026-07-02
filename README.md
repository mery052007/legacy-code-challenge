# Laporan Praktikum: Legacy Code Challenge (Refactoring & Architecture)

Repositori ini dibuat untuk memenuhi tugas praktikum pemrograman mengenai *Refactoring* dan penerapan Arsitektur Perangkat Lunak berbasis *Clean Code* pada aplikasi Java Swing.

## 📌 Informasi Proyek
* **Versi Legacy (Awal):** `v1.0-legacy` (Kode asli dari dosen)
* **Versi Clean (Akhir):** `v2.0-clean` (Kode setelah di-refactor)
* **Metode Penggabungan:** Melalui Pull Request dari branch `feature/refactor-architecture` ke branch `main`.

---

## 📑 Analisis & Laporan Refactoring

### 1. Apa yang Diperbaiki?
Perbaikan berfokus pada transformasi total dari kode prosedural (*spaghetti code*) menjadi kode yang terstruktur dengan arsitektur berlapis (*layered architecture*):
* **Pemisahan Tanggung Jawab (Separation of Concerns):** Memisahkan seluruh logika database (SQL) dan pengolahan data keluar dari kelas GUI (`MainFrame.java`).
* **Restrukturisasi Package:** Membagi proyek menjadi komponen-komponen terisolasi minimal:
  * `entity`: Representasi objek data (`Mahasiswa.java`).
  * `database`: Manajemen koneksi terpusat menggunakan koneksi database tunggal (`DatabaseConnection.java`).
  * `repository`: Layer khusus untuk eksekusi query SQL (Akses data).
  * `service`: Layer untuk logika bisnis dan aturan validasi aplikasi.
  * `controller`: Menjembatani *event* dari View ke Service (`MahasiswaController.java`).
  * `view`: Hanya berfokus pada layouting dan komponen visual UI (`MainFrame.java`).
  * `utils`: Menyediakan fungsi bantuan umum seperti `InputHelper.java`.
* **Implementasi Validasi & Exception Handling:** Menambahkan penanganan eror menggunakan blok `try-catch` di layer *Service* dan *Controller* agar aplikasi tidak berhenti paksa saat terjadi kesalahan input atau kegagalan koneksi database.
* **Standarisasi Penamaan:** Mengubah variabel-variabel ambigu bawaan komponen GUI menjadi nama yang deskriptif dan bermakna (*meaningful names*).

### 2. Mengapa Diperbaiki?
* **Pencegahan Kerapuhan Kode (Code Fragility):** Pada kode *legacy*, perubahan kecil pada struktur database (misalnya perubahan nama kolom) akan memaksa developer membongkar file UI `JFrame`. Hal ini sangat tidak efisien dan rentan memicu bug baru.
* **Kepatuhan Terhadap Paradigma OOP:** Java adalah bahasa pemrograman berbasis objek. Menumpuk seluruh kode di dalam satu file `JFrame` melanggar prinsip dasar OOP, khususnya *Single Responsibility Principle* (SRP).
* **Faktor Keamanan dan Stabilitas:** Menyatukan logika bisnis tanpa *Exception Handling* yang kuat membuat aplikasi sangat tidak stabil dan mudah *crash* ketika menerima input yang tidak sesuai standar.

### 3. Dampak Perubahan
* **Kemudahan Pemeliharaan (Maintainability):** Kode menjadi jauh lebih mudah dirawat karena tiap fungsi diletakkan di tempat yang semestinya. Jika ada kendala query SQL, perbaikan cukup dilakukan pada package `repository`.
* **Keterbacaan Kode (Readability):** Struktur proyek menjadi bersih, rapi, dan modular sehingga memudahkan kolaborasi antar-developer dalam tim.
* **Skalabilitas (Scalability):** Aplikasi siap dikembangkan lebih lanjut. Jika di kemudian hari tampilan ingin diubah dari Java Swing menjadi aplikasi berbasis Web, logika bisnis di layer `service` dan `repository` dapat langsung digunakan kembali tanpa perlu ditulis ulang dari nol.

---

## 🛠️ Cara Menjalankan Aplikasi

1. Eksekusi skrip `database.sql` pada server MySQL Anda (misal: menggunakan XAMPP/phpMyAdmin).
2. Pastikan konfigurasi *username* dan *password* database pada `src/database/DatabaseConnection.java` sudah sesuai.
3. Jalankan *Main Entry Point* proyek melalui file `src/Main.java`.