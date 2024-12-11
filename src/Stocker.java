class Stocker extends Employee implements Observer{
    public Stocker(String name) {
        super(name);
    }

    @Override
    public void update(Object subject) {
        if (subject instanceof Product) {
            Product product = (Product) subject;
            System.out.println("Stocker " + name + ": Product \"" + product.getName() +
                    "\" is out of stock. Please restock!");
        }
    }

    public void restockProduct(Section section, Product product, int quantity) {
        product.restock(quantity);
        System.out.println("Restocked " + quantity + " units of " + product.getName() + " in " + section.name);
    }
}