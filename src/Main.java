import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create supermarket
        Supermarket supermarket = new Supermarket("Skylar's Supermarket");

        // Create sections and add them to the supermarket
        Section deliSection = new DeliSection();
        Section furnitureSection = new FurnitureSection();
        supermarket.addSection(deliSection.name);
        supermarket.addSection(furnitureSection.name);

        // Use EntityFactory to create products and add them to sections
        Product apple = EntityFactory.createProduct("12", "Apple", 0.5, 0.3, 10, "Fruits");
        Product table = EntityFactory.createProduct("13", "Table", 50.0, 30.0, 5, "Furniture");
        deliSection.addProduct(apple);
        furnitureSection.addProduct(table);

        // Use EntityFactory to create employees
        Employee cashier1 = EntityFactory.createEmployee("cashier", "Alice");
        Employee stocker1 = EntityFactory.createEmployee("stocker", "Bob");

        // Use EntityFactory to create customers
        Customer customer1 = EntityFactory.createCustomer("John");
        Customer customer2 = EntityFactory.createCustomer("Emma");

        // Add stocker as observer for the product
        apple.addObserver((Stocker) stocker1);

        // Customers add products to their cart
        customer1.getCart().addItem(apple, 5);
        customer1.getCart().addItem(table, 1);
        customer2.getCart().addItem(apple, 5); // Apple stock will deplete, triggering notification

        // Create a checkout counter and assign customers to it
        CheckoutCounter counter1 = new CheckoutCounter(cashier1.getName());
        counter1.addCustomer(customer1);
        counter1.addCustomer(customer2);

        // Customers select payment methods
        customer1.setPaymentStrategy(new CreditCardPayment());
        customer2.setPaymentStrategy(new CashPayment());

        // Process checkouts
        System.out.println("\n--- Processing Checkouts ---");
        counter1.processNextCustomer(); // Process checkout for customer1
        counter1.processNextCustomer(); // Process checkout for customer2

        // Stocker restocks inventory
        System.out.println("\n--- Restocking Inventory ---");
        ((Stocker) stocker1).restockProduct(deliSection, apple, 20);

        // Record total revenue and display financial report
        FinancialTracker financialTracker = new FinancialTracker();
        financialTracker.recordRevenue(50.5); // Revenue from customer1
        financialTracker.recordRevenue(2.5); // Revenue from customer2
        System.out.println("\n--- Financial Report ---");
        System.out.println(financialTracker);
    }
}
