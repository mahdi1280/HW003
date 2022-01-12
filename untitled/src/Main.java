import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Shop shop=new Shop();
        Product product=new Product("asd","asda",123300000
                ,123,new Category("electronic"));
        Product product1=new Product("asfdd","asda",1239300000
                ,123,new Category("electronic"));
        Product product2=new Product("ashjyhd","asda",1253300000
                ,123,new Category("electronic"));
        Product product3=new Product("atyusd","asda",1233300000
                ,123,new Category("electronic"));
        Product product4=new Product("asryd","asda",1023300000
                ,123,new Category("electronic"));
        shop.addProduct(product);
        shop.addProduct(product1);
        shop.addProduct(product2);
        shop.addProduct(product3);
        shop.addProduct(product4);

        Scanner scanner = new Scanner(System.in);

        System.out.print("please enter the username: " );
        String username = scanner.nextLine();
        System.out.print("please enter the password: " );
        String password = scanner.nextLine();
        System.out.print("please enter the lastName: " );
        String lastName = scanner.nextLine();
        System.out.print("please enter the firstName: " );
        String firstName = scanner.nextLine();
        System.out.print("please enter the phoneNumber: " );
        String phoneNumber = scanner.nextLine();
        System.out.print("please enter the email: " );
        String email = scanner.nextLine();
        System.out.print("please enter the province: " );
        String province = scanner.nextLine();
        System.out.print("please enter the city: " );
        String city = scanner.nextLine();
        System.out.print("please enter the street: " );
        String street = scanner.nextLine();
        System.out.print("please enter the postalCode: " );
        String postalCode = scanner.nextLine();
        Address address = new Address(province,city,street,postalCode);
        User user = new User(username,password,lastName,firstName,phoneNumber,email,address);
        shop.saveUser(user);
        showMenu();
        boolean state=true;
        while(state) {
            switch (scanner.nextInt()) {
                case 1:
                    System.out.println("**********************");
                    shop.showProduct();
                    System.out.println("**********************");
                    System.out.print("please enter the index product: ");
                    int productIndex = scanner.nextInt();
                    System.out.print("please enter the count product: ");
                    int count = scanner.nextInt();
                    shop.addProduct(user, count, productIndex);
                    break;
                case 2:
                    System.out.println("*******************");
                    shop.showShoppingCart(user);
                    System.out.println("*******************");
                    System.out.print("please enter the index product: ");
                    int shoppingCartIndex = scanner.nextInt();
                    shop.deleted(shoppingCartIndex);
                    break;
                case 3:
                    System.out.println("*******************");
                    shop.showProduct();
                    System.out.println("*******************");
                    break;
                case 4:
                    shop.showShoppingCart(user);
                    break;
                case 5:
                    shop.confirm(user);
                    break;
                case 6:
                    state =false;
                    break;
                default:
                    System.out.println("wrong number!");
                    break;
            }
        }
    }

    private static void showMenu() {
        System.out.println("1.add product");
        System.out.println("2.remove product");
        System.out.println("3.show product");
        System.out.println("4.show shopping cart");
        System.out.println("5.confirm");
        System.out.println("6.exit");
    }
}
