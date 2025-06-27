enum SignalColor {
    RED, YELLOW, GREEN
}

class TrafficLight {
    private SignalColor color;
    private int timer; // in seconds

    public TrafficLight() {
        this.color = SignalColor.RED;
        this.timer = 60;
    }

    public void changeColor() {
        switch (color) {
            case RED:
                color = SignalColor.GREEN;
                timer = 45;
                break;
            case GREEN:
                color = SignalColor.YELLOW;
                timer = 5;
                break;
            case YELLOW:
                color = SignalColor.RED;
                timer = 60;
                break;
        }
    }

    public void displayStatus() {
        System.out.println("Signal is " + color + " for " + timer + " seconds.");
    }

    public SignalColor getColor() {
        return color;
    }
}

class Intersection {
    private String name;
    private TrafficLight light;

    public Intersection(String name) {
        this.name = name;
        this.light = new TrafficLight();
    }

    public void cycle() {
        System.out.println("=== Intersection: " + name + " ===");
        light.displayStatus();
        light.changeColor();
        light.displayStatus();
    }
}

public class TrafficSimulation {
    public static void main(String[] args) {
        Intersection i1 = new Intersection("Main St & 5th Ave");
        Intersection i2 = new Intersection("Central Blvd & Elm St");

        i1.cycle();
        System.out.println();
        i2.cycle();
    }
}
