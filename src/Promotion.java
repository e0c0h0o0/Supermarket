import java.util.ArrayList;
import java.util.List;

public class Promotion implements Subject{
    private String name; // Name of the promotion
    private double discountRate; // Discount rate (e.g., 0.2 for 20% off)
    private List<Product> applicableProducts; // List of products eligible for this promotion
    private List<Observer> observers; // 订阅该促销的观察者（顾客）

    // Constructor
    public Promotion(String name, double discountRate, List<Product> applicableProducts) {
        this.name = name;
        this.discountRate = discountRate;
        this.applicableProducts = applicableProducts;
        this.observers = new ArrayList<>();
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }

    public List<Product> getApplicableProducts() {
        return applicableProducts;
    }

    public void setApplicableProducts(List<Product> applicableProducts) {
        this.applicableProducts = applicableProducts;
    }

    // Apply promotion to a specific product
    public void applyToProduct(Product product) {
        if (applicableProducts.contains(product)) {
            double originalPrice = product.getPrice();
            double discountedPrice = originalPrice * (1 - discountRate);
            product.setPrice(discountedPrice); // Update the product price
            System.out.println("Promotion \"" + name + "\" applied to product: " + product.getName() +
                    ", Original Price: $" + originalPrice + ", Discounted Price: $" + discountedPrice);
        } else {
            System.out.println("Product " + product.getName() + " is not eligible for promotion \"" + name + "\".");
        }
    }

    // 实现 Subject 接口方法
    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

}