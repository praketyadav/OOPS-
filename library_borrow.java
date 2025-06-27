import java.util.*;

class Book {
    private String title;
    private String author;
    private boolean isAvailable = true;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void borrow() {
        isAvailable = false;
    }

    public void returnBook() {
        isAvailable = true;
    }

    public String getTitle() {
        return title;
    }

    public void displayInfo() {
        System.out.println("\"" + title + "\" by " + author + " - " + (isAvailable ? "Available" : "Checked out"));
    }
}

class LibraryUser {
    private String name;
    private List<Book> borrowedBooks = new ArrayList<>();

    public LibraryUser(String name) {
        this.name = name;
    }

    public void borrowBook(Book book) {
        if (book.isAvailable()) {
            book.borrow();
            borrowedBooks.add(book);
            System.out.println(name + " borrowed \"" + book.getTitle() + "\"");
        } else {
            System.out.println("Sorry, \"" + book.getTitle() + "\" is already borrowed.");
        }
    }

    public void returnBook(Book book) {
        if (borrowedBooks.remove(book)) {
            book.returnBook();
            System.out.println(name + " returned \"" + book.getTitle() + "\"");
        }
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        Book b1 = new Book("1984", "George Orwell");
        Book b2 = new Book("The Alchemist", "Paulo Coelho");

        LibraryUser user1 = new LibraryUser("Alice");
        LibraryUser user2 = new LibraryUser("Bob");

        b1.displayInfo();
        b2.displayInfo();

        user1.borrowBook(b1);
        user2.borrowBook(b1); // Already borrowed

        user1.returnBook(b1);
        user2.borrowBook(b1); // Now it's available

        b1.displayInfo();
        b2.displayInfo();
    }
}
