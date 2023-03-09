import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Store {
    public static void main(String[] args) {
        // Create products and store in a list
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("Apple", 10, 100));
        productList.add(new Product("Bread", 20, 200));
        productList.add(new Product("Milk", 30, 300));

        // Create cashiers and store in a list
        List<Cashier> cashiers = new ArrayList<>();
        cashiers.add(new Cashier("Mary", 1));
        cashiers.add(new Cashier("Helen", 2));

        // Create customers and start purchasing products concurrently
        for (int i = 1; i <= 5; i++) {
            Customer customer = new Customer("Customer" + i, i, productList, cashiers);
            customer.start();
        }
    }
}



