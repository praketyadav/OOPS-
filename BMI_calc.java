import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== BMI Calculator ===");

        System.out.print("Enter your weight in kilograms (kg): ");
        double weight = scanner.nextDouble();

        System.out.print("Enter your height in meters (m): ");
        double height = scanner.nextDouble();

        if (weight <= 0 || height <= 0) {
            System.out.println("❌ Invalid input! Weight and height must be positive.");
            return;
        }

        double bmi = weight / (height * height);
        System.out.printf("Your BMI is: %.2f\n", bmi);

        // Interpretation
        if (bmi < 18.5) {
            System.out.println("Category: Underweight");
        } else if (bmi < 24.9) {
            System.out.println("Category: Normal weight");
        } else if (bmi < 29.9) {
            System.out.println("Category: Overweight");
        } else {
            System.out.println("Category: Obese");
        }

        scanner.close();
    }
}
