package com.omb.boatapi.application.port.in;

import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {

    String generateToken(String username);
    String extractUsername(String token);
    boolean isValid(String token, UserDetails userDetails);
}
