public class StockLog {
    private String productName;
    private String operationType; // "IN" or "OUT"
    private int quantity;
    private String timestamp;

    public StockLog(String productName, String operationType, int quantity, String timestamp) {
        this.productName = productName;
        this.operationType = operationType;
        this.quantity = quantity;
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "StockLog{" +
                "productName='" + productName + '\'' +
                ", operationType='" + operationType + '\'' +
                ", quantity=" + quantity +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}
