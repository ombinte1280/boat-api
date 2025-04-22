package com.omb.boatapi.application.service;

import com.omb.boatapi.application.port.in.UserService;
import com.omb.boatapi.application.port.out.UserRepositoryPort;
import com.omb.boatapi.domain.exception.NotFoundException;
import com.omb.boatapi.domain.exception.UnAuthorizedException;
import com.omb.boatapi.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepositoryPort userRepositoryPort;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User saveUser(User user) {
        return userRepositoryPort.save(user);
    }

    @Override
    public User findByUsername(String username) {
        Optional<User> optionalUser = userRepositoryPort.findByUsername(username);
        return optionalUser.orElseThrow(() -> new NotFoundException("User not found with name : " + username));
    }

    @Override
    public User login(String username, String password) {
        User user = findByUsername(username);
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new UnAuthorizedException("Utilisateur ou mot de passe incorrect");
        }
        return user;
    }
}
