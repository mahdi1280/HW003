import java.util.ArrayList;
import java.util.List;

public class Shop {

    private List<User> users = new ArrayList<>();
    private List<ShoppingCart> shoppingCarts = new ArrayList<>();
    private List<Product> products=new ArrayList<>();


    public void saveUser(User user){
        this.users.add(user);
    }

    public void addProduct(User user,int count,int productIndex){
       int sum=0;
        ShoppingCart shoppingCart = new ShoppingCart(this.products.get(productIndex),user,count,count*this.products.get(productIndex).getPrice());
        for(ShoppingCart sh : this.shoppingCarts){
            if(sh.getUser().equals(shoppingCart.getUser())) {
                sum++;
                if (sh.getProduct().equals(shoppingCart.getProduct())) {
                    sh.setCount(sh.getCount() + shoppingCart.getCount());
                    return;
                }
            }
        }
        if(sum> 5 ){
            System.out.println("count product to long");
            return;
        }
        this.shoppingCarts.add(shoppingCart);
        System.out.println("insert success!");
    }

    public void deleted(int shoppingCartIndex){
        shoppingCarts.remove(shoppingCartIndex);
        System.out.println("delete success!");
    }

    public void showShoppingCart(User user){
        for (int i=0;i<this.shoppingCarts.size();i++) {
            if(this.shoppingCarts.get(i).getUser().equals(user)){
                System.out.println(i+" : "+this.shoppingCarts.get(i).toString());
            }
        }
    }

    public void totalPriceShoppingCart(User user){
        int sum=0;
        for (ShoppingCart shoppingCart :this.shoppingCarts) {
            if(shoppingCart.getUser().equals(user)){
                sum+= shoppingCart.getPrice();
            }
        }
        System.out.println("total price: "+ sum);
    }

    public void confirm(User user){
        for (ShoppingCart shoppingCart :this.shoppingCarts) {
            if(shoppingCart.getUser().equals(user) &&
                shoppingCart.getCount() > shoppingCart.getProduct().getCount()){
                System.out.println("quantity selected by you: "+shoppingCart.getCount());
                System.out.println("quantity product: "+ shoppingCart.getProduct().getCount());
                return;
            }
        }
        for (int i=0;i<this.shoppingCarts.size();i++) {
            if(this.shoppingCarts.get(i).getUser().equals(user)){
                this.shoppingCarts.get(i).getProduct().setCount(this.shoppingCarts.get(i).getProduct().getCount() - this.shoppingCarts.get(i).getCount());
                this.shoppingCarts.remove(this.shoppingCarts.get(i));
            }
        }
        System.out.println("confirm is Ok");
    }

    public void showProduct(){
        for(int i=0;i<this.products.size();i++){
            System.out.println(i+" : "+products.get(i).toString());
        }
    }

    public void addProduct(Product product){
        this.products.add(product);
    }
}
