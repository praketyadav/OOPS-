import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleCalculator extends JFrame implements ActionListener {
    private JTextField display;
    private StringBuilder input;
    private double firstNumber;
    private String operator;

    public SimpleCalculator() {
        setTitle("Simple Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center on screen

        input = new StringBuilder();

        // Display field
        display = new JTextField();
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.PLAIN, 24));
        add(display, BorderLayout.NORTH);

        // Panel for buttons
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 5, 5));

        // Buttons
        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "C", "0", "=", "+"
        };

        for (String text : buttons) {
            JButton btn = new JButton(text);
            btn.setFont(new Font("Arial", Font.BOLD, 20));
            btn.addActionListener(this);
            panel.add(btn);
        }

        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    // Event handling
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command) {
            case "=":
                try {
                    double secondNumber = Double.parseDouble(input.toString());
                    double result = performOperation(firstNumber, secondNumber, operator);
                    display.setText(String.valueOf(result));
                    input.setLength(0);
                    operator = null;
                } catch (Exception ex) {
                    display.setText("Error");
                    input.setLength(0);
                }
                break;

            case "C":
                input.setLength(0);
                display.setText("");
                firstNumber = 0;
                operator = null;
                break;

            case "+":
            case "-":
            case "*":
            case "/":
                try {
                    firstNumber = Double.parseDouble(input.toString());
                    operator = command;
                    input.setLength(0);
                } catch (NumberFormatException ex) {
                    display.setText("Error");
                    input.setLength(0);
                }
                break;

            default:
                input.append(command);
                display.setText(input.toString());
        }
    }

    // Perform the calculation
    private double performOperation(double firstNumber, double secondNumber, String operator) {
        switch (operator) {
            case "+":
                return firstNumber + secondNumber;
            case "-":
                return firstNumber - secondNumber;
            case "*":
                return firstNumber * secondNumber;
            case "/":
                if (secondNumber != 0) {
                    return firstNumber / secondNumber;
                } else {
                    display.setText("Error");
                    return 0;
                }
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        new SimpleCalculator();
    }
}
