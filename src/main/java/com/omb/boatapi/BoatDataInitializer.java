package com.omb.boatapi;

import com.omb.boatapi.application.port.in.BoatService;
import com.omb.boatapi.application.port.in.UserService;
import com.omb.boatapi.domain.model.Boat;
import com.omb.boatapi.domain.model.Category;
import com.omb.boatapi.domain.model.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Slf4j
@Component
@RequiredArgsConstructor
public class BoatDataInitializer implements CommandLineRunner {

    private final UserService userService;
    private final BoatService boatService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {

        Set<String> users = Set.of("admin", "user1", "user2");
        users.forEach(user -> {
            User admin = new User(null, user, user.toUpperCase(), user, passwordEncoder.encode(user));
            userService.saveUser(admin);
            log.info("Utilisateur {} ajouté !", user);
        });

        List<Boat> boats = List.of(new Boat(null, "My Catamaran", Category.CATAMARAN
                        , "Mon catamaran  de course", "FF998XX", LocalDate.now())
                , new Boat(null, "Le Renard", Category.SAILBOAT
                        ,"Mon voilier 1", "FF445YY", LocalDate.now())
                , new Boat(null, "La Recouvrance", Category.SAILBOAT
                ,"Mon voilier 2", "SS345YY", LocalDate.now())
                , new Boat(null, "Tara", Category.SAILBOAT
                        ,"Mon sur le lac de Geneve", "ddd-445-ffl", LocalDate.now())
                , new Boat(null, "Pen Duick", Category.SAILBOAT
                        ,null, "FF445YY", LocalDate.now())
                , new Boat(null, "Titanic", Category.OCEAN_LINER
                        ,null, "ddd-xx-6567fff", LocalDate.now())
                , new Boat(null, "Le Saint Tropez", Category.YACHT
                        ,null, "EE-980-CC", LocalDate.now())
        );

        boats.forEach(boatService::saveBoat);
    }
}
