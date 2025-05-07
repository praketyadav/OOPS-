import java.io.*;

public class FileExample {

    // Declaring that this method might throw FileNotFoundException
    public static void readFile() throws FileNotFoundException {
        FileInputStream file = new FileInputStream("test.txt");
        System.out.println("File opened successfully.");
    }

    public static void main(String[] args) {
        try {
            readFile(); // must be handled or declared
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}
