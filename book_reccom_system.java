import java.util.*;

class Book {
    private String title;
    private String genre;

    public Book(String title, String genre) {
        this.title = title;
        this.genre = genre;
    }

    public String getDetails() {
        return "\"" + title + "\" [" + genre + "]";
    }

    public String getGenre() {
        return genre;
    }
}

class User {
    private String name;
    private String preferredGenre;

    public User(String name, String preferredGenre) {
        this.name = name;
        this.preferredGenre = preferredGenre;
    }

    public String getName() {
        return name;
    }

    public String getPreferredGenre() {
        return preferredGenre;
    }
}

class RecommendationSystem {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book b) {
        books.add(b);
    }

    public void recommendBook(User user) {
        System.out.println("Hello, " + user.getName() + "! Based on your interest in " +
            user.getPreferredGenre() + ", we recommend:");

        for (Book book : books) {
            if (book.getGenre().equalsIgnoreCase(user.getPreferredGenre())) {
                System.out.println("-> " + book.getDetails());
                return;
            }
        }

        System.out.println("Sorry, no books found in your preferred genre right now.");
    }
}

public class LibraryApp {
    public static void main(String[] args) {
        RecommendationSystem system = new RecommendationSystem();

        system.addBook(new Book("The Silent Patient", "Thriller"));
        system.addBook(new Book("Atomic Habits", "Self-Help"));
        system.addBook(new Book("Dune", "Sci-Fi"));
        system.addBook(new Book("Harry Potter", "Fantasy"));

        User user1 = new User("Anika", "Sci-Fi");
        User user2 = new User("Ravi", "Fantasy");
        User user3 = new User("Meera", "History");

        system.recommendBook(user1);
        system.recommendBook(user2);
        system.recommendBook(user3);
    }
}
