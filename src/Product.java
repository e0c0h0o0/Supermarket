import java.util.ArrayList;
import java.util.List;

public class Product implements Subject{
    private String name;
    private double price;
    private double cost;
    private int quantity;
    private String category;
    private List<Observer> observers; // Observers observing this product


    public Product(String name, double price, double cost, int quantity, String category) {
        this.name = name;
        this.price = price;
        this.cost = cost;
        this.quantity = quantity;
        this.category = category;
        this.observers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }


    public void setPrice(double discountedPrice) {
    }

    public double getCost() {
        return cost;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getCategory() {
        return category;
    }

    // Add observer
    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    // Remove observer
    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    // Notify all observers
    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

    public void reduceQuantity(int amount) {
        if (quantity >= amount) {
            quantity -= amount;
            if (quantity == 0) {
                notifyObservers(); // Notify stockers when stock reaches zero
            }
        } else {
            throw new IllegalArgumentException("Insufficient stock");
        }
    }

    // Restock product
    public void restock(int amount) {
        quantity += amount;
        System.out.println("Product " + name + " restocked with " + amount + " units.");
    }

    @Override
    public String toString() {
        return "Product{name='" + name + "', price=" + price +
                ", cost=" + cost + ", quantity=" + quantity + '}';
    }

}
