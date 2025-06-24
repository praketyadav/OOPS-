import java.util.*;

// Base Product class
class Product {
    private int id;
    private String name;
    private double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }

    public void display() {
        System.out.println(id + " - " + name + " : ₹" + price);
    }
}

// Cart Item
class CartItem {
    private Product product;
    private int quantity;

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() { return product; }
    public int getQuantity() { return quantity; }
    public double getTotalPrice() { return product.getPrice() * quantity; }
}

// Shopping Cart
class ShoppingCart {
    private List<CartItem> items = new ArrayList<>();

    public void addItem(Product product, int quantity) {
        items.add(new CartItem(product, quantity));
        System.out.println(quantity + " x " + product.getName() + " added to cart.");
    }

    public void showCart() {
        System.out.println("\n🛍️  Your Cart:");
        double total = 0;
        for (CartItem item : items) {
            Product p = item.getProduct();
            System.out.println("- " + item.getQuantity() + " x " + p.getName() + " @ ₹" + p.getPrice() + " = ₹" + item.getTotalPrice());
            total += item.getTotalPrice();
        }
        System.out.println("Total Amount: ₹" + total + "\n");
    }

    public void checkout() {
        System.out.println("✅ Checkout complete. Thank you for shopping!");
        items.clear();
    }
}

public class ECommerceSystem {
    public static void main(String[] args) {
        // Sample products
        Product p1 = new Product(101, "Smartphone", 14999.99);
        Product p2 = new Product(102, "Laptop", 59999.00);
        Product p3 = new Product(103, "Headphones", 1999.49);

        ShoppingCart cart = new ShoppingCart();

        // Simulate adding to cart
        cart.addItem(p1, 1);
        cart.addItem(p3, 2);
        cart.addItem(p2, 1);

        // Show cart and checkout
        cart.showCart();
        cart.checkout();
    }
}
