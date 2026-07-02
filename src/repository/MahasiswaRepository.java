import java.sql.Connection;
import java.sql.PreparedStatement;

public class MahasiswaRepository {
    public void save(Mahasiswa mhs) throws Exception {
        String sql = "INSERT INTO mahasiswa (nim, nama) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, mhs.getNim());
            ps.setString(2, mhs.getNama());
            ps.executeUpdate();
        }
    }
}