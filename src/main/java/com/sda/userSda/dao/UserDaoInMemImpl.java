package com.sda.userSda.dao;

import com.sda.userSda.model.User;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Profile("test")
public class UserDaoInMemImpl implements UserDao {
    private Map<Integer, User> userMap;

    public UserDaoInMemImpl() {
        userMap = new HashMap<>();
        createUsers();
    }

    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>(userMap.values());
    }

    @Override
    public User getUserById(int userId) {
        return userMap.get(userId);
    }

    @Override
    public User addUser(User user) {
        int userId = userMap.keySet().stream().mapToInt(x -> x).max().orElse(0) + 1;
        user.setUserId(userId);
        userMap.put(user.getUserId(), user);
        return user;
    }

    @Override
    public void removeUser(User user) {
        userMap.remove(user.getUserId());
    }

    @Override
    public void modifyUser(int userId, User user) {
        user.setUserId(userId);
        userMap.put(userId, user);
    }

    private void createUsers() {
        User u1 = new User();
        u1.setFirstName("Pawel");
        u1.setLastName("Nowak");
        u1.setBirthDate(LocalDate.of(1999, 05, 05));

        User u2 = new User();
        u2.setFirstName("Anna");
        u2.setLastName("Kowalska");
        u2.setBirthDate(LocalDate.of(2002, 02, 01));

        User u3 = new User();
        u3.setFirstName("Kasia");
        u3.setLastName("Andrzejewska");
        u3.setBirthDate(LocalDate.of(1975, 04, 15));

        User u4 = new User();
        u4.setFirstName("Karolina");
        u4.setLastName("Lesczynska");
        u4.setBirthDate(LocalDate.of(1993, 01, 23));

        User u5 = new User();
        u5.setFirstName("Anna");
        u5.setLastName("Nowak");
        u5.setBirthDate(LocalDate.of(1998, 12, 24));

        addUser(u1);
        addUser(u2);
        addUser(u3);
        addUser(u4);
        addUser(u5);
    }
}
