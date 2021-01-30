package org.example;

import java.util.Scanner;

import static org.example.User.*;

public class main {

    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        loadDataFromFile();
        while (true) {
            String operation;
            System.out.println("To Register Please Press <1>");
            System.out.println("To Display all users Please Press <2>");
            System.out.println("To Login Please press <3>");
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
                    Register(new User(firstName, lastName, userName, password, userType));
                    break;
                case "2":
                    for (User user : usersInfo) {
                        System.out.println(user.getFirstName());
                        System.out.println(user.getLastName());
                        System.out.println(user.getUserName());
                        System.out.println(user.getPassword());
                        System.out.println(user.getType());

                    }
                    break;
                case "3":
                    System.out.println("Please enter user name");
                    String logInName = input.nextLine();
                    System.out.println("Please enter your password");
                    String logInPassword = input.nextLine();
                    if (logIn(logInName, logInPassword)) {
                        System.out.println("Login Succeed");
                    } else {
                        System.out.println("Login failed");
                    }
                    break;
                default:
                    break;
            }
        }
    }
}
