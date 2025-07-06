import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class NotepadClone extends JFrame implements ActionListener {

    private JTextArea textArea;
    private JFileChooser fileChooser;
    private File currentFile = null;

    public NotepadClone() {
        setTitle("📝 Notepad Clone");
        setSize(600, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Text Area
        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane);

        // Menu Bar
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");

        JMenuItem newItem = new JMenuItem("New");
        JMenuItem openItem = new JMenuItem("Open...");
        JMenuItem saveItem = new JMenuItem("Save");
        JMenuItem saveAsItem = new JMenuItem("Save As...");
        JMenuItem exitItem = new JMenuItem("Exit");

        newItem.addActionListener(this);
        openItem.addActionListener(this);
        saveItem.addActionListener(this);
        saveAsItem.addActionListener(this);
        exitItem.addActionListener(this);

        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(saveAsItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);

        fileChooser = new JFileChooser();
        setVisible(true);
    }

    // Handle Menu Actions
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command) {
            case "New":
                textArea.setText("");
                currentFile = null;
                setTitle("📝 Notepad Clone - New File");
                break;

            case "Open...":
                int openOption = fileChooser.showOpenDialog(this);
                if (openOption == JFileChooser.APPROVE_OPTION) {
                    currentFile = fileChooser.getSelectedFile();
                    try (BufferedReader reader = new BufferedReader(new FileReader(currentFile))) {
                        textArea.read(reader, null);
                        setTitle("📝 Notepad Clone - " + currentFile.getName());
                    } catch (IOException ex) {
                        showError("Could not open file.");
                    }
                }
                break;

            case "Save":
                if (currentFile != null) {
                    saveToFile(currentFile);
                } else {
                    saveAs();
                }
                break;

            case "Save As...":
                saveAs();
                break;

            case "Exit":
                System.exit(0);
                break;
        }
    }

    private void saveAs() {
        int saveOption = fileChooser.showSaveDialog(this);
        if (saveOption == JFileChooser.APPROVE_OPTION) {
            currentFile = fileChooser.getSelectedFile();
            saveToFile(currentFile);
        }
    }

    private void saveToFile(File file) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            textArea.write(writer);
            setTitle("📝 Notepad Clone - " + file.getName());
        } catch (IOException ex) {
            showError("Could not save file.");
        }
    }

    private void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(NotepadClone::new);
    }
}
