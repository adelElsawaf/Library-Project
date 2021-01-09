package org.example;

import java.util.List;

public class User {
    private String firstName;
    private String lastName;
    private String userName;
    private String Password;
    private UserType type;
    private static final String FULL_FILE_LOCATION = "D:\\Programming\\Final Library Project\\CsvFiles\\UsersData.csv";
    static User recent;

    public static boolean isDataValid(String data) {
        if (data != "" && data != null) {
            return true;
        } else {
            return false;
        }
    }

    public User(String firstName, String lastName, String userName, String Password, String type) {
        /*setFirstName(firstName);
        setLastName(lastName);
        setUserName(userName);
        setPassword(Password);
        setType(type);*/
        if (isDataValid(firstName))
            this.firstName = firstName;
        else {
            System.out.print("Invalid first name");
            throw new Error("Can't insert null");
        }
        if (isDataValid(lastName))
            this.lastName = lastName;
        else {
            System.out.print("Invalid first name");
            throw new Error("Can't insert null");
        }
        if (isDataValid(userName))
            this.userName = userName;
        else {
            System.out.print("Invalid first name");
            throw new Error("Can't insert null");
        }
        if (isDataValid(Password))
            this.Password = Password;
        else {
            System.out.print("Invalid first name");
            throw new Error("Can't insert null");
        }
        this.type = UserType.valueOf(type.toUpperCase());

    }

    /*public void setFirstName(String firstName) {
        if (firstName != "" && firstName != null) {
            this.firstName = firstName;
        } else {
            System.out.print("Invalid first name");
            throw new Error("Can't insert null");
        }
    }

    public void setLastName(String lastName) {
        if (lastName != "" && lastName != null) {
            this.lastName = lastName;
        } else {
            System.out.print("Invalid last name");
            throw new Error("Can't insert null");
        }
    }

    public void setUserName(String userName) {
        if (userName != "" && userName != null) {
            this.userName = userName;
        } else {
            System.out.print("Invalid user name");
            throw new Error("Can't insert null");
        }
    }

    public void setPassword(String Password) {
        if (Password != "" && Password != null) {
            this.Password = Password;
        } else {
            System.out.print("Invalid Password");
            throw new Error("Can't insert null");
        }
    }

    public void setType(String type) {
        this.type = UserType.valueOf(type.toUpperCase());
    }*/
    public static String getFirstName() {
        return recent.firstName;
    }

    public static String getLastName() {
        return recent.lastName;
    }

    public static String getUserName() {
        return recent.userName;
    }

    public static String getPassword() {
        return recent.Password;
    }

    public static UserType getType() {
        return recent.type;
    }

    public static String getFullFileLocation() {
        return recent.FULL_FILE_LOCATION;
    }

    public static void Register(String firstName, String lastName, String userName, String Password, String type) {
        recent = new User(firstName, lastName, userName, Password, type);
        CsvFile usersFile = new CsvFile(FULL_FILE_LOCATION);
        if (usersFile.isExist()) {
            String[] rowsData = new String[1];
            rowsData[0] = recent.firstName + "," + recent.lastName + "," + recent.userName + "," + recent.Password + "," + recent.type;
            usersFile.insert(rowsData);
        } else {
            usersFile.create();
            String[] rowsData = new String[2];
            rowsData[0] = "First_Name,Last_Name,User_Name,Password,User_Type";
            rowsData[1] = recent.firstName + "," + recent.lastName + "," + recent.userName + "," + recent.Password + "," + recent.type;
            usersFile.insert(rowsData);
        }
    }

    public static void Display() {
        List<String> usersData = CsvFile.read(FULL_FILE_LOCATION);
        for (int i = 0; i < usersData.size(); i++) {
            System.out.println(usersData.get(i));
        }
    }
}
