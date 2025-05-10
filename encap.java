class Person {
    // Private field
    private String name;

    // Getter method to access name
    public String getName() {
        return name;
    }

    // Setter method to set name
    public void setName(String newName) {
        name = newName;
    }
}

public class Main {
    public static void main(String[] args) {
        Person p = new Person();
        p.setName("John"); // Setting the name using setter
        System.out.println("Name: " + p.getName()); // Getting the name using getter
    }
}
