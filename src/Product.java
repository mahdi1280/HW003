public class Product {

    private String name;
    private int price;
    private int count;
    private CategoryType category;

    public Product(String name, int price, int count, CategoryType category) {
        this.name = name;
        this.price = price;
        this.count = count;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public CategoryType getCategory() {
        return category;
    }

    public void setCategory(CategoryType category) {
        this.category = category;
    }
}
