package ord.gd.maktabtestmayven;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Bank maktabBank = new Bank();
        Scanner scanner = new Scanner(System.in);
        /*
            AddCustomer milad amery nationalCode
            Deposit nationalCode 1000
            Withdraw nationalCode 2000
         */
        System.out.println("Welcome to Maktab Bank! He He:).");
        System.out.println("Available Commands:");
        System.out.println("                AddCustomer firstname lastname nationalCode");
        System.out.println("                Deposit nationalCode amount");
        System.out.println("                Withdraw nationalCode amount");

        while (true) {
            System.out.print("Please enter command:");
            String command = scanner.nextLine().trim();

            String[] commands = command.split(" ");
            if (commands[0].equals("AddCustomer")) {
                maktabBank.register(commands[1], commands[2], commands[3]);
            } else if (commands[0].equals("Deposit")) {
                maktabBank.deposit(commands[1], Long.valueOf(commands[2]));
            } else if (commands[0].equals("Withdraw")) {
                maktabBank.withdraw(commands[1], Long.valueOf(commands[2]));
            } else if (commands[0].equals("Exit")) {
                break;
            } else {
                System.out.println("Wrong command! please enter valid command!");
            }
        }
    }
}
