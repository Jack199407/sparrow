package com.algonquin.bundle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.algonquin"})
public class BundleApplication {

    public static void main(String[] args) {
        SpringApplication.run(BundleApplication.class, args);
    }

}
