package com.omb.boatapi.adapters.in.rest.controller;

import com.omb.boatapi.adapters.in.rest.dto.LoginRequest;
import com.omb.boatapi.adapters.in.rest.dto.LoginResponse;
import com.omb.boatapi.adapters.in.rest.mapper.UserResponseMapper;
import com.omb.boatapi.application.port.in.JwtService;
import com.omb.boatapi.application.port.in.UserService;
import com.omb.boatapi.domain.model.User;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final JwtService jwtService;
    private final UserResponseMapper mapper;


    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest request) {
        User user = userService.login(request.getUsername(), request.getPassword());
        LoginResponse response = mapper.toResponse(user);
        String token = jwtService.generateToken(user.getUsername());
        response.setToken(token);
        return ResponseEntity.ok(response);
    }
}
