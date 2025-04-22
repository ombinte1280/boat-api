package com.omb.boatapi;

import com.omb.boatapi.application.port.in.UserService;
import com.omb.boatapi.domain.model.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Set;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserDataInitializer implements CommandLineRunner {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {

        Set<String> users = Set.of("admin", "user1", "user2");
        users.forEach(user -> {
            User admin = new User(null, user, user.toUpperCase(), user, passwordEncoder.encode(user));
            userService.saveUser(admin);
            log.info("Utilisateur {} ajouté !", user);
        });
    }
}
