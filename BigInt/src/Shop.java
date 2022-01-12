public class Shop {

    private Product[] products=new Product[10];
    private int productIndex =0;

    private User[] users = new User[10];
    private int userIndex=0;

    private ShoppingCard[] shoppingCards=new ShoppingCard[10];
    private int shoppingCardIndex=0;

    public void createProduct(Product product){
        products[productIndex++] = product;
    }

    public void findProduct(int id){
        for (Product product: products) {
            if(product.getId() == id){
                System.out.println(product);
            }
        }
    }

    public void delete(int id){
        for (int i = 0; i<this.productIndex; i++) {
            if(products[i].getId() == id){
                products[i] = null;
                break;
            }
        }
        for(int i = productIndex +1; i< this.productIndex; i++){
     this.products[i-1] = this.products[i];
        }
        this.productIndex--;
    }

    public void createUser(User user){
        users[userIndex++] = user;
    }

    public void findUser(int id){
        for (User user: users) {
            if(user.getId() == id){
                System.out.println(user);
            }
        }
    }

    public void buyProduct(int userId,int productId,int count){
        int price=0;
        for (int i = 0; i < products.length; i++) {
            if(products[i].getId() == productId){
                price = products[i].getPrice();
                break;
            }
        }
        ShoppingCard shoppingCard=new ShoppingCard(shoppingCardIndex,productId,userId,count,price*count);
        shoppingCards[shoppingCardIndex++] = shoppingCard;
    }


    public void showProduct(){
        for (int i=0;i<this.productIndex;i++) {
            System.out.println(products[i]);
        }
    }

    public void showShoppingCard(){
        for (int i = 0; i < shoppingCardIndex; i++) {
            System.out.println(shoppingCards[i]);
        }
    }
}
