import java.util.Scanner;

public class ArraySum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Input size of the array
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        // Step 2: Input elements of the array
        int[] array = new int[size];
        System.out.println("Enter " + size + " elements:");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }

        // Step 3: Calculate the sum of the elements
        int sum = 0;
        for (int num : array) {
            sum += num;
        }

        // Step 4: Print the sum
        System.out.println("The sum of the array elements is: " + sum);

        scanner.close();
    }
}
