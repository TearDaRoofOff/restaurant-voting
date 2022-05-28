package com.example.voting;

import com.example.voting.model.Role;
import com.example.voting.model.User;
import com.example.voting.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.util.Set;

@SpringBootApplication
@AllArgsConstructor
public class VotingApplication implements ApplicationRunner {
    private final UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(VotingApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        userRepository.save(new User("rus@ngs.ru",
                "Ruslan",
                "Kolesnikov",
                "sa",
                Set.of(Role.ROLE_ADMIN, Role.ROLE_USER)));
        userRepository.save(new User("kol@ngs.ru",
                "Denis",
                "Kolesnikov",
                "sa",
                Set.of(Role.ROLE_USER)));
        System.out.println(userRepository.findAll());
    }
}
