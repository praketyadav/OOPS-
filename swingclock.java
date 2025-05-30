import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

// === OOP: Clock Window ===
public class ClockApp extends JFrame {

    private JLabel timeLabel;

    public ClockApp() {
        setTitle("Live Clock - Swing + Threading");
        setSize(300, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initUI();
        startClock();
    }

    // === Encapsulation of UI Components ===
    private void initUI() {
        timeLabel = new JLabel("", SwingConstants.CENTER);
        timeLabel.setFont(new Font("Courier", Font.BOLD, 32));
        add(timeLabel);
    }

    // === Multithreading: Clock runs in background thread ===
    private void startClock() {
        Thread clockThread = new Thread(new ClockUpdater());
        clockThread.start();
    }

    // === Inner class for the clock thread ===
    private class ClockUpdater implements Runnable {
        private final SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");

        @Override
        public void run() {
            while (true) {
                String currentTime = formatter.format(new Date());
                SwingUtilities.invokeLater(() -> timeLabel.setText(currentTime));
                try {
                    Thread.sleep(1000); // update every second
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // === Main method ===
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ClockApp().setVisible(true);
        });
    }
}
