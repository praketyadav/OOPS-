// Parent class
class Parent {
    void showMessage() {
        System.out.println("This is the parent class.");
    }
}

// Child class inheriting from Parent
class Child extends Parent {
    void showChildMessage() {
        System.out.println("This is the child class.");
    }
}

public class InheritanceExample {
    public static void main(String[] args) {
        // Creating an object of Child class
        Child obj = new Child();
        
        // Calling method from Parent class
        obj.showMessage();
        
        // Calling method from Child class
        obj.showChildMessage();
    }
}
