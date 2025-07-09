import java.util.*;

class Student {
    String name;
    ArrayList<Integer> marks;

    Student(String name) {
        this.name = name;
        this.marks = new ArrayList<>();
    }

    void addMark(int mark) {
        marks.add(mark);
    }

    double getAverage() {
        if (marks.isEmpty()) return 0;
        int total = 0;
        for (int mark : marks) total += mark;
        return (double) total / marks.size();
    }

    @Override
    public String toString() {
        return name + " - Marks: " + marks + " | Avg: " + String.format("%.2f", getAverage());
    }
}

public class GradeTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Student> students = new HashMap<>();
        int choice;

        while (true) {
            System.out.println("\n=== Student Grade Tracker ===");
            System.out.println("1. Add Student");
            System.out.println("2. Add Mark to Student");
            System.out.println("3. View All Students");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt(); scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    students.put(name, new Student(name));
                    System.out.println("✅ Student added.");
                    break;

                case 2:
                    System.out.print("Enter student name: ");
                    String stuName = scanner.nextLine();
                    Student student = students.get(stuName);
                    if (student == null) {
                        System.out.println("❌ Student not found.");
                    } else {
                        System.out.print("Enter mark (0–100): ");
                        int mark = scanner.nextInt();
                        scanner.nextLine();
                        student.addMark(mark);
                        System.out.println("✅ Mark added.");
                    }
                    break;

                case 3:
                    if (students.isEmpty()) {
                        System.out.println("📭 No students found.");
                    } else {
                        System.out.println("\n📚 Student Records:");
                        for (Student s : students.values()) {
                            System.out.println(s);
                        }
                    }
                    break;

                case 4:
                    System.out.println("👋 Exiting Grade Tracker.");
                    return;

                default:
                    System.out.println("⚠️ Invalid choice. Try again.");
            }
        }
    }
}
