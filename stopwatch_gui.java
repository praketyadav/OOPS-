import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StopwatchApp extends JFrame implements ActionListener {
    private JLabel timeLabel;
    private JButton startButton, stopButton, resetButton;
    private Timer timer;
    private int elapsedSeconds = 0;

    public StopwatchApp() {
        setTitle("⏱️ Stopwatch");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        setLocationRelativeTo(null);

        // Display label
        timeLabel = new JLabel("00:00", SwingConstants.CENTER);
        timeLabel.setFont(new Font("Verdana", Font.BOLD, 40));
        add(timeLabel, BorderLayout.CENTER);

        // Buttons
        JPanel buttonPanel = new JPanel(new FlowLayout());
        startButton = new JButton("Start");
        stopButton = new JButton("Stop");
        resetButton = new JButton("Reset");

        startButton.addActionListener(this);
        stopButton.addActionListener(this);
        resetButton.addActionListener(this);

        buttonPanel.add(startButton);
        buttonPanel.add(stopButton);
        buttonPanel.add(resetButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // Timer to count every second
        timer = new Timer(1000, e -> {
            elapsedSeconds++;
            updateTimeLabel();
        });

        setVisible(true);
    }

    private void updateTimeLabel() {
        int minutes = elapsedSeconds / 60;
        int seconds = elapsedSeconds % 60;
        timeLabel.setText(String.format("%02d:%02d", minutes, seconds));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        if (src == startButton) {
            timer.start();
        } else if (src == stopButton) {
            timer.stop();
        } else if (src == resetButton) {
            timer.stop();
            elapsedSeconds = 0;
            updateTimeLabel();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(StopwatchApp::new);
    }
}
