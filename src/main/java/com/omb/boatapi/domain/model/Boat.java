package com.omb.boatapi.domain.model;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Boat {

    @NotNull
    private UUID id;
    @NotNull
    private String name;
    @NotNull
    private Category category;
}
