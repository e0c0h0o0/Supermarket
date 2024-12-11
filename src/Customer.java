public class Customer implements Observer{
    private String name;
    private Cart cart;
    private PaymentStrategy paymentStrategy;

    public Customer(String name) {
        this.name = name;
        this.cart = new Cart();
    }

    public String getName() {
        return name;
    }

    public Cart getCart() {
        return cart;
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout() {
        double total = cart.calculateTotal();
        if (paymentStrategy == null) {
            throw new IllegalStateException("Payment strategy not set");
        }
        paymentStrategy.pay(total);
        cart.clear();
        System.out.println("Checkout complete for " + name);
    }

    @Override
    public void update(Object subject) {
        if (subject instanceof Promotion) {
            Promotion promotion = (Promotion) subject;
            System.out.println("Customer " + name + ": New promotion \"" + promotion.getName() +
                    "\" available with " + (promotion.getDiscountRate() * 100) + "% off!");
        }
    }
}
