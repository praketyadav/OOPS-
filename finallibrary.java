import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Base class
class Book {
    protected final String title;  // final variable
    protected final String author; // final variable
    protected boolean isBorrowed;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isBorrowed = false;
    }

    public final void borrow() { // final method
        if (!isBorrowed) {
            isBorrowed = true;
            System.out.println(title + " has been borrowed.");
        } else {
            System.out.println(title + " is already borrowed.");
        }
    }

    public final void returnBook() { // final method
        if (isBorrowed) {
            isBorrowed = false;
            System.out.println(title + " has been returned.");
        } else {
            System.out.println(title + " wasn't borrowed.");
        }
    }

    public void displayInfo() {
        System.out.println("Title: " + title + ", Author: " + author + ", Available: " + !isBorrowed);
    }
}

// final class
final class RareBook extends Book {
    public RareBook(String title, String author) {
        super(title, author);
    }

    @Override
    public void displayInfo() {
        System.out.println("[Rare Book] Title: " + title + ", Author: " + author + ", Available: " + !isBorrowed);
    }
}

// Main Application
public class LibraryManagementSystem {
    public static void main(String[] args) {
        List<Book> library = new ArrayList<>();
        library.add(new Book("1984", "George Orwell"));
        library.add(new RareBook("First Folio", "William Shakespeare"));

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nLibrary Menu:");
            System.out.println("1. Display Books");
            System.out.println("2. Borrow Book");
            System.out.println("3. Return Book");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    for (int i = 0; i < library.size(); i++) {
                        System.out.print((i + 1) + ". ");
                        library.get(i).displayInfo();
                    }
                    break;
                case 2:
                    System.out.print("Enter book number to borrow: ");
                    int borrowIndex = scanner.nextInt() - 1;
                    if (borrowIndex >= 0 && borrowIndex < library.size()) {
                        library.get(borrowIndex).borrow();
                    } else {
                        System.out.println("Invalid book number.");
                    }
                    break;
                case 3:
                    System.out.print("Enter book number to return: ");
                    int returnIndex = scanner.nextInt() - 1;
                    if (returnIndex >= 0 && returnIndex < library.size()) {
                        library.get(returnIndex).returnBook();
                    } else {
                        System.out.println("Invalid book number.");
                    }
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
