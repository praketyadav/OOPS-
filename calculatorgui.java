import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleCalculator extends JFrame {

    private JTextField num1Field, num2Field, resultField;
    private JButton addButton;

    public SimpleCalculator() {
        setTitle("Simple Calculator");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window

        // Create components
        JLabel num1Label = new JLabel("Number 1:");
        JLabel num2Label = new JLabel("Number 2:");
        JLabel resultLabel = new JLabel("Result:");

        num1Field = new JTextField(10);
        num2Field = new JTextField(10);
        resultField = new JTextField(10);
        resultField.setEditable(false);

        addButton = new JButton("Add");

        // Add ActionListener
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int num1 = Integer.parseInt(num1Field.getText());
                    int num2 = Integer.parseInt(num2Field.getText());
                    int sum = num1 + num2;
                    resultField.setText(Integer.toString(sum));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter valid numbers.");
                }
            }
        });

        // Layout setup
        setLayout(new GridLayout(4, 2, 5, 5));
        add(num1Label);
        add(num1Field);
        add(num2Label);
        add(num2Field);
        add(resultLabel);
        add(resultField);
        add(new JLabel()); // empty label
        add(addButton);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new SimpleCalculator().setVisible(true);
        });
    }
}
