package com.sda.userSda;

import com.sda.userSda.controller.old.UserServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan(basePackageClasses = UserServlet.class)
public class UserSdaApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserSdaApplication.class, args);
    }

}
