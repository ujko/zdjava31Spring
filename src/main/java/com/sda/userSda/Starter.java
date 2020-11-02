package com.sda.userSda;

import com.sda.userSda.dao.AppUserDao;
import com.sda.userSda.dao.UserRoleDao;
import com.sda.userSda.model.AppUser;
import com.sda.userSda.model.UserRole;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Starter implements CommandLineRunner {
    UserRoleDao userRoleDao;
    AppUserDao appUserDao;

    public Starter(UserRoleDao userRoleDao, AppUserDao appUserDao) {
        this.userRoleDao = userRoleDao;
        this.appUserDao = appUserDao;
    }

    @Override
    public void run(String... args) throws Exception {
        AppUser pawel = new AppUser();
        pawel.setLogin("pawel");
        pawel.setPassword("$2a$10$cNiZDeLmd3BFmZaqtHQjr.DIxw0papmsNs9PZHWIPsf9mF2zdfw1m");
        pawel.setEnabled(true);

        AppUser kasia = new AppUser();
        kasia.setLogin("kasia");
        kasia.setPassword("$2a$10$6/qVt/EbJumHPDLTtfM6g.Z5PbzCI.TGqWnqcIMb6tp9/zds6AYq2");
        kasia.setEnabled(true);

        UserRole pawelAdmin = new UserRole();
        pawelAdmin.setLogin("pawel");
        pawelAdmin.setRole("ADMIN");

        UserRole pawelUser = new UserRole();
        pawelUser.setLogin("pawel");
        pawelUser.setRole("USER");

        UserRole kasiaUser = new UserRole();
        kasiaUser.setLogin("kasia");
        kasiaUser.setRole("USER");

        appUserDao.save(pawel);
        appUserDao.save(kasia);
        userRoleDao.save(pawelAdmin);
        userRoleDao.save(pawelUser);
        userRoleDao.save(kasiaUser);
    }
}
