package com.sda.userSda;

import com.sda.userSda.model.User;
import org.junit.jupiter.api.Test;

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

}
