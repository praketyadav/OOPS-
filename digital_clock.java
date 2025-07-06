import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DigitalClock extends JFrame {

    private JLabel timeLabel;
    private SimpleDateFormat timeFormat;

    public DigitalClock() {
        setTitle("🕒 Digital Clock");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);  // Center the window

        timeFormat = new SimpleDateFormat("HH:mm:ss");
        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Arial", Font.BOLD, 40));
        timeLabel.setHorizontalAlignment(SwingConstants.CENTER);

        add(timeLabel);

        // Timer to update every second (1000 ms)
        Timer timer = new Timer(1000, e -> updateTime());
        timer.start();

        updateTime(); // Initial call
        setVisible(true);
    }

    private void updateTime() {
        String time = timeFormat.format(new Date());
        timeLabel.setText(time);
    }

    public static void main(String[] args) {
        new DigitalClock();
    }
}
