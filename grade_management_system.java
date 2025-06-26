import java.util.*;

class Student {
    private String name;
    private List<Integer> grades;

    public Student(String name) {
        this.name = name;
        this.grades = new ArrayList<>();
    }

    public void addGrade(int grade) {
        grades.add(grade);
    }

    public double getAverage() {
        if (grades.isEmpty()) return 0.0;
        int sum = 0;
        for (int g : grades) sum += g;
        return (double) sum / grades.size();
    }

    public String getName() {
        return name;
    }

    public List<Integer> getGrades() {
        return grades;
    }

    public void printReportCard() {
        System.out.println("\n📋 Report Card for " + name);
        if (grades.isEmpty()) {
            System.out.println("No grades available.");
        } else {
            System.out.println("Grades: " + grades);
            System.out.printf("Average: %.2f\n", getAverage());
        }
    }
}

public class GradeManagementSystem {
    private static Scanner sc = new Scanner(System.in);
    private static List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n📚 Student Grade Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Add Grade to Student");
            System.out.println("3. View Report Card");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();
            sc.nextLine(); // clear newline

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> addGrade();
                case 3 -> viewReportCard();
                case 4 -> System.out.println("Goodbye!");
                default -> System.out.println("Invalid option!");
            }
        } while (choice != 4);
    }

    private static void addStudent() {
        System.out.print("Enter student name: ");
        String name = sc.nextLine();
        students.add(new Student(name));
        System.out.println("✅ Student added.");
    }

    private static void addGrade() {
        Student s = findStudent();
        if (s != null) {
            System.out.print("Enter grade (0–100): ");
            int grade = sc.nextInt();
            if (grade >= 0 && grade <= 100) {
                s.addGrade(grade);
                System.out.println("✅ Grade added.");
            } else {
                System.out.println("❌ Invalid grade.");
            }
        }
    }

    private static void viewReportCard() {
        Student s = findStudent();
        if (s != null) {
            s.printReportCard();
        }
    }

    private static Student findStudent() {
        System.out.print("Enter student name: ");
        String name = sc.nextLine();
        for (Student s : students) {
            if (s.getName().equalsIgnoreCase(name)) return s;
        }
        System.out.println("❌ Student not found.");
        return null;
    }
}
