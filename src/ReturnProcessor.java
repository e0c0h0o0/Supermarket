public class ReturnProcessor {
    private InventoryManager inventoryManager;
    private FinanceManager financeManager;

    // How to process a return or exchange request
    public void processReturnRequest(ReturnRequest request) {
        if (request.isApproved()) {
            // Update Inventory
            inventoryManager.updateStock(request.getProductId(), request.getQuantity());
            // Processing refunds
            // Get order information and calculate refundable amount
            double refundAmount = calculateRefundAmount(request);
            financeManager.processRefund(request.getCustomerId(), refundAmount);
        }
    }

    // Method of calculating the refund amount
    private double calculateRefundAmount(ReturnRequest request) {
        return 0.0;
    }

}
