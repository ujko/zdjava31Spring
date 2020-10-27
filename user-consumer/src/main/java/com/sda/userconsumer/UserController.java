package com.sda.userconsumer;

import com.sda.userconsumer.model.User;
import com.sda.userconsumer.service.UserRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class UserController {
    private UserRestService userRestService;

    @GetMapping("/wszyscy")
    public List<User> getAllUsers() {
        List<User> allUsers = userRestService.getAllUsers();
        allUsers.forEach(System.out::println);
        return allUsers;
    }

    @GetMapping("/uzytkownik")
    public User getUserById(@RequestParam int id) {
        User userById = userRestService.getUserById(id);
        System.out.println(userById);
        return userById;
    }

    @GetMapping("/skasuj")
    public String removeUser(@RequestParam int id) {
        User user = new User();
        user.setUserId(id);
        userRestService.removeUser(user);
        return "Skasowano uzytkownika o id " + id;
    }

    @GetMapping("/dodajJole")
    public User addUser() {
        User user = new User();
        user.setFirstName("Jolanta");
        user.setLastName("Maj");
        user.setBirthDate(LocalDate.of(1923, 12, 12));
        userRestService.addUser(user);
        return user;
    }

    @Autowired
    public void setUserRestService(UserRestService userRestService) {
        this.userRestService = userRestService;
    }
}
