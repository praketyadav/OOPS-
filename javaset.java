import java.util.*;

public class UniqueExample {

    // Function to return only unique elements
    public static List<Integer> unique(List<Integer> list) {
        Set<Integer> uniqueSet = new LinkedHashSet<>(list);
        return new ArrayList<>(uniqueSet);
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 3, 5, 2, 3, 9, 1, 2);
        System.out.println("Original List: " + numbers);

        List<Integer> uniqueNumbers = unique(numbers);
        System.out.println("Unique List: " + uniqueNumbers);
    }
}
