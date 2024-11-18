package Login;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;

public class LoginView extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    private JLabel titleLabel;
    private JLabel userNameLabel;
    private JLabel passwordLabel;
    private JPasswordField passwordField;
    private JTextField userNameField;
    private JButton loginBtn;

    public LoginView() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Tạo panel chính có nền từ URL
        BackgroundPanel panel = new BackgroundPanel("https://phenikaa-uni.edu.vn:3600/md/vi/posts/phenika_20220311094233.png");
        panel.setLayout(new GridBagLayout()); // Sử dụng GridBagLayout để căn giữa

        // Tạo các thành phần giao diện
        titleLabel = new JLabel("Login System", SwingConstants.CENTER);
        titleLabel.setFont(titleLabel.getFont().deriveFont(20.0f));
        titleLabel.setForeground(Color.WHITE); // Đổi màu chữ để nổi bật trên nền

        userNameLabel = new JLabel("Username:");
        userNameLabel.setForeground(Color.RED);
        passwordLabel = new JLabel("Password:");
        passwordLabel.setForeground(Color.RED);

        userNameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        loginBtn = new JButton("Login");
        loginBtn.addActionListener(this);

        // Sử dụng GridBagConstraints để căn chỉnh thành phần
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(titleLabel, gbc);

        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(userNameLabel, gbc);

        gbc.gridx = 1;
        panel.add(userNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(passwordLabel, gbc);

        gbc.gridx = 1;
        panel.add(passwordField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        panel.add(loginBtn, gbc);

        // Thêm panel vào JFrame
        this.add(panel);
        this.setTitle("Login");
        this.setSize(500, 350);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public User getUser() {
        return new User(userNameField.getText(), 
                String.copyValueOf(passwordField.getPassword()));
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginBtn) {
            showMessage("Login button clicked!");
        }
    }

    public void addLoginListener(ActionListener listener) {
        loginBtn.addActionListener(listener);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new LoginView().setVisible(true);
        });
    }

    // Lớp tạo nền với hình ảnh từ URL
    class BackgroundPanel extends JPanel {
        private Image backgroundImage;

        public BackgroundPanel(String imageUrl) {
            try {
                URL url = new URL(imageUrl);
                backgroundImage = ImageIO.read(url);
            } catch (Exception e) {
                System.out.println("Error loading background image: " + e.getMessage());
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (backgroundImage != null) {
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        }
    }
}
