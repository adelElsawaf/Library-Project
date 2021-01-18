package org.example;

import java.util.ArrayList;
import java.util.List;

public class User {
    public static final String FULL_FILE_LOCATION = "CsvFiles/UsersData.csv";
    private String firstName;
    private String lastName;
    private String userName;
    private String Password;
    private UserType type;

    public User(String firstName, String lastName, String userName, String Password, String type) {
        if (isDataValid(firstName) && isDataValid(lastName) && isDataValid(userName) && isDataValid(Password)) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.userName = userName;
            this.Password = Password;
            this.type = UserType.valueOf(type.toUpperCase());

        } else
            throw new Error("Can't insert null or Empty Data");
    }


    public static boolean isDataValid(String data) {
        return !data.equals("");
    }

    public static void Register(String firstName, String lastName, String userName, String Password, String
            type) {
        User recent = new User(firstName, lastName, userName, Password, type);
        CsvFile usersFile = new CsvFile(FULL_FILE_LOCATION);
        List<String> rowsData = new ArrayList<>();
        if (!usersFile.isExist()) {
            usersFile.create();
            rowsData.add("First_Name,Last_Name,User_Name,Password,User_Type");
        }
        rowsData.add(recent.firstName + "," + recent.lastName + "," + recent.userName + "," + recent.Password + "," + recent.type);
        usersFile.insert(rowsData);

    }

    public static List<String> loadDataFromFile() {
        return CsvFile.read(FULL_FILE_LOCATION);
    }
}
