package com.sda.userconsumer.dao;

import com.sda.userconsumer.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserRestDaoImpl implements UserRestDao{
    private static final String URL = "http://localhost:8080/";

    @Override
    public List<User> getAllUsers() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<User[]> forEntity = restTemplate.getForEntity(URL + "users", User[].class);
        User[] users = forEntity.getBody();
        if(users != null) {
            return Arrays.stream(users).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    @Override
    public User getUserById(int userId) {
        String url = URL + "/user/id/" + userId;
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForEntity(url, User.class).getBody();
    }

    @Override
    public User addUser(User user) {
        String url = URL + "/users";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<User> userResponseEntity = restTemplate.postForEntity(url, user, User.class);
        return userResponseEntity.getBody();
    }

    @Override
    public User removeUser(User user) {
        String url = URL + "/user/delete/" + user.getUserId();
        RestTemplate template = new RestTemplate();
        template.delete(url);
        return user;
    }

    @Override
    public User modifyUser(int userId, User user) {
        return null;
    }
}
