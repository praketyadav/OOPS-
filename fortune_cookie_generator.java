import java.util.*;

public class FortuneCookieGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello! How are you feeling today?");
        String input = scanner.nextLine().toLowerCase();

        String mood = detectMood(input);
        String fortune = getFortune(mood);

        System.out.println("\nDetected mood: " + mood.substring(0, 1).toUpperCase() + mood.substring(1));
        System.out.println("🌟 Your Fortune: " + fortune);
    }

    private static String detectMood(String input) {
        if (input.contains("happy") || input.contains("excited")) {
            return "happy";
        } else if (input.contains("sad") || input.contains("down")) {
            return "sad";
        } else if (input.contains("angry") || input.contains("mad")) {
            return "angry";
        } else if (input.contains("tired") || input.contains("bored")) {
            return "bored";
        } else {
            return "neutral";
        }
    }

    private static String getFortune(String mood) {
        Map<String, List<String>> fortunes = new HashMap<>();
        fortunes.put("happy", Arrays.asList(
            "A surprise gift will make your day even brighter!",
            "You will spread your joy to others today."
        ));
        fortunes.put("sad", Arrays.asList(
            "Better days are coming. Keep your head up.",
            "You are stronger than you think. The storm will pass."
        ));
        fortunes.put("angry", Arrays.asList(
            "Take a deep breath—peace is just around the corner.",
            "A calm mind brings inner strength. Let go today."
        ));
        fortunes.put("bored", Arrays.asList(
            "An unexpected journey will lift your spirits. Say yes more often!",
            "New hobbies will open doors you never imagined."
        ));
        fortunes.put("neutral", Arrays.asList(
            "Every moment holds a possibility. Stay curious!",
            "The ordinary is often extraordinary in disguise."
        ));

        List<String> selectedFortunes = fortunes.getOrDefault(mood, fortunes.get("neutral"));
        return selectedFortunes.get(new Random().nextInt(selectedFortunes.size()));
    }
}
