import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ExpenseTracker extends JFrame implements ActionListener {
    private JTextField amountField, categoryField;
    private JButton addButton;
    private JTextArea expenseListArea;
    private JLabel totalLabel;

    private double total = 0;
    private final ArrayList<String> expenses = new ArrayList<>();

    public ExpenseTracker() {
        setTitle("💸 Expense Tracker");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        setLocationRelativeTo(null); // Center window

        // Top panel for inputs
        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Add Expense"));

        inputPanel.add(new JLabel("Amount (₹):"));
        amountField = new JTextField();
        inputPanel.add(amountField);

        inputPanel.add(new JLabel("Category:"));
        categoryField = new JTextField();
        inputPanel.add(categoryField);

        addButton = new JButton("Add Expense");
        addButton.addActionListener(this);
        inputPanel.add(addButton);

        totalLabel = new JLabel("Total: ₹0.00");
        inputPanel.add(totalLabel);

        // Text area for showing expenses
        expenseListArea = new JTextArea();
        expenseListArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(expenseListArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Expense History"));

        // Add components to frame
        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double amount = Double.parseDouble(amountField.getText());
            String category = categoryField.getText().trim();

            if (amount <= 0 || category.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter a valid amount and category.");
                return;
            }

            total += amount;
            String entry = String.format("₹%.2f - %s", amount, category);
            expenses.add(entry);
            updateDisplay();

            // Clear fields
            amountField.setText("");
            categoryField.setText("");

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a numeric amount.");
        }
    }

    private void updateDisplay() {
        StringBuilder sb = new StringBuilder();
        for (String expense : expenses) {
            sb.append(expense).append("\n");
        }
        expenseListArea.setText(sb.toString());
        totalLabel.setText(String.format("Total: ₹%.2f", total));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ExpenseTracker::new);
    }
}
