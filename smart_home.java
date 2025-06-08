// Abstract base class for any smart device
abstract class SmartDevice {
    private String name;
    private boolean isOn;

    public SmartDevice(String name) {
        this.name = name;
        this.isOn = false;
    }

    public void turnOn() {
        isOn = true;
        System.out.println(name + " is now ON.");
    }

    public void turnOff() {
        isOn = false;
        System.out.println(name + " is now OFF.");
    }

    public boolean isOn() {
        return isOn;
    }

    public String getName() {
        return name;
    }

    // Abstract method to be implemented by each device type
    public abstract void showStatus();
}

// Subclass: Smart Light
class SmartLight extends SmartDevice {
    private String color = "White";

    public SmartLight(String name) {
        super(name);
    }

    public void changeColor(String newColor) {
        color = newColor;
        System.out.println(getName() + " color changed to " + color);
    }

    @Override
    public void showStatus() {
        System.out.println(getName() + " [Light] is " + (isOn() ? "ON" : "OFF") + " with color " + color);
    }
}

// Subclass: Smart Thermostat
class SmartThermostat extends SmartDevice {
    private int temperature = 22;

    public SmartThermostat(String name) {
        super(name);
    }

    public void setTemperature(int temp) {
        temperature = temp;
        System.out.println(getName() + " temperature set to " + temperature + "°C");
    }

    @Override
    public void showStatus() {
        System.out.println(getName() + " [Thermostat] is " + (isOn() ? "ON" : "OFF") + " at " + temperature + "°C");
    }
}

// Main class
public class SmartHomeDemo {
    public static void main(String[] args) {
        SmartDevice livingRoomLight = new SmartLight("Living Room Light");
        SmartDevice bedroomThermostat = new SmartThermostat("Bedroom Thermostat");

        livingRoomLight.turnOn();
        ((SmartLight) livingRoomLight).changeColor("Blue");

        bedroomThermostat.turnOn();
        ((SmartThermostat) bedroomThermostat).setTemperature(25);

        System.out.println("\n--- Device Statuses ---");
        livingRoomLight.showStatus();
        bedroomThermostat.showStatus();
    }
}
