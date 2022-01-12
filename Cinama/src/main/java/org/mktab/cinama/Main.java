package org.mktab.cinama;

import org.mktab.cinama.model.Reserve;
import org.mktab.cinama.model.Role;
import org.mktab.cinama.model.Ticket;
import org.mktab.cinama.model.User;
import org.mktab.cinama.service.CinemaService;
import org.mktab.cinama.service.CinemaServiceImpl;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException, ParseException {
        CinemaServiceImpl cinemaService=new CinemaService();
        User user = null;
        Scanner scanner=new Scanner(System.in);
        ShowMenuLogin();
        boolean state =true;
        while (state){
            String userName,password;
            switch (scanner.nextInt()){
                case 1:
                    scanner.nextLine();
                    System.out.print("please enter user name: ");
                    userName=scanner.nextLine();
                    System.out.print("please enter password: ");
                    password=scanner.nextLine();
                    cinemaService.saveUser(userName,password, Role.CUSTOMER);
                    break;
                case 2:
                    scanner.nextLine();
                    System.out.print("please enter user name: ");
                    userName=scanner.nextLine();
                    System.out.print("please enter password: ");
                    password=scanner.nextLine();
                    user = cinemaService.login(userName,password);
                    if( user != null) {
                        if(user.getRole().equals(Role.CINEMA) && !cinemaService.findCinemaIdByUser(user).isApproved()) {
                            System.out.println("is you cinema user but yet not active approved please wait for active profile by admin user.");
                            break;
                        }
                        System.out.println("welcome ~~~");
                        state = false;
                    }
                    break;
                case 3:
                    scanner.nextLine();
                    System.out.print("please enter user name: ");
                    userName=scanner.nextLine();
                    System.out.print("please enter password: ");
                    password=scanner.nextLine();
                    System.out.print("please enter the name cinema: ");
                    String cinemaName = scanner.nextLine();
                    cinemaService.saveUser(userName,password, Role.CINEMA);
                    cinemaService.saveCinema(cinemaName, cinemaService.login(userName,password).getId());
                    break;
                case 4:
                    scanner.nextLine();
                    System.out.print("please enter user name: ");
                    userName=scanner.nextLine();
                    System.out.print("please enter password: ");
                    password=scanner.nextLine();
                    cinemaService.saveUser(userName,password,Role.ADMIN);
                    break;
                default:
                    System.out.println("Wrong Number");
                    break;
            }
        }
        state = true;
        if(user.getRole().equals(Role.CUSTOMER)){
            showMenuCustomer();

            while (state){
                switch (scanner.nextInt()){
                    case 1:
                        cinemaService.showTicket();
                        scanner.nextLine();
                        System.out.print("please enter the ticket id: ");
                        int ticketId=scanner.nextInt();
                        System.out.print("please enter the count: ");
                        int count=scanner.nextInt();
                        Reserve reserve=Reserve.builder()
                                .setCount(count)
                                .setUserId(user.getId())
                                .setTicketId(ticketId)
                                .build();
                        cinemaService.saveReserve(reserve);
                        break;
                    case 2:
                        cinemaService.showReserveByUser(user);
                        break;
                    case 3:
                        scanner.nextLine();
                        System.out.print("please entre the name: ");
                        String name=scanner.nextLine();
                        System.out.print("please enter the date: ");
                        String date=scanner.nextLine();
                        cinemaService.search(name ,Date.valueOf(date));
                        break;
                    case 4:
                        state = false;
                        break;
                    default:
                        System.out.println("wrong");
                        break;
                }
            }


        }else if(user.getRole().equals(Role.ADMIN)){
            showMenuAdmin();
            state=true;
            while (state){
                switch (scanner.nextInt()){
                    case 1:
                        cinemaService.showCinema();
                        System.out.print("please enter the cinema id: ");
                        int cinemaId=scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("please enter the approved: ");
                        boolean approved=scanner.nextBoolean();
                        cinemaService.approvedCinema(cinemaId,approved);
                        break;
                    case 2:
                        state = false;
                        break;
                    default:
                        System.out.println("wrong");
                        break;
                }
            }
        }else{
            showMenuCinema();
            state = true;
            while (state){
                int cinemaId;
                boolean approved;
                switch (scanner.nextInt()){
                    case 1:
                        scanner.nextLine();
                        System.out.print("please enter name:");
                        String name = scanner.nextLine();
                        System.out.print("please enter price:");
                        int price = scanner.nextInt();
                        System.out.print("please enter count:");
                        int count = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("please enter date:");
                        String stringDate = scanner.nextLine();
                        System.out.print("please enter approved:");
                        approved = scanner.nextBoolean();
                        cinemaId = cinemaService.findCinemaIdByUser(user).getId();
                        Ticket build = Ticket.builder()
                                .name(name)
                                .price(price)
                                .count(count)
                                .date(Date.valueOf(stringDate)) //todo 1010-10-10
                                .approved(approved)
                                .cinemaId(cinemaId)
                                .build();
                        cinemaService.saveTicket(build);
                        break;
                    case 2:
                        cinemaId = cinemaService.findCinemaIdByUser(user).getId();
                        cinemaService.showTicket(cinemaId);
                        scanner.nextLine();
                        System.out.print("please enter the approved: ");
                        approved = scanner.nextBoolean();
                        System.out.print("please enter the ticket id: ");
                        cinemaId = scanner.nextInt();
                        cinemaService.ticketApproved(cinemaId,approved);
                        break;
                    case 3:
                        cinemaService.showFactorByUser(user);
                        break;
                    case 4:
                        state = false;
                        break;
                }
            }
        }
    }

    private static void showMenuCinema() {
        System.out.println("1.create ticket");
        System.out.println("2.change approved");
        System.out.println("3.factor");
        System.out.println("4.exit");
    }

    private static void showMenuAdmin() {
        System.out.println("1.active cinema");
        System.out.println("2.exit");
    }

    private static void showMenuCustomer() {
        System.out.println("1.bye ticket");
        System.out.println("2.show bye ticket");
        System.out.println("3.search");
        System.out.println("4.exit");
    }

    private static void ShowMenuLogin() {
        System.out.println("1. register customer user");
        System.out.println("2. login");
        System.out.println("3. register cinema user");
        System.out.println("4. register admin user");
    }
}
