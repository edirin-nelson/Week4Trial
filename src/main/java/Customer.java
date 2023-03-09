import java.util.List;
import java.util.Random;

class Customer extends Thread {
    private String name;
    private int id;
    private List<Product> products;
    private List<Cashier> cashiers;

    public Customer(String name, int id, List<Product> products, List<Cashier> cashiers) {
        this.name = name;
        this.id = id;
        this.products = products;
        this.cashiers = cashiers;
    }

    @Override
    public void run() {
        Random random = new Random();
        int productIndex = random.nextInt(products.size());
        Product product = products.get(productIndex);
        int quantity = random.nextInt(product.getQuantity()) + 1;

        int cashierIndex = random.nextInt(cashiers.size());
        Cashier cashier = cashiers.get(cashierIndex);

        System.out.println(name + " is purchasing " + quantity + " units of " + product.getItem() + " from " + cashier.getName());

        synchronized (cashier) {
            cashier.sell(product, quantity);
        }
    }
}
