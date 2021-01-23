package org.example;

import java.util.ArrayList;
import java.util.List;

public class User {
    public static final String FULL_FILE_LOCATION = "CsvFiles/UsersData.csv";
    public static List<User> usersInfo = new ArrayList<>();
    public String firstName;
    public String lastName;
    public String userName;
    public String Password;
    public UserType type;

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

    static void loadDataFromFile() {
        List<String> Data = CsvFile.read(User.FULL_FILE_LOCATION);
        for (int dataIndex = 0; dataIndex < Data.size(); dataIndex += 5) {
            User temp = new User(Data.get(dataIndex),Data.get(dataIndex+1),Data.get(dataIndex+2),Data.get(dataIndex+3),Data.get(dataIndex+4));
            usersInfo.add(temp);
        }
    }
    static boolean logIn(String userName , String password)
    {
        for (User user : usersInfo) {
            if (user.userName.equals(userName) && user.Password.equals(password))
                return true;
        }
        return false;
    }
}

