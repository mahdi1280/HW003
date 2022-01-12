import java.util.Scanner;

public class TestMain {

    public static void main(String[] args) {

        Product product = new Product(1, "pofak", 100, 10000);
        Product product1 = new Product(2, "noshabe", 100, 11000);
        Product product2 = new Product(3, "noon", 100, 1000);
        Shop shop = new Shop();
        shop.createProduct(product);
        shop.createProduct(product1);
        shop.createProduct(product2);
        Scanner scanner = new Scanner(System.in);
        User user;
        int indexUser = 0;
        int productindex = 4;
        boolean flag = true;
        while (flag) {
            showMenu();
            System.out.print("enter the number: ");
            switch (scanner.nextInt()) {
                case 1:
                    shop.showProduct();
                    System.out.print("enter the user Id: ");
                    int userId = scanner.nextInt();
                    System.out.print("enter the product Id: ");
                    int productId = scanner.nextInt();
                    System.out.print("enter the count: ");
                    int count = scanner.nextInt();
                    shop.buyProduct(userId, productId, count);
                    shop.showShoppingCard();
                    break;
                case 2:
                    scanner.nextLine();
                    System.out.print("Enter your firstName: ");
                    String firstname = scanner.nextLine();
                    System.out.print("Enter your lastname: ");
                    String lastname = scanner.nextLine();
                    user = new User(indexUser++, firstname, lastname);
                    shop.createUser(user);
                    break;
                case 3:
                    flag = false;
                    break;
                case 4:
                    scanner.nextLine();
                    System.out.print("Enter your product name: ");
                    String productName = scanner.nextLine();
                    System.out.print("Enter your count: ");
                    int count1 = scanner.nextInt();
                    System.out.print("Enter your price: ");
                    int price = scanner.nextInt();
                    Product p = new Product(productindex++, productName, count1, price);
                    shop.createProduct(p);
                    shop.showProduct();
                    break;

            }

        }

    }

    public static void showMenu() {
        System.out.println("1: buy product");
        System.out.println("2: register user");
        System.out.println("3: exit");
        System.out.println("4: create product");
    }
}
