package com.algonquin.domain;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Locale;

@SpringBootTest
class SparrowDomainApplicationTests {

    @Test
    void contextLoads() {
        Locale aDefault = Locale.getDefault();
        System.out.println(aDefault);
    }

}
