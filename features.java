// Base class
class Employee {
    protected String name;
    protected int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void displayDetails() {
        System.out.println("ID: " + id + ", Name: " + name);
    }

    public double calculateSalary() {
        return 0; // Default implementation (overridden by subclasses)
    }
}

// Subclass for full-time employees
class FullTimeEmployee extends Employee {
    private double monthlySalary;

    public FullTimeEmployee(String name, int id, double monthlySalary) {
        super(name, id);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary;
    }
}

// Subclass for part-time employees
class PartTimeEmployee extends Employee {
    private double hourlyRate;
    private int hoursWorked;

    public PartTimeEmployee(String name, int id, double hourlyRate, int hoursWorked) {
        super(name, id);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateSalary() {
        return hourlyRate * hoursWorked;
    }
}

// Main class
public class EmployeeManagementSystem {
    public static void main(String[] args) {
        Employee e1 = new FullTimeEmployee("Alice", 101, 5000);
        Employee e2 = new PartTimeEmployee("Bob", 102, 20, 100);

        e1.displayDetails();
        System.out.println("Salary: $" + e1.calculateSalary());

        System.out.println("-----------------------------");

        e2.displayDetails();
        System.out.println("Salary: $" + e2.calculateSalary());
    }
}
