package com.sda.userSda.dao;

import com.sda.userSda.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();
    User getUserById(int userId);
    User addUser(User user);
    void removeUser(User user);
    void modifyUser(int userId, User user);
}
