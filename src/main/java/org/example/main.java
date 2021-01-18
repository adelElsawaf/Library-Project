package org.example;

import java.util.Scanner;

public class main {

    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            String operation;
            System.out.println("To Register Please Press <1>");
            System.out.println("To Display all users Please Press <2>");
            operation = input.nextLine();
            switch (operation) {
                case "1":
                    System.out.println("Please enter first name ");
                    String firstName = input.nextLine();
                    System.out.println("Please enter second name ");
                    String lastName = input.nextLine();
                    System.out.println("Please enter user name ");
                    String userName = input.nextLine();
                    System.out.println("Please enter Password ");
                    String password = input.nextLine();
                    System.out.println("Please enter the type of the user ");
                    String userType = input.nextLine();
                    User.Register(firstName, lastName, userName, password, userType);
                    break;
                case "2":
                    User.loadDataFromFile().forEach(System.out::println);
                default:
                    break;
            }
        }
    }
}
