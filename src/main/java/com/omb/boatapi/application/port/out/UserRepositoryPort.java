package com.omb.boatapi.application.port.out;

import com.omb.boatapi.domain.model.User;

import java.util.Optional;

public interface UserRepositoryPort {
    User save(User user);
    Optional<User> findByUsername(String username);
}
