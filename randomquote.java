import java.util.Random;

public class RandomQuoteGenerator {
    public static void main(String[] args) {
        String[] quotes = {
            "Stay hungry, stay foolish.",
            "Code is like humor. When you have to explain it, it’s bad.",
            "Programs must be written for people to read.",
            "First, solve the problem. Then, write the code.",
            "Java is to JavaScript what car is to carpet."
        };

        Random random = new Random();
        int index = random.nextInt(quotes.length);

        System.out.println("Random Quote of the Day:");
        System.out.println("\"" + quotes[index] + "\"");
    }
}
