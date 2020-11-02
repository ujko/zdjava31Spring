package com.sda.userSda;

import com.sda.userSda.model.User;
import org.assertj.core.util.Strings;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDate;
import java.time.Period;
import java.util.Map;
import java.util.Set;

public class TestStream {

    @Test
    void test() {
        Set<Integer> set = Set.of(32,33,12,67,3);
        int res = set
                .stream()
                .mapToInt(a -> a)
                .max().orElse(0) + 1;
        System.out.println(res);
    }


    @Test
    void test1() {
        doMethod("text");
    }

    private void doMethod(String text) {
        if(text != null) {
            return;
        }
        if(text.length() < 2) {
            return;
        }
            System.out.println(text);
    }


    @Test
    void test2() {
        LocalDate date = LocalDate.of(1972, 04, 03);
        Period between = Period.between(date, LocalDate.now());
        System.out.println(between.getYears());
    }

    @Test
    void test3() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.encode("pawel"));
        System.out.println(encoder.encode("kasia"));
    }
}
