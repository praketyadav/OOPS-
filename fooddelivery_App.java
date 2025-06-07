import java.util.*;

// Order status enum
enum OrderStatus {
    PENDING, PREPARING, OUT_FOR_DELIVERY, DELIVERED
}

// Strategy Interface for Delivery
interface DeliveryStrategy {
    void deliverOrder(String orderId, String address);
}

// Delivery by Bike
class BikeDelivery implements DeliveryStrategy {
    public void deliverOrder(String orderId, String address) {
        System.out.println("🚴 Delivering order " + orderId + " to " + address + " by bike.");
    }
}

// Delivery by Drone
class DroneDelivery implements DeliveryStrategy {
    public void deliverOrder(String orderId, String address) {
        System.out.println("🚁 Delivering order " + orderId + " to " + address + " by drone.");
    }
}

// Abstract User
abstract class User {
    protected String name;
    protected String userId;

    public User(String name, String userId) {
        this.name = name;
        this.userId = userId;
    }

    public abstract void viewProfile();
}

// Customer Class
class Customer extends User {
    private String address;
    private List<Order> orderHistory = new ArrayList<>();

    public Customer(String name, String userId, String address) {
        super(name, userId);
        this.address = address;
    }

    public void placeOrder(Restaurant restaurant, String itemName, DeliveryStrategy strategy) {
        Order order = new Order(UUID.randomUUID().toString(), this, restaurant, itemName, address, strategy);
        orderHistory.add(order);
        restaurant.receiveOrder(order);
    }

    @Override
    public void viewProfile() {
        System.out.println("👤 Customer: " + name + " | ID: " + userId + " | Address: " + address);
    }
}

// Restaurant Class
class Restaurant {
    private String name;
    private String location;
    private List<Order> orders = new ArrayList<>();

    public Restaurant(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public void receiveOrder(Order order) {
        System.out.println("🍽️ Order Received: " + order.getItemName() + " for " + order.getCustomer().name);
        orders.add(order);
        prepareOrder(order);
    }

    private void prepareOrder(Order order) {
        System.out.println("🧑‍🍳 Preparing order " + order.getOrderId() + "...");
        order.setStatus(OrderStatus.PREPARING);

        // Simulate delay and delivery
        try { Thread.sleep(1000); } catch (InterruptedException e) {}

        order.setStatus(OrderStatus.OUT_FOR_DELIVERY);
        order.deliver();
    }
}

// Order Class
class Order {
    private String orderId;
    private Customer customer;
    private Restaurant restaurant;
    private String itemName;
    private String deliveryAddress;
    private OrderStatus status;
    private DeliveryStrategy deliveryStrategy;

    public Order(String orderId, Customer customer, Restaurant restaurant, String itemName, String deliveryAddress, DeliveryStrategy strategy) {
        this.orderId = orderId;
        this.customer = customer;
        this.restaurant = restaurant;
        this.itemName = itemName;
        this.deliveryAddress = deliveryAddress;
        this.status = OrderStatus.PENDING;
        this.deliveryStrategy = strategy;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
        System.out.println("📦 Order " + orderId + " status: " + status);
    }

    public void deliver() {
        deliveryStrategy.deliverOrder(orderId, deliveryAddress);
        setStatus(OrderStatus.DELIVERED);
    }

    public String getOrderId() { return orderId; }
    public String getItemName() { return itemName; }
    public Customer getCustomer() { return customer; }
}

public class FoodDeliveryApp {
    public static void main(String[] args) {
        Restaurant res1 = new Restaurant("Spicy Bites", "Downtown");
        Customer cust1 = new Customer("Neha", "C101", "Sector 22, Noida");

        cust1.viewProfile();
        System.out.println("====\n");

        cust1.placeOrder(res1, "Paneer Butter Masala", new BikeDelivery());
        cust1.placeOrder(res1, "Veg Biryani", new DroneDelivery());
    }
}
