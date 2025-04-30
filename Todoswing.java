import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ToDoList extends JFrame {
    private JTextField taskInput;
    private JButton addButton, removeButton;
    private JList<String> taskList;
    private DefaultListModel<String> listModel;

    public ToDoList() {
        setTitle("To-Do List");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window on the screen

        // Set up the layout
        setLayout(new BorderLayout());

        // Task input field
        taskInput = new JTextField();
        taskInput.setFont(new Font("Arial", Font.PLAIN, 16));
        add(taskInput, BorderLayout.NORTH);

        // List model and JList
        listModel = new DefaultListModel<>();
        taskList = new JList<>(listModel);
        taskList.setFont(new Font("Arial", Font.PLAIN, 16));
        taskList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane listScrollPane = new JScrollPane(taskList);
        add(listScrollPane, BorderLayout.CENTER);

        // Panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        // Add Button
        addButton = new JButton("Add");
        addButton.setFont(new Font("Arial", Font.PLAIN, 16));
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String task = taskInput.getText();
                if (!task.trim().isEmpty()) {
                    listModel.addElement(task);
                    taskInput.setText("");
                }
            }
        });
        buttonPanel.add(addButton);

        // Remove Button
        removeButton = new JButton("Remove");
        removeButton.setFont(new Font("Arial", Font.PLAIN, 16));
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = taskList.getSelectedIndex();
                if (selectedIndex != -1) {
                    listModel.remove(selectedIndex);
                }
            }
        });
        buttonPanel.add(removeButton);

        // Add the button panel to the south
        add(buttonPanel, BorderLayout.SOUTH);

        // Make the window visible
        setVisible(true);
    }

    public static void main(String[] args) {
        new ToDoList();
    }
}
