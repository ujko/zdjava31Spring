package com.sda.userconsumer;

import com.sda.userconsumer.dao.UserRestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Starter implements CommandLineRunner {
    UserRestDao userRestDao;

    @Override
    public void run(String... args) throws Exception {
//        userRestDao.getAllUsers().forEach(System.out::println);
    }

    @Autowired
    public void setUserRestDao(UserRestDao userRestDao) {
        this.userRestDao = userRestDao;
    }
}
