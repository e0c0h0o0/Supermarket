class Cashier extends Employee {
    public Cashier(String name) {
        super(name);
    }

    public void processPayment(Customer customer) {
        customer.checkout();
    }
}