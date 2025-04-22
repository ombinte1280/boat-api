package com.omb.boatapi.application.port.in;

import com.omb.boatapi.domain.model.User;

public interface UserService {

    User saveUser(final User user);
    User findByUsername(final String username);
    User login(String username, String password);
}
