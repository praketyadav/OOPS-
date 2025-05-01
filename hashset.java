import java.util.HashSet;

public class UniqueNames {
    public static void main(String[] args) {
        // Step 1: Array with duplicate names
        String[] names = { "Aman", "Varchasv", "Divyansh", "Varchasv", "Aman" };

        // Step 2: Store names in HashSet to eliminate duplicates
        HashSet<String> uniqueNames = new HashSet<>();
        for (String name : names) {
            uniqueNames.add(name);
        }

        // Step 3: Check if a specific name exists
        String searchName = "Divyansh";
        if (uniqueNames.contains(searchName)) {
            System.out.println(searchName + " is in the set.");
        } else {
            System.out.println(searchName + " is not in the set.");
        }

        // Step 4: Print all unique names
        System.out.println("Unique names:");
        for (String name : uniqueNames) {
            System.out.println(name);
        }
    }
}
