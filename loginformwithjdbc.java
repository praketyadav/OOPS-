import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ModernLoginForm extends JFrame implements ActionListener {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton, clearButton;
    private JCheckBox showPassword;
    private JLabel messageLabel;

    private int attempts = 0;
    private final int maxAttempts = 3;

    // Database credentials
    private final String DB_URL = "jdbc:mysql://localhost:3306/login_app";
    private final String DB_USER = "root";
    private final String DB_PASS = "your_password_here"; // replace with your MySQL password

    public ModernLoginForm() {
        setTitle("Login");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Panel and Layout
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Title
        JLabel titleLabel = new JLabel("User Login", SwingConstants.CENTER);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
        titleLabel.setForeground(Color.BLUE);
        gbc.gridwidth = 2;
        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(titleLabel, gbc);

        // Username
        gbc.gridwidth = 1;
        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(new JLabel("Username:"), gbc);

        usernameField = new JTextField();
        gbc.gridx = 1;
        panel.add(usernameField, gbc);

        // Password
        gbc.gridx = 0; gbc.gridy = 2;
        panel.add(new JLabel("Password:"), gbc);

        passwordField = new JPasswordField();
        gbc.gridx = 1;
        panel.add(passwordField, gbc);

        // Show password
        showPassword = new JCheckBox("Show Password");
        showPassword.setBackground(Color.WHITE);
        showPassword.addActionListener(e -> {
            passwordField.setEchoChar(showPassword.isSelected() ? (char) 0 : '•');
        });
        gbc.gridx = 1; gbc.gridy = 3;
        panel.add(showPassword, gbc);

        // Buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        loginButton = new JButton("Login");
        loginButton.addActionListener(this);
        clearButton = new JButton("Clear");
        clearButton.addActionListener(e -> {
            usernameField.setText("");
            passwordField.setText("");
        });
        buttonPanel.add(loginButton);
        buttonPanel.add(clearButton);
        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2;
        panel.add(buttonPanel, gbc);

        // Message
        messageLabel = new JLabel("", SwingConstants.CENTER);
        messageLabel.setForeground(Color.RED);
        gbc.gridy = 5;
        panel.add(messageLabel, gbc);

        add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String user = usernameField.getText();
        String pass = new String(passwordField.getPassword());

        if (authenticate(user, pass)) {
            messageLabel.setForeground(new Color(0, 128, 0));
            messageLabel.setText("Login successful!");
            JOptionPane.showMessageDialog(this, "Welcome, " + user + "!");
            // Proceed to next screen or app section
        } else {
            attempts++;
            messageLabel.setForeground(Color.RED);
            if (attempts >= maxAttempts) {
                messageLabel.setText("Too many attempts. Locked!");
                loginButton.setEnabled(false);
            } else {
                messageLabel.setText("Invalid credentials. Attempts left: " + (maxAttempts - attempts));
            }
        }
    }

    private boolean authenticate(String username, String password) {
        try (Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
             PreparedStatement ps = con.prepareStatement("SELECT * FROM users WHERE username=? AND password=?")) {

            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            return rs.next();

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage());
            return false;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            } catch (Exception ignored) {}
            new ModernLoginForm().setVisible(true);
        });
    }
}
