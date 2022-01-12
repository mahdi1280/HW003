public class ShoppingCard {

    private ProductUser productUser=new ProductUser();
    private int index=0;

    public ShoppingCard(User user) {
        this.productUser.setUser(user);
    }

    public void add(ProductSel productSel){
        if(productSel.getProduct().getCount()< productSel.getCount()){
            System.out.println("not valid count");
            return;
        }
        if(index== 5){
            System.out.println("shopping cart is full.");
            return;
        }
        productUser.getProducts()[index++]= productSel;
    }

    public void remove(int id){
        productUser.getProducts()[id]=null;
        shift(id);
        this.index--;
    }

    public void showProduct(){
        System.out.println("count: "+ index);
        for(int i=0;i<index;i++){
            System.out.print(i+": ");
            System.out.println(productUser.getProducts()[i].toString());
        }
    }

    public void sumPrice(){
        int sum=0;
        for (ProductSel productSel:productUser.getProducts()) {
            sum += productSel.getPrice();
        }
        System.out.println("sum: q"+ sum);
    }

    public void confirm(){
        for (int i=0;i<index;i++){
            productUser.getProducts()[i].getProduct().setCount(productUser.getProducts()[i].getProduct().getCount() -  productUser.getProducts()[i].getCount());
        }
        productUser.setProducts(new ProductSel[5]);
        index=0;
    }

    private void shift(int index){
        for (int i = index+1; i <productUser.getProducts().length ; i++) {
            productUser.getProducts()[i-1] =  productUser.getProducts()[i];
        }
        productUser.getProducts()[productUser.getProducts().length-1] = null;
    }

    public ProductUser getProductUser() {
        return productUser;
    }

    public void setProductUser(ProductUser productUser) {
        this.productUser = productUser;
    }
}
