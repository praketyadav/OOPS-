import java.util.Scanner;

// Abstract Device Class (Abstraction)
abstract class SmartDevice {
    private String name;
    private boolean status;

    public SmartDevice(String name) {
        this.name = name;
        this.status = false;
    }

    public String getName() {
        return name;
    }

    public void turnOn() {
        status = true;
        System.out.println(name + " is turned ON.");
    }

    public void turnOff() {
        status = false;
        System.out.println(name + " is turned OFF.");
    }

    public boolean isOn() {
        return status;
    }

    // Abstract method (Polymorphism)
    public abstract void performFunction();
}

// Subclass 1 (Inheritance)
class SmartLight extends SmartDevice {
    public SmartLight(String name) {
        super(name);
    }

    public void performFunction() {
        if (isOn()) {
            System.out.println(getName() + " is now glowing with warm light.");
        } else {
            System.out.println(getName() + " is off. Please turn it on first.");
        }
    }
}

// Subclass 2
class SmartFan extends SmartDevice {
    public SmartFan(String name) {
        super(name);
    }

    public void performFunction() {
        if (isOn()) {
            System.out.println(getName() + " is spinning at medium speed.");
        } else {
            System.out.println(getName() + " is off. Please turn it on first.");
        }
    }
}

// Main Class
public class SmartHome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        SmartDevice light = new SmartLight("Living Room Light");
        SmartDevice fan = new SmartFan("Bedroom Fan");

        System.out.println("Welcome to Smart Home System");
        System.out.println("1. Turn on devices");
        System.out.println("2. Use devices");
        System.out.println("3. Turn off devices");
        System.out.println("4. Exit");

        int choice;
        do {
            System.out.print("\nEnter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    light.turnOn();
                    fan.turnOn();
                    break;
                case 2:
                    light.performFunction();
                    fan.performFunction();
                    break;
                case 3:
                    light.turnOff();
                    fan.turnOff();
                    break;
                case 4:
                    System.out.println("Exiting Smart Home. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 4);

        scanner.close();
    }
}
