import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class MainFrame extends JFrame {

    public MainFrame() {
        setTitle("Legacy CRUD Mahasiswa");
        setSize(900, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("Legacy CRUD Mahasiswa", SwingConstants.CENTER);
        add(label);
    }
}