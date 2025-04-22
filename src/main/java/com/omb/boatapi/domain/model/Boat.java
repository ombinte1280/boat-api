package com.omb.boatapi.domain.model;

import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Boat {

    private UUID id;
    private String name;
    private Category category;
}
