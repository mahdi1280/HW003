public class ShoppingCard {

    private int id;
    private int productId;
    private int userId;
    private int count;
    private int price;

    public ShoppingCard(int id, int productId, int userId, int count, int price) {
        this.id = id;
        this.productId = productId;
        this.userId = userId;
        this.count = count;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "ShoppingCard{" +
                "id=" + id +
                ", productId=" + productId +
                ", userId=" + userId +
                ", count=" + count +
                ", price=" + price +
                '}';
    }
}
