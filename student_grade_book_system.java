import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private ArrayList<Integer> marks;

    public Student(String name) {
        this.name = name;
        this.marks = new ArrayList<>();
    }

    public void addMark(int mark) {
        marks.add(mark);
    }

    public double getAverage() {
        if (marks.isEmpty()) return 0;
        int sum = 0;
        for (int mark : marks) {
            sum += mark;
        }
        return (double) sum / marks.size();
    }

    public String getGrade() {
        double avg = getAverage();
        if (avg >= 90) return "A";
        else if (avg >= 80) return "B";
        else if (avg >= 70) return "C";
        else if (avg >= 60) return "D";
        else return "F";
    }

    public void displayReport() {
        System.out.println("Student: " + name);
        System.out.println("Marks: " + marks);
        System.out.println("Average: " + getAverage());
        System.out.println("Grade: " + getGrade());
        System.out.println("--------------------------");
    }
}

public class GradeBookApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.println("Welcome to the Grade Book System!");
        while (true) {
            System.out.print("Enter student name (or type 'done' to finish): ");
            String name = scanner.nextLine();
            if (name.equalsIgnoreCase("done")) break;

            Student student = new Student(name);

            System.out.print("How many marks to enter for " + name + "? ");
            int numMarks = Integer.parseInt(scanner.nextLine());

            for (int i = 0; i < numMarks; i++) {
                System.out.print("Enter mark #" + (i + 1) + ": ");
                int mark = Integer.parseInt(scanner.nextLine());
                student.addMark(mark);
            }

            students.add(student);
        }

        System.out.println("\n=== Grade Report ===");
        for (Student s : students) {
            s.displayReport();
        }

        scanner.close();
    }
}
