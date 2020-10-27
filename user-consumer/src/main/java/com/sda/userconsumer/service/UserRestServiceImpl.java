package com.sda.userconsumer.service;

import com.sda.userconsumer.dao.UserRestDao;
import com.sda.userconsumer.model.User;

import java.util.List;

public class UserRestServiceImpl implements UserRestService {
    private UserRestDao userRestDao;

    public UserRestServiceImpl(UserRestDao userRestDao) {
        this.userRestDao = userRestDao;
    }

    @Override
    public List<User> getAllUsers() {
        return userRestDao.getAllUsers();
    }

    @Override
    public User getUserById(int userId) {
        return userRestDao.getUserById(userId);
    }

    @Override
    public User addUser(User user) {
        return userRestDao.addUser(user);
    }

    @Override
    public User removeUser(User user) {
        return userRestDao.removeUser(user);
    }

    @Override
    public User modifyUser(int userId, User user) {
        return null;
    }
}
