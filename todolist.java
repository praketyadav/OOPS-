import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

// Class to manage the Task List logic (Encapsulation)
class TaskManager {
    private ArrayList<String> tasks = new ArrayList<>();

    public void addTask(String task) {
        if (!task.isEmpty()) tasks.add(task);
    }

    public void removeTask(String task) {
        tasks.remove(task);
    }

    public String[] getAllTasks() {
        return tasks.toArray(new String[0]);
    }
}

// GUI class using AWT (Inheritance + Event Handling)
class ToDoApp extends Frame implements ActionListener {
    private TextField taskInput;
    private Button addButton, removeButton;
    private List taskListUI;
    private TaskManager taskManager;

    public ToDoApp() {
        super("AWT To-Do List");
        taskManager = new TaskManager();

        setLayout(null);
        setSize(400, 400);
        setVisible(true);
        setLocation(500, 200);
        setResizable(false);

        Label label = new Label("Enter Task:");
        label.setBounds(30, 50, 100, 20);
        add(label);

        taskInput = new TextField();
        taskInput.setBounds(120, 50, 200, 20);
        add(taskInput);

        addButton = new Button("Add");
        addButton.setBounds(330, 50, 50, 20);
        add(addButton);

        taskListUI = new List();
        taskListUI.setBounds(30, 90, 350, 200);
        add(taskListUI);

        removeButton = new Button("Remove Selected");
        removeButton.setBounds(120, 310, 150, 30);
        add(removeButton);

        addButton.addActionListener(this);
        removeButton.addActionListener(this);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            String task = taskInput.getText().trim();
            if (!task.isEmpty()) {
                taskManager.addTask(task);
                refreshTaskList();
                taskInput.setText("");
            }
        } else if (e.getSource() == removeButton) {
            String selected = taskListUI.getSelectedItem();
            if (selected != null) {
                taskManager.removeTask(selected);
                refreshTaskList();
            }
        }
    }

    private void refreshTaskList() {
        taskListUI.removeAll();
        for (String task : taskManager.getAllTasks()) {
            taskListUI.add(task);
        }
    }

    public static void main(String[] args) {
        new ToDoApp();
    }
}
