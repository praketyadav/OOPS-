import java.util.Scanner;
import java.util.regex.Pattern;

class EmailValidator {
    private String email;

    public EmailValidator(String email) {
        this.email = email;
    }

    public boolean isValid() {
        // Rule 1: Not null or empty
        if (email == null || email.isEmpty()) return false;

        // Rule 2: No spaces
        if (email.contains(" ")) return false;

        // Rule 3: Must contain @ and .
        if (!email.contains("@") || !email.contains(".")) return false;

        // Rule 4: Must match general email format
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return Pattern.matches(emailRegex, email);
    }

    public String getEmail() {
        return email;
    }
}

public class EmailValidatorApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("📧 Email Validator");

        System.out.print("Enter an email address: ");
        String input = scanner.nextLine();

        EmailValidator validator = new EmailValidator(input);

        if (validator.isValid()) {
            System.out.println("✅ \"" + validator.getEmail() + "\" is a valid email address.");
        } else {
            System.out.println("❌ \"" + validator.getEmail() + "\" is not a valid email address.");
        }
    }
}
