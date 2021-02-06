package org.example;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @RequestMapping("/users")
    public List<User> getAllUsers() {
        return User.getAllUsers();
    }

    @RequestMapping("/users/{userName}")
    public User getSpecificUser(@PathVariable String userName) {
        return User.getUser(userName);
    }
}
