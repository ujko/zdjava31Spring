package com.sda.userSda.controller;

import com.sda.userSda.model.User;
import com.sda.userSda.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> hello() {
        System.out.println("Pobieram wszystkich użytkowników");
        return userService.getAll();
    }

    @GetMapping("/user/id/{id}")
    public User getUser(@PathVariable int id) {
        System.out.println("Pobieram użytkownika o id " + id);
        return userService.getById(id);
    }

    @GetMapping("/user/firstName")
    public List<User> getByFirstName(@RequestParam String firstName) {
        System.out.println("Pobieram użytkownika o imieniu " + firstName);
        return userService.getByFirstName(firstName);
    }

    @GetMapping("/user/lastName")
    public List<User> getByLastName(@RequestParam String lastName) {
        System.out.println("Pobieram użytkownika o nazwisku " + lastName);
        return userService.getByLastName(lastName);
    }

    @DeleteMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable int id) {
        User user = userService.getById(id);
        System.out.println("Kasuję użytkownika  " + user);
        userService.removeUser(user);
        return "Skasowano użytkownika " + user.toString();
    }

    @PostMapping("/users")
    public String addUser(@RequestBody User user) {
        System.out.println("Dodaję użytkownika " + user);
        User newUser = userService.addUser(user);
        return "Dodano użytkownika " + newUser;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
