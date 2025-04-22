package com.omb.boatapi.adapters.in.rest.dto;

import com.omb.boatapi.domain.model.Category;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateBoatRequest {

    @NotNull
    private String name;
    @NotNull
    private Category category;
}
