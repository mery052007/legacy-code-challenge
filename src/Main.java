import controller.MahasiswaController;
import javax.swing.SwingUtilities;
import service.MahasiswaService;
import view.MainFrame;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // 1. Membuat objek tampilan (View)
            MainFrame view = new MainFrame();
            
            // 2. Membuat objek logika bisnis (Service)
            MahasiswaService service = new MahasiswaService();
            
            // 3. Menghubungkan View dan Service melalui Controller
            new MahasiswaController(view, service);
            
            // 4. Menampilkan aplikasi ke layar
            view.setVisible(true);
        });
    }
}