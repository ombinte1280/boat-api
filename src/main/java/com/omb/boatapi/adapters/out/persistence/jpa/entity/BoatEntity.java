package com.omb.boatapi.adapters.out.persistence.jpa.entity;

import com.omb.boatapi.domain.model.Category;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Entity
@Table(name = "boats")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class BoatEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
    @NotNull
    private String name;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Category category;
}
