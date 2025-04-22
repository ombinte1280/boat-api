package com.omb.boatapi.adapters.in.rest.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.UUID;

@Data
public class LoginResponse {

    @NotNull
    private UUID id;
    @NotNull
    private String firstname;
    @NotNull
    private String lastname;
    @NotNull
    private String token;
}
