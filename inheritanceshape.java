class Shape {
    public void display() {
        System.out.println("This is a shape.");
    }
}

class Circle extends Shape {
    private double radius;

    public Circle(double r) {
        radius = r;
    }

    public double area() {
        return Math.PI * radius * radius;
    }

    public void display() {
        super.display();
        System.out.println("This is a circle with area: " + area());
    }
}

public class InheritanceExample {
    public static void main(String[] args) {
        Circle c = new Circle(5);
        c.display();
    }
}
