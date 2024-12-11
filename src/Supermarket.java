import java.util.HashMap;
import java.util.Map;

public class Supermarket {
    private String name;
    private Map<String, Section> sections;
    private Map<String, CheckoutCounter> counters;

    public Supermarket(String name) {
        this.name = name;
        this.sections = new HashMap<>();
        this.counters = new HashMap<>();
    }

    public void addSection(String sectionName) {
        sections.putIfAbsent(sectionName, new Section(sectionName));
    }

    public void addProductToSection(String sectionName, Product product) {
        Section section = sections.get(sectionName);
        if (section != null) {
            section.addProduct(product);
        }
    }

    public void addCheckoutCounter(String cashierName) {
        counters.putIfAbsent(cashierName, new CheckoutCounter(cashierName));
    }

    public void processCheckout(String cashierName) {
        CheckoutCounter counter = counters.get(cashierName);
        if (counter != null) {
            counter.processNextCustomer();
        }
    }
}
