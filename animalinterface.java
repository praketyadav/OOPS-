// Interface definition
interface Animal {
    void sound();
}

// Class implementing the interface
class Dog implements Animal {
    public void sound() {
        System.out.println("Dog barks: Woof Woof");
    }
}

class Cat implements Animal {
    public void sound() {
        System.out.println("Cat meows: Meow Meow");
    }
}

public class InterfaceExample {
    public static void main(String[] args) {
        Animal a1 = new Dog();
        Animal a2 = new Cat();

        a1.sound();
        a2.sound();
    }
}
