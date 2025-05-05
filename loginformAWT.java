import java.awt.*;
import java.awt.event.*;

public class LoginFormAWT {
    public static void main(String[] args) {
        Frame frame = new Frame("Login Form");

        Label userLabel = new Label("Username:");
        userLabel.setBounds(50, 70, 80, 30);
        TextField userField = new TextField();
        userField.setBounds(150, 70, 150, 30);

        Label passLabel = new Label("Password:");
        passLabel.setBounds(50, 110, 80, 30);
        TextField passField = new TextField();
        passField.setEchoChar('*');
        passField.setBounds(150, 110, 150, 30);

        Button loginButton = new Button("Login");
        loginButton.setBounds(150, 160, 80, 30);

        Label message = new Label();
        message.setBounds(50, 210, 250, 30);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String user = userField.getText();
                String pass = passField.getText();
                if (user.equals("admin") && pass.equals("1234")) {
                    message.setText("Login successful!");
                } else {
                    message.setText("Invalid credentials.");
                }
            }
        });

        frame.add(userLabel);
        frame.add(userField);
        frame.add(passLabel);
        frame.add(passField);
        frame.add(loginButton);
        frame.add(message);

        frame.setSize(400, 300);
        frame.setLayout(null);
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                frame.dispose();
            }
        });
    }
}
