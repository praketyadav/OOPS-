class Student {
    // Private data members (encapsulation)
    private String name;
    private int age;

    // Public getter and setter methods to access private data
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age > 0) {
            this.age = age;
        }
    }
}

public class EncapsulationDemo {
    public static void main(String[] args) {
        Student s = new Student();

        // Set values using setters
        s.setName("John");
        s.setAge(20);

        // Get values using getters
        System.out.println("Student Name: " + s.getName());
        System.out.println("Student Age: " + s.getAge());
    }
}
