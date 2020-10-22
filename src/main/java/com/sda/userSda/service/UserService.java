package com.sda.userSda.service;

import com.sda.userSda.model.User;

import java.util.List;

public interface UserService {
    List<User> getAll();
    User getById(int userId);
    void removeUser(User user);
    void modifyUser(int userId, User user);
    User addUser(User user);
    List<User> getByFirstName(String firstName);
    List<User> getByLastName(String lastName);

}
