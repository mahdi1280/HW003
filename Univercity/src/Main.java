import object.*;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static University university = new University();
    private static User user;
    private static User student;
    private static User teacher;

    public static void main(String[] args) {

         user = new User("admin", "admin", "admin", "admin", Role.ADMIN);
         student = new User("student", "student", "student", "student", Role.STUDENT);
         teacher = new User("teacher", "teacher", "teacher", "teacher", Role.TEACHER);

        university.save(user);
        university.save(student);
        university.save(teacher);

        boolean sate = true;
        System.out.println("*********** Login Page ***********");
        while (sate) {
            System.out.print("Please Enter the UserName: ");
            String userName = scanner.nextLine();
            System.out.print("Please Enter the password: ");
            String password = scanner.nextLine();
            user = university.login(userName, password);
            if (user == null) {
                System.out.println("not Valid");
            } else {
                sate = false;
            }
        }
        System.out.println("**************************************");
        System.out.println("Welcome " + user.getUserName());
        System.out.println("**************************************");
        if (user.getRole().equals(Role.ADMIN)) {
            admin();
        } else if (user.getRole().equals(Role.TEACHER)) {
            teacher();
        } else {
            student();
        }

    }

    public static void admin() {
        showMenuAdmin();
        String password, lastName, firstName;
        String userName;
        User user;
        int id;
        boolean deleted;
        boolean state = true;
        while (state) {
            switch (getNumber()) {
                case 1:
                    scanner.nextLine();
                    System.out.print("Please Enter the lastName: ");
                    lastName = scanner.nextLine();
                    System.out.print("Please Enter the firstName: ");
                    firstName = scanner.nextLine();
                    System.out.print("Please Enter the user name: ");
                    userName = scanner.nextLine();
                    System.out.print("Please Enter the password: ");
                    password = scanner.nextLine();
                    user = new User(firstName, lastName, userName, password, Role.STUDENT);
                    university.save(user);
                    System.out.println("save successful");
                    break;
                case 2:
                    scanner.nextLine();
                    System.out.print("Please Enter the lastName: ");
                    lastName = scanner.nextLine();
                    System.out.print("Please Enter the firstName: ");
                    firstName = scanner.nextLine();
                    System.out.print("Please Enter the user name: ");
                    userName = scanner.nextLine();
                    System.out.print("Please Enter the password: ");
                    password = scanner.nextLine();
                    user = new User(firstName, lastName, userName, password, Role.TEACHER);
                    university.save(user);
                    System.out.println("save successful");
                    break;
                case 3:
                    scanner.nextLine();
                    System.out.print("Please Enter the lastName: ");
                    lastName = scanner.nextLine();
                    System.out.print("Please Enter the firstName: ");
                    firstName = scanner.nextLine();
                    System.out.print("Please Enter the user name: ");
                    userName = scanner.nextLine();
                    System.out.print("Please Enter the password: ");
                    password = scanner.nextLine();
                    user = new User(firstName, lastName, userName, password, Role.ADMIN);
                    university.save(user);
                    System.out.println("save successful");
                    break;
                case 4:
                    showUser(Role.STUDENT);
                    System.out.print("please enter id number: ");
                    id = getNumber();
                    deleted = university.userDelete(id);
                    if (deleted) {
                        System.out.println("delete successful");
                    } else {
                        System.out.println("id id not valid");
                    }
                    break;
                case 5:
                    showUser(Role.TEACHER);
                    System.out.print("please enter id number: ");
                    id = getNumber();
                    deleted = university.userDelete(id);
                    if (deleted) {
                        System.out.println("delete successful");
                    } else {
                        System.out.println("id id not valid");
                    }
                    break;
                case 6:
                    showUser(Role.ADMIN);
                    System.out.print("please enter id number: ");
                    id = getNumber();
                    deleted = university.userDelete(id);
                    if (deleted) {
                        System.out.println("delete successful");
                    } else {
                        System.out.println("id id not valid");
                    }
                    break;
                case 7:
                    showUser(Role.STUDENT);
                    scanner.nextLine();
                    System.out.print("Please Enter the lastName: ");
                    lastName = scanner.nextLine();
                    System.out.print("Please Enter the firstName: ");
                    firstName = scanner.nextLine();
                    System.out.print("please enter id number: ");
                    id = getNumber();
                    if (university.updateUser(id, firstName, lastName)) {
                        System.out.println("updated successful");
                    } else {
                        System.out.println("id not valid");
                    }
                    break;
                case 8:
                    showUser(Role.TEACHER);
                    scanner.nextLine();
                    System.out.print("Please Enter the lastName: ");
                    lastName = scanner.nextLine();
                    System.out.print("Please Enter the firstName: ");
                    firstName = scanner.nextLine();
                    System.out.print("please enter id number: ");
                    id = getNumber();
                    if (university.updateUser(id, firstName, lastName)) {
                        System.out.println("updated successful");
                    } else {
                        System.out.println("id not valid");
                    }
                    break;
                case 9:
                    showUser(Role.ADMIN);
                    scanner.nextLine();
                    System.out.print("Please Enter the lastName: ");
                    lastName = scanner.nextLine();
                    System.out.print("Please Enter the firstName: ");
                    firstName = scanner.nextLine();
                    System.out.print("please enter id number: ");
                    id = getNumber();
                    if (university.updateUser(id, firstName, lastName)) {
                        System.out.println("updated successful");
                    } else {
                        System.out.println("id not valid");
                    }
                    break;
                case 10:
                    scanner.nextLine();
                    System.out.print("please enter name course: ");
                    String name = scanner.nextLine();
                    System.out.print("please enter name ooz: ");
                    int ooz = getNumber();
                    university.saveCourse(name, ooz);
                    break;
                case 11:
                    List<Course> courses = university.getCourses();
                    System.out.println("------------------------");
                    for (Course course : courses) {
                        System.out.println(course.toString());
                    }
                    System.out.println("-------------------------");
                    System.out.println("please enter id: ");
                    id = getNumber();
                    if (university.deleteCourse(id))
                        System.out.println("deleted.");
                    else
                        System.out.println("wrong");
                    break;
                case 12:

                    break;
                case 13:
                    System.out.println("ADMIN USER");
                    showUser(Role.ADMIN);
                    System.out.println("TEACHER USER");
                    showUser(Role.TEACHER);
                    System.out.println("STUDENT USER");
                    showUser(Role.STUDENT);
                    break;
                case 14:
                    state = false;
                    break;
                default:
                    System.out.println("Wrong!");
                    break;
            }
        }
    }

    private static int getNumber() {
        while (true){
            try {
               int number= scanner.nextInt();
               return number;
            }catch (Exception e){
                scanner.nextLine();
                System.out.println(e.getMessage());
            }
        }
    }


    public static void student() {
        showMenuStudent();
        boolean state = true;
        while (state) {
            switch (getNumber()) {
                case 1:
                    System.out.println(student.toString());
                    break;
                case 2:
                    university.getCourses().forEach(System.out::println);
                    break;
                case 3:
                    university.getCourses().forEach(System.out::println);

                    System.out.print("please enter one index: ");
                    int index=getNumber();
                    System.out.print("please enter the year: ");
                    int year = getNumber();
                    System.out.println("please enter the term: ");
                    int term=getNumber();
                    Term term1=new Term(term,year,student);
                    TermCourse termCourse=new TermCourse(student,term1,university.getCoursesById(index));
                    university.addTermCourse(termCourse);
                    break;
                case 4:
                    university.showTermCourse(student);
                    break;
                case 5:
                    state = false;
                    break;
            }
        }
    }

    public static void teacher() {
        showTeacherMenu();
        boolean state =false;
        while(state){
            switch (getNumber()){
                case 1:
                    System.out.println(teacher.toString());
                    break;
                case 2:
                    System.out.println(student.toString());
                    System.out.println("please enter id: ");
                    int id=getNumber();
                    System.out.println("please enter score: ");
                    int score=getNumber();
                    university.addNomre(score,id);
                    break;
                case 3:
                    university.shwFactor(teacher);
                    break;
                case 4:
                    state = false;
                    break;
                default:
                    System.out.println("wrong!");
                    break;
            }
        }
    }

    public static void showTeacherMenu(){
        System.out.println("1.show profile");
        System.out.println("2.save nomre");
        System.out.println("3.show factor");
        System.out.println("4.exit");
    }

    public static void showMenuStudent() {
        System.out.println("1.show profile");
        System.out.println("2.show course");
        System.out.println("3.select course");
        System.out.println("4.show my course");
        System.out.println("5.exit");
    }

    public static void showMenuAdmin() {
        System.out.println("1.register student");
        System.out.println("2.register teacher");
        System.out.println("3.register admin");
        System.out.println("4.delete student");
        System.out.println("5.delete teacher");
        System.out.println("6.delete admin");
        System.out.println("7.edit student");
        System.out.println("8.edit teacher");
        System.out.println("9.edit admin");
        System.out.println("10.save course");
        System.out.println("11.delete course");
//        System.out.println("12.show factor teacher");
        System.out.println("13.show all user");
        System.out.println("14.exit");
    }

    private static void showUser(Role role) {
        System.out.println("-------------------");
        for (User userStudent : university.getUserByRole(role)) {
            System.out.println(userStudent.toString());
        }
        System.out.println("-------------------");
    }
}
