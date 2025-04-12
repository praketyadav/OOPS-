import java.io.*;
import java.util.*;

class Student {
    private String name;
    private int rollNo;
    private double grade;

    public Student(String name, int rollNo, double grade) {
        this.name = name;
        this.rollNo = rollNo;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getRollNo() {
        return rollNo;
    }

    public double getGrade() {
        return grade;
    }

    public String toString() {
        return "Name: " + name + ", Roll No: " + rollNo + ", Grade: " + grade;
    }
}

public class StudentManagement {
    private static final String FILE_NAME = "students.txt";
    private static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        loadFromFile();

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search by Roll Number");
            System.out.println("4. Save to File");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> addStudent(scanner);
                case 2 -> viewAllStudents();
                case 3 -> searchStudent(scanner);
                case 4 -> saveToFile();
                case 5 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 5);
    }

    private static void addStudent(Scanner scanner) {
        System.out.print("Enter name: ");
        scanner.nextLine();  // clear buffer
        String name = scanner.nextLine();
        System.out.print("Enter roll number: ");
        int rollNo = scanner.nextInt();
        System.out.print("Enter grade: ");
        double grade = scanner.nextDouble();

        Student s = new Student(name, rollNo, grade);
        students.add(s);
        System.out.println("Student added!");
    }

    private static void viewAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No student records found.");
        } else {
            for (Student s : students) {
                System.out.println(s);
            }
        }
    }

    private static void searchStudent(Scanner scanner) {
        System.out.print("Enter roll number to search: ");
        int roll = scanner.nextInt();
        boolean found = false;

        for (Student s : students) {
            if (s.getRollNo() == roll) {
                System.out.println("Student Found: " + s);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student not found.");
        }
    }

    private static void saveToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Student s : students) {
                writer.println(s.getName() + "," + s.getRollNo() + "," + s.getGrade());
            }
            System.out.println("Data saved to " + FILE_NAME);
        } catch (IOException e) {
            System.out.println("Error saving to file: " + e.getMessage());
        }
    }

    private static void loadFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String name = parts[0];
                int rollNo = Integer.parseInt(parts[1]);
                double grade = Double.parseDouble(parts[2]);
                students.add(new Student(name, rollNo, grade));
            }
        } catch (IOException e) {
            System.out.println("Error loading from file: " + e.getMessage());
        }
    }
}
