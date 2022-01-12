public class ProductSel {

    private int count;
    private int price;
    private Product product;

    public ProductSel(int count, int price, Product product) {
        this.count = count;
        this.price = price;
        this.product = product;
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return count+" "+price+" "+product.getName();
    }
}
