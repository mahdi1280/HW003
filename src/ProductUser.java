public class ProductUser {

    private User user;
    private ProductSel[] products = new ProductSel[5];


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ProductSel[] getProducts() {
        return products;
    }

    public void setProducts(ProductSel[] products) {
        this.products = products;
    }
}
