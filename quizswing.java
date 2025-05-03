import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class QuizApp extends JFrame implements ActionListener {
    String[] questions = {
        "What is the capital of France?",
        "Which language runs in a web browser?",
        "What is 5 + 7?",
        "Which planet is known as the Red Planet?"
    };

    String[][] options = {
        {"Paris", "London", "Rome", "Berlin"},
        {"Java", "C", "Python", "JavaScript"},
        {"10", "12", "11", "13"},
        {"Earth", "Mars", "Jupiter", "Saturn"}
    };

    int[] answers = {0, 3, 1, 1}; // correct options

    int currentQuestion = 0;
    int score = 0;

    JLabel questionLabel;
    JRadioButton[] optionButtons;
    ButtonGroup group;
    JButton nextButton;

    public QuizApp() {
        setTitle("Simple Quiz App");
        setSize(500, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        questionLabel = new JLabel();
        questionLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(questionLabel, BorderLayout.NORTH);

        JPanel optionsPanel = new JPanel();
        optionsPanel.setLayout(new GridLayout(4, 1));

        optionButtons = new JRadioButton[4];
        group = new ButtonGroup();

        for (int i = 0; i < 4; i++) {
            optionButtons[i] = new JRadioButton();
            group.add(optionButtons[i]);
            optionsPanel.add(optionButtons[i]);
        }

        add(optionsPanel, BorderLayout.CENTER);

        nextButton = new JButton("Next");
        nextButton.addActionListener(this);
        add(nextButton, BorderLayout.SOUTH);

        loadQuestion();
        setVisible(true);
    }

    public void loadQuestion() {
        if (currentQuestion < questions.length) {
            questionLabel.setText("Q" + (currentQuestion + 1) + ": " + questions[currentQuestion]);

            for (int i = 0; i < 4; i++) {
                optionButtons[i].setText(options[currentQuestion][i]);
                optionButtons[i].setSelected(false);
            }
        } else {
            showScore();
        }
    }

    public void showScore() {
        JOptionPane.showMessageDialog(this, "Quiz Over! Your score is: " + score + "/" + questions.length);
        System.exit(0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int selected = -1;
        for (int i = 0; i < 4; i++) {
            if (optionButtons[i].isSelected()) {
                selected = i;
                break;
            }
        }

        if (selected == -1) {
            JOptionPane.showMessageDialog(this, "Please select an option.");
            return;
        }

        if (selected == answers[currentQuestion]) {
            score++;
        }

        currentQuestion++;
        loadQuestion();
    }

    public static void main(String[] args) {
        new QuizApp();
    }
}
