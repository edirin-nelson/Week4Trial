import java.util.Collections;

public class StoreTest {
    public static void main(String[] args) {
        testCashierSell();
        testCustomerRun();
    }

    private static void testCashierSell() {
        // Create a product with initial quantity of 10 and price of 100
        Product product = new Product("Item1", 10, 100);

        // Create a cashier
        Cashier cashier = new Cashier("Cashier1", 1);

        // Sell 5 units of the product using the cashier
        cashier.sell(product, 5);

        // Verify that the product quantity has been reduced to 5
        assert product.getQuantity() == 5 : "Product quantity is incorrect";

        // Sell 10 units of the product using the cashier (should fail due to insufficient quantity)
        cashier.sell(product, 10);

        // Verify that the product quantity has not been reduced further
        assert product.getQuantity() == 5 : "Product quantity is incorrect";
    }

    private static void testCustomerRun() {
        // Create a product with initial quantity of 10 and price of 100
        Product product = new Product("Item1", 10, 100);

        // Create a cashier
        Cashier cashier = new Cashier("Cashier1", 1);

        // Create a customer and purchase 5 units of the product
        Customer customer = new Customer("Customer1", 1, Collections.singletonList(product), Collections.singletonList(cashier));
        customer.run();

        // Verify that the product quantity has been reduced to 5
        assert product.getQuantity() == 5 : "Product quantity is incorrect";
    }
}

