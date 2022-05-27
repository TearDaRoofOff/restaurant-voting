package com.example.voting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class VotingApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(VotingApplication.class, args);
    }

}
