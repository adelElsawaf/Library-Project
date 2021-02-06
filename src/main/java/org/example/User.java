package org.example;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class User {
    public static final String FULL_FILE_LOCATION = "CsvFiles/UsersData.csv";
    public static List<User> usersInfo = new ArrayList<>();
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

    public User() {
    }

    public static List<User> getAllUsers() {
        return User.usersInfo;
    }

    public static User getUser(String userName) {
        for (User user : usersInfo) {
            if (user.userName.equals(userName))
                return user;
        }
        return null;
    }
    private static boolean isDataValid(String data) {
        return !data.equals("");
    }

    public static void Register(User recent) {
        CsvFile usersFile = new CsvFile(FULL_FILE_LOCATION);
        if (!usersFile.isExist()) {
            usersFile.create();
            usersFile.insert("First_Name,Last_Name,User_Name,Password,User_Type");
        }
        usersFile.insert(recent.firstName + "," + recent.lastName + "," + recent.userName + "," + recent.Password + "," + recent.type);
    }

    public static void loadDataFromFile() {
        List<String> Data = CsvFile.read(FULL_FILE_LOCATION);
        for (int dataIndex = 0; dataIndex < Data.size(); dataIndex += 5) {
            usersInfo.add(new User(Data.get(dataIndex), Data.get(dataIndex + 1), Data.get(dataIndex + 2), Data.get(dataIndex + 3), Data.get(dataIndex + 4)));
        }
    }

    public static User logIn(String userName, String password) {
        for (User loggedInUser : usersInfo) {
            if (loggedInUser.userName.equals(userName) && loggedInUser.Password.equals(password))
                return loggedInUser;
        }
        return null;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getPassword() {
        return this.Password;
    }

    public String getType() {
        return this.type.toString();
    }
}

