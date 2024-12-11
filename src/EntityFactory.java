public class EntityFactory {
    // Create an employee instance
    public static Employee createEmployee(String type, String name) {
        switch (type.toLowerCase()) {
            case "cashier":
                return new Cashier(name);
            case "stocker":
                return new Stocker(name);
            default:
                throw new IllegalArgumentException("Unknown employee type: " + type);
        }
    }

    // Create a customer instance
    public static Customer createCustomer(String name) {
        return new Customer(name);
    }

    // Create a product instance
    public static Product createProduct(String productID, String name, double price, double cost, int quantity,
            String category) {
        return new Product(productID, name, price, cost, quantity, category);
    }
}
