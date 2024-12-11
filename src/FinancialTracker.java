public class FinancialTracker {
    private double totalRevenue;
    private double inventoryCost;

    public FinancialTracker() {
        this.totalRevenue = 0.0;
        this.inventoryCost = 0.0;
    }

    public void recordRevenue(double amount) {
        totalRevenue += amount;
    }

    public void recordInventoryCost(double cost) {
        inventoryCost += cost;
    }

    public double calculateNetProfit() {
        return totalRevenue - inventoryCost;
    }

    @Override
    public String toString() {
        return "FinancialTracker{" +
                "totalRevenue=" + totalRevenue +
                ", inventoryCost=" + inventoryCost +
                ", netProfit=" + calculateNetProfit() +
                '}';
    }
}
