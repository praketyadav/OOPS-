import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AWTLoginWithJDBC extends Frame implements ActionListener {

    Label lblUser, lblPass;
    TextField txtUser, txtPass;
    Button btnLogin;
    Connection conn;

    AWTLoginWithJDBC() {
        setTitle("AWT Login Form");
        setSize(300, 200);
        setLayout(new GridLayout(3, 2));
        setLocationRelativeTo(null);

        lblUser = new Label("Username:");
        lblPass = new Label("Password:");

        txtUser = new TextField();
        txtPass = new TextField();
        txtPass.setEchoChar('*');

        btnLogin = new Button("Login");

        add(lblUser);
        add(txtUser);
        add(lblPass);
        add(txtPass);
        add(new Label()); // Empty cell
        add(btnLogin);

        btnLogin.addActionListener(this);

        // Window closing
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
            }
        });

        setVisible(true);

        // Initialize database connection
        connectToDatabase();
    }

    void connectToDatabase() {
        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Replace with your DB credentials
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "yourpassword");

            System.out.println("Database connected!");
        } catch (Exception e) {
            System.out.println("Database connection error: " + e);
        }
    }

    public void actionPerformed(ActionEvent ae) {
        String username = txtUser.getText();
        String password = txtPass.getText();

        try {
            String query = "SELECT * FROM users WHERE username=? AND password=?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, username);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                showMessageDialog("Login Successful!");
            } else {
                showMessageDialog("Invalid credentials.");
            }

            rs.close();
            pst.close();
        } catch (Exception e) {
            System.out.println("Login error: " + e);
        }
    }

    void showMessageDialog(String message) {
        Dialog d = new Dialog(this, "Message", true);
        d.setLayout(new FlowLayout());
        d.add(new Label(message));
        Button ok = new Button("OK");
        ok.addActionListener(e -> d.setVisible(false));
        d.add(ok);
        d.setSize(200, 100);
        d.setLocationRelativeTo(this);
        d.setVisible(true);
    }

    public static void main(String[] args) {
        new AWTLoginWithJDBC();
    }
}
