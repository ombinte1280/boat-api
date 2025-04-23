package com.omb.boatapi.adapters.in.rest.dto;

import com.omb.boatapi.domain.model.Category;
import com.omb.boatapi.validation.AtLeastOneNotNull;
import lombok.Data;

@Data
@AtLeastOneNotNull
public class PatchBoatRequest {

    private String name;
    private Category category;
    private String registration;
    private String description;
}
