import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

public class FileExample {
    public static void main(String[] args) {
        try {
            // Writing to file
            FileWriter writer = new FileWriter("example.txt");
            writer.write("Hello from Java File Handling!");
            writer.close();

            // Reading from file
            FileReader reader = new FileReader("example.txt");
            int ch;
            while ((ch = reader.read()) != -1) {
                System.out.print((char) ch);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }
}
