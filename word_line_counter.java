import java.io.*;
import java.util.Scanner;

public class FileWordCounter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter path to the text file: ");
        String filePath = input.nextLine();

        int wordCount = 0;
        int lineCount = 0;
        int charCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                lineCount++;
                charCount += line.length();
                String[] words = line.trim().split("\\s+");

                if (!line.trim().isEmpty()) {
                    wordCount += words.length;
                }
            }

            System.out.println("\n--- File Analysis ---");
            System.out.println("Lines: " + lineCount);
            System.out.println("Words: " + wordCount);
            System.out.println("Characters (excluding newlines): " + charCount);

        } catch (IOException e) {
            System.out.println("❌ Error reading file: " + e.getMessage());
        }

        input.close();
    }
}
