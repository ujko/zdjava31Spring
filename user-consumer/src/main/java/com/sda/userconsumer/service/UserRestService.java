package com.sda.userconsumer.service;

import com.sda.userconsumer.model.User;

import java.util.List;

public interface UserRestService {
    List<User> getAllUsers();
    User getUserById(int userId);
    User addUser(User user);
    User removeUser(User user);
    User modifyUser(int userId, User user);
}
