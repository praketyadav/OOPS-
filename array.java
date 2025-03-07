import java.util.Arrays;

public class ArraySorter {
    public static void main(String[] args) {
        int[] numbers = {5, 2, 9, 1, 5, 6};
        
        // Using built-in sort method
        Arrays.sort(numbers);
        System.out.println("Sorted using Arrays.sort(): " + Arrays.toString(numbers));
        
        // Reset array for Bubble Sort
        int[] numbers2 = {5, 2, 9, 1, 5, 6};
        bubbleSort(numbers2);
        System.out.println("Sorted using Bubble Sort: " + Arrays.toString(numbers2));
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j + 1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
