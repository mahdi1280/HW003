public class ShoppingCart {

    private Product product;
    private User user;
    private int count;
    private int price;

    public ShoppingCart(Product product, User user, int count, int price) {
        this.product = product;
        this.user = user;
        this.count = count;
        this.price = price;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "product=" + product +
                ", user=" + user +
                ", count=" + count +
                ", price=" + price +
                '}';
    }
}
