import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// === OOP: Main App Class ===
public class ProgressBarApp extends JFrame {

    private JProgressBar progressBar;
    private JButton startButton;

    public ProgressBarApp() {
        setTitle("Swing + Multithreading Demo");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // center the window
        initComponents();
    }

    // === OOP: Encapsulation of GUI Components ===
    private void initComponents() {
        progressBar = new JProgressBar(0, 100);
        progressBar.setStringPainted(true);
        startButton = new JButton("Start Task");

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startButton.setEnabled(false);
                new Thread(new TaskRunner()).start(); // Start background task
            }
        });

        setLayout(new BorderLayout());
        add(progressBar, BorderLayout.CENTER);
        add(startButton, BorderLayout.SOUTH);
    }

    // === OOP: Inner Class implementing Runnable for Multithreading ===
    private class TaskRunner implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i <= 100; i++) {
                try {
                    Thread.sleep(50); // simulate work
                    final int value = i;
                    SwingUtilities.invokeLater(() -> progressBar.setValue(value)); // update GUI safely
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
            SwingUtilities.invokeLater(() -> {
                JOptionPane.showMessageDialog(null, "Task Completed!");
                startButton.setEnabled(true);
            });
        }
    }

    // === Main Method to Run the Application ===
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ProgressBarApp().setVisible(true);
        });
    }
}
