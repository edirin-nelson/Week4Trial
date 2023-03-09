class Product {
    private String item;
    private int quantity;
    private int price;

    public Product(String item, int quantity, int price) {
        this.item = item;
        this.quantity = quantity;
        this.price = price;
    }

    public String getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void sell(int quantity) {
        this.quantity -= quantity;
    }
}
