import java.util.ArrayList;
import java.util.List;

public class Section {
    protected String name;
    protected List<Product> products;

    public Section(String name) {
        this.name = name;
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    public void restockProduct(String productName, int quantity) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(productName)) {
                product.restock(quantity);
                return;
            }
        }
        throw new IllegalArgumentException("Product not found in section: " + productName);
    }

    @Override
    public String toString() {
        return "Section{name='" + name + "', products=" + products + '}';
    }
}


