import java.util.LinkedList;
import java.util.Queue;

public class CheckoutCounter {
    private String cashierName;
    private Queue<Customer> queue;

    public CheckoutCounter(String cashierName) {
        this.cashierName = cashierName;
        this.queue = new LinkedList<>();
    }

    public void addCustomer(Customer customer) {
        queue.offer(customer);
        System.out.println(customer.getName() + " joined the queue at counter " + cashierName);
    }

    public void processNextCustomer() {
        if (!queue.isEmpty()) {
            Customer customer = queue.poll();
            customer.checkout();
            System.out.println("Processed order for " + customer.getName() + " at counter " + cashierName);
        } else {
            System.out.println("No customers in queue at counter " + cashierName);
        }
    }
}
