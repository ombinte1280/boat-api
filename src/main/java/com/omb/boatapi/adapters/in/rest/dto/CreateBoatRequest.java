package com.omb.boatapi.adapters.in.rest.dto;

import com.omb.boatapi.domain.model.Category;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CreateBoatRequest {

    @NotNull
    private String name;
    @NotNull
    private Category category;
    @NotNull
    private String description;
    @NotNull
    private String registration;
}
