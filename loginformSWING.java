import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginForm extends JFrame implements ActionListener {
    private Container container;
    private JLabel userLabel, passLabel;
    private JTextField userText;
    private JPasswordField passText;
    private JButton loginButton, resetButton;

    // Hardcoded credentials
    private final String USERNAME = "admin";
    private final String PASSWORD = "1234";

    public LoginForm() {
        setTitle("Login Form");
        setBounds(500, 200, 350, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        container = getContentPane();
        container.setLayout(null);

        userLabel = new JLabel("Username:");
        userLabel.setBounds(20, 30, 80, 25);
        container.add(userLabel);

        userText = new JTextField();
        userText.setBounds(120, 30, 160, 25);
        container.add(userText);

        passLabel = new JLabel("Password:");
        passLabel.setBounds(20, 70, 80, 25);
        container.add(passLabel);

        passText = new JPasswordField();
        passText.setBounds(120, 70, 160, 25);
        container.add(passText);

        loginButton = new JButton("Login");
        loginButton.setBounds(50, 110, 100, 25);
        loginButton.addActionListener(this);
        container.add(loginButton);

        resetButton = new JButton("Reset");
        resetButton.setBounds(170, 110, 100, 25);
        resetButton.addActionListener(this);
        container.add(resetButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String user = userText.getText();
            String pass = new String(passText.getPassword());

            if (user.equals(USERNAME) && pass.equals(PASSWORD)) {
                JOptionPane.showMessageDialog(this, "Login successful!");
            } else {
                JOptionPane.showMessageDialog(this, "Invalid credentials!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == resetButton) {
            userText.setText("");
            passText.setText("");
        }
    }

    public static void main(String[] args) {
        LoginForm frame = new LoginForm();
        frame.setVisible(true);
    }
}
