import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        User user=new User();
        System.out.print("enter th user name: ");
        user.setUsername(scanner.nextLine());
        System.out.print("enter the password: ");
        user.setPassword(scanner.nextLine());
        System.out.print("enter the first name: ");
        user.setFirstName(scanner.nextLine());
        System.out.print("enter the last name: ");
        user.setLastName(scanner.nextLine());
        System.out.print("enter the phone number: ");
        user.setPhoneNumber(scanner.nextLine());
        System.out.print("enter the email address: ");
        user.setEmail(scanner.nextLine());

        Address address=new Address();
        System.out.print("enter the state: ");
        address.setState(scanner.nextLine());
        System.out.print("enter the city: ");
        address.setCity(scanner.nextLine());
        System.out.print("enter the street name: ");
        address.setStreetName(scanner.nextLine());
        System.out.print("enter the code post: ");
        address.setCodePost(scanner.nextLine());

        user.setAddress(address);

        Product product=new Product("jha",123,112,CategoryType.ELECTRONICS);
        Product product1=new Product("adfgg",123,112,CategoryType.READABLE);
        Product product2=new Product("afdsd",123,112,CategoryType.SHOE);
        Product product3=new Product("aasda",123,112,CategoryType.SHOE);

        Product[] products=new Product[]{product,product1,product2,product3};

        ShoppingCard shoppingCard = new ShoppingCard(user);

        showProduct(products);
        System.out.println("please enter the number: ");
        while(true) {
            switch (scanner.nextInt()) {
                case 0:
                    System.out.print("please enter count: ");
                    int count = scanner.nextInt();
                    ProductSel productSel = new ProductSel(count, count * products[0].getPrice(), products[0]);
                    shoppingCard.add(productSel);
                    shoppingCard.showProduct();
                    showProduct(products);
                    break;
                case 1:
                    System.out.print("please enter count: ");
                    int count1 = scanner.nextInt();
                    ProductSel productSel1 = new ProductSel(count1, count1 * products[1].getPrice(), products[1]);
                    shoppingCard.add(productSel1);
                    shoppingCard.showProduct();
                    showProduct(products);
                    break;
                case 2:
                    System.out.print("please enter count: ");
                    int count2 = scanner.nextInt();
                    ProductSel productSel2 = new ProductSel(count2, count2 * products[2].getPrice(), products[2]);
                    shoppingCard.add(productSel2);
                    shoppingCard.showProduct();
                    showProduct(products);

                    break;
                case 3:
                    System.out.print("please enter count: ");
                    int count3 = scanner.nextInt();
                    ProductSel productSel3 = new ProductSel(count3, count3 * products[3].getPrice(), products[3]);
                    shoppingCard.add(productSel3);
                    shoppingCard.showProduct();
                    showProduct(products);
                    break;
                case 4:
                    shoppingCard.confirm();
                    shoppingCard.showProduct();
                    showProduct(products);
                    break;
                case 5:
                    System.out.println("please enter the remove id: ");
                    int remove = scanner.nextInt();
                    shoppingCard.remove(remove);
                    shoppingCard.showProduct();
                    showProduct(products);
                    break;
                default:
                    System.out.println("not valid!");
                    showProduct(products);
                    break;
            }
        }

    }

    private static void showProduct(Product[] products){
        int index=0;
        for (Product product : products) {
            System.out.println(index+": " +product.getCount()+" "+product.getPrice()+" "+product.getName()+" "+product.getCategory());
            index++;
        }
        System.out.println(index+" : confirm");
        index++;
        System.out.println(index+" : remove");
    }
}
