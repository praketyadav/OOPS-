import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BMICalculatorGUI extends JFrame implements ActionListener {
    private JTextField weightField, heightField;
    private JButton calculateButton;
    private JLabel resultLabel;

    public BMICalculatorGUI() {
        setTitle("BMI Calculator");
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2, 10, 10));
        setLocationRelativeTo(null); // center on screen

        // Components
        JLabel weightLabel = new JLabel("Weight (kg):");
        weightField = new JTextField();

        JLabel heightLabel = new JLabel("Height (m):");
        heightField = new JTextField();

        calculateButton = new JButton("Calculate BMI");
        calculateButton.addActionListener(this);

        resultLabel = new JLabel("Enter your details above.");
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Adding components
        add(weightLabel);
        add(weightField);
        add(heightLabel);
        add(heightField);
        add(new JLabel()); // Empty cell
        add(calculateButton);
        add(new JLabel()); // Empty cell
        add(resultLabel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double weight = Double.parseDouble(weightField.getText());
            double height = Double.parseDouble(heightField.getText());

            if (weight <= 0 || height <= 0) {
                resultLabel.setText("❌ Enter positive numbers.");
                return;
            }

            double bmi = weight / (height * height);
            String category;

            if (bmi < 18.5) category = "Underweight";
            else if (bmi < 24.9) category = "Normal weight";
            else if (bmi < 29.9) category = "Overweight";
            else category = "Obese";

            resultLabel.setText(String.format("BMI: %.2f (%s)", bmi, category));

        } catch (NumberFormatException ex) {
            resultLabel.setText("❌ Invalid input.");
        }
    }

    public static void main(String[] args) {
        new BMICalculatorGUI();
    }
}
