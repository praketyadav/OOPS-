import java.util.Scanner;

class ArrayUtils {
    public static double findAverage(int[] array) {
        if (array.length == 0) return 0; 
        
        int sum = 0;
        for (int num : array) {
            sum += num;
        }
        return (double) sum / array.length;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        
        int[] array = new int[size];
        
        System.out.println("Enter " + size + " elements:");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        
        double average = ArrayUtils.findAverage(array);
        System.out.println("The average is: " + average);
        
        scanner.close();
    }
}
