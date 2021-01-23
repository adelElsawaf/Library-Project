package org.example;

import java.util.Scanner;

public class main {

    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        User.loadDataFromFile();
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
                    for (int i = 0; i < User.usersInfo.size(); i++) {
                        System.out.println("First Name is : "+User.usersInfo.get(i).firstName);
                        System.out.println("Last Name is : "+User.usersInfo.get(i).lastName);
                        System.out.println("User Name is : "+User.usersInfo.get(i).userName);
                        System.out.println("Password is "+User.usersInfo.get(i).Password);
                        System.out.println("User Type is " +User.usersInfo.get(i).type);
                    }
                    break;
                case "3":
                        System.out.println("Please enter user name");
                        String logInName = input.nextLine();
                        System.out.println("Please enter your password");
                        String logInPassword=input.nextLine();
                        if (User.logIn(logInName,logInPassword))
                        {
                            System.out.println("Login Succeed");
                        }
                        else
                        {
                            System.out.println("Login failed");
                        }
                        break;
                default:
                    break;
            }
        }
    }
}
