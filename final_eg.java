// Final class: cannot be extended
final class ConstantValues {
    // Final variable: value cannot be changed
    final int MAX_USERS = 100;

    // Final method: cannot be overridden
    final void showMaxUsers() {
        System.out.println("Maximum allowed users: " + MAX_USERS);
    }
}

// The following class would cause an error if uncommented
// class ExtendedClass extends ConstantValues { } // Error: Cannot inherit from final class

public class FinalKeywordDemo {
    public static void main(String[] args) {
        ConstantValues obj = new ConstantValues();
        obj.showMaxUsers();

        // Trying to change the final variable will cause an error:
        // obj.MAX_USERS = 200; // Error: Cannot assign a value to final variable
    }
}
