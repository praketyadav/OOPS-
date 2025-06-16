import java.util.Scanner;

// Abstract Class - Abstraction
abstract class Pet {
    protected String name;
    protected int energy;
    protected int happiness;

    public Pet(String name) {
        this.name = name;
        this.energy = 50;
        this.happiness = 50;
    }

    public abstract void makeSound(); // Polymorphism

    public void play() {
        if (energy >= 10) {
            happiness += 10;
            energy -= 10;
            System.out.println(name + " is playing and looks happy!");
        } else {
            System.out.println(name + " is too tired to play.");
        }
    }

    public void feed() {
        energy += 20;
        System.out.println(name + " enjoyed the food and gained energy.");
    }

    public void showStatus() {
        System.out.println(name + " | Energy: " + energy + " | Happiness: " + happiness);
    }
}

// Dog subclass - Inheritance
class Dog extends Pet {
    public Dog(String name) {
        super(name);
    }

    public void makeSound() {
        System.out.println(name + " says: Woof woof!");
    }
}

// Cat subclass
class Cat extends Pet {
    public Cat(String name) {
        super(name);
    }

    public void makeSound() {
        System.out.println(name + " says: Meow~");
    }
}

// Main Application
public class VirtualPetGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Choose your pet (dog/cat): ");
        String type = sc.nextLine().toLowerCase();

        System.out.print("Name your pet: ");
        String petName = sc.nextLine();

        Pet myPet;
        if (type.equals("dog")) {
            myPet = new Dog(petName);
        } else {
            myPet = new Cat(petName);
        }

        int choice;
        do {
            System.out.println("\n--- Virtual Pet Menu ---");
            System.out.println("1. Make Sound");
            System.out.println("2. Play");
            System.out.println("3. Feed");
            System.out.println("4. Show Status");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    myPet.makeSound();
                    break;
                case 2:
                    myPet.play();
                    break;
                case 3:
                    myPet.feed();
                    break;
                case 4:
                    myPet.showStatus();
                    break;
                case 5:
                    System.out.println("Goodbye! Take care of " + petName + "!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 5);

        sc.close();
    }
}
