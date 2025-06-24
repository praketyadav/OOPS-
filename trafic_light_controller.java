interface TrafficMode {
    void operate();
}

// Normal mode
class NormalMode implements TrafficMode {
    public void operate() {
        System.out.println("Normal Mode: Green → Yellow → Red → repeat");
    }
}

// Night mode
class NightMode implements TrafficMode {
    public void operate() {
        System.out.println("Night Mode: Flashing Yellow to caution drivers");
    }
}

// Emergency mode
class EmergencyMode implements TrafficMode {
    public void operate() {
        System.out.println("Emergency Mode: All lights RED to stop traffic");
    }
}

// Context class
class TrafficLight {
    private TrafficMode mode;

    public void setMode(TrafficMode mode) {
        this.mode = mode;
        System.out.println("Traffic mode set to: " + mode.getClass().getSimpleName());
    }

    public void start() {
        if (mode != null) {
            mode.operate();
        } else {
            System.out.println("No mode is set for the traffic light.");
        }
    }
}

public class TrafficControlSystem {
    public static void main(String[] args) {
        TrafficLight light = new TrafficLight();

        light.setMode(new NormalMode());
        light.start();

        light.setMode(new NightMode());
        light.start();

        light.setMode(new EmergencyMode());
        light.start();
    }
}
