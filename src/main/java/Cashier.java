class Cashier {
    private String name;
    private int id;

    public Cashier(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public synchronized void sell(Product product, int quantity) {
        if (product.getQuantity() >= quantity) {
            int totalPrice = quantity * product.getPrice();
            System.out.println(name + " sold " + quantity + " units of " + product.getItem() + " for " + totalPrice + " to " + Thread.currentThread().getName());
            product.sell(quantity);
        } else {
            System.out.println(name + " cannot sell " + quantity + " units of " + product.getItem() + " to " + Thread.currentThread().getName() + " due to insufficient quantity.");
        }

//        printReceipt(product,quantity);
    }

    public void printReceipt(Product product, int quantity) {
        System.out.println("===========================");
        System.out.println("Receipt for " + product.getItem() + ":");
        System.out.println("Quantity: " + quantity);
        System.out.println("Price: " + product.getPrice() * quantity);
        System.out.println("===========================");
    }
}
