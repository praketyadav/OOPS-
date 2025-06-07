import java.util.*;

// Enums for Ride Type
enum RideType {
    STANDARD, PREMIUM
}

// Interface for Ride Cost Strategy
interface FareStrategy {
    double calculateFare(double distanceInKm);
}

// Standard fare logic
class StandardFare implements FareStrategy {
    public double calculateFare(double distance) {
        return 10.0 + distance * 8.0; // Base fare + per km
    }
}

// Premium fare logic
class PremiumFare implements FareStrategy {
    public double calculateFare(double distance) {
        return 20.0 + distance * 12.0;
    }
}

// Abstract base User class
abstract class User {
    protected String name;
    protected String id;

    public User(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public abstract void displayProfile();
}

// Rider class
class Rider extends User {
    private List<Ride> rideHistory;

    public Rider(String name, String id) {
        super(name, id);
        this.rideHistory = new ArrayList<>();
    }

    public void requestRide(Driver driver, double distance, RideType type) {
        Ride ride = new Ride(this, driver, distance, type);
        rideHistory.add(ride);
        driver.acceptRide(ride);
        System.out.println("🚕 Ride Requested by " + name + " | Distance: " + distance + "km | Type: " + type);
        System.out.println("💰 Fare: ₹" + ride.calculateFare());
        System.out.println("🧾 ---");
    }

    @Override
    public void displayProfile() {
        System.out.println("👤 Rider: " + name + " | ID: " + id);
    }
}

// Driver class
class Driver extends User {
    private String vehicleNumber;

    public Driver(String name, String id, String vehicleNumber) {
        super(name, id);
        this.vehicleNumber = vehicleNumber;
    }

    public void acceptRide(Ride ride) {
        System.out.println("✅ Driver " + name + " accepted the ride.");
    }

    @Override
    public void displayProfile() {
        System.out.println("👤 Driver: " + name + " | Vehicle: " + vehicleNumber);
    }
}

// Ride class
class Ride {
    private Rider rider;
    private Driver driver;
    private double distance;
    private RideType rideType;
    private FareStrategy fareStrategy;

    public Ride(Rider rider, Driver driver, double distance, RideType rideType) {
        this.rider = rider;
        this.driver = driver;
        this.distance = distance;
        this.rideType = rideType;
        this.fareStrategy = getFareStrategy(rideType);
    }

    private FareStrategy getFareStrategy(RideType type) {
        return switch (type) {
            case STANDARD -> new StandardFare();
            case PREMIUM -> new PremiumFare();
        };
    }

    public double calculateFare() {
        return fareStrategy.calculateFare(distance);
    }
}

public class RideSharingApp {
    public static void main(String[] args) {
        Rider r1 = new Rider("Aarav", "R123");
        Driver d1 = new Driver("Rahul", "D987", "MH12XY1234");

        r1.displayProfile();
        d1.displayProfile();
        System.out.println("====\n");

        r1.requestRide(d1, 12.5, RideType.STANDARD);
        r1.requestRide(d1, 6.0, RideType.PREMIUM);
    }
}
