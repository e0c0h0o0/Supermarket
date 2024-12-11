import java.time.LocalDateTime;
import java.util.List;

public class Order {
    private String orderId;
    private List<OrderProduct> products;
    private LocalDateTime purchaseDate;
    private double totalAmount;
    private String customerId;

    public Object getOrderId() {
        throw new UnsupportedOperationException("Unimplemented method 'getOrderId'");
    }
}
