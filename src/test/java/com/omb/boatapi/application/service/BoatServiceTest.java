package com.omb.boatapi.application.service;

import com.omb.boatapi.application.port.out.BoatRepositoryPort;
import com.omb.boatapi.domain.exception.NotFoundException;
import com.omb.boatapi.domain.model.Boat;
import com.omb.boatapi.domain.model.Category;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BoatServiceTest {

    @InjectMocks
    private BoatServiceImpl boatService;
    @Mock
    private BoatRepositoryPort boatRepositoryPort;

    @BeforeEach
    void setUp() {
        boatService = new BoatServiceImpl(boatRepositoryPort);
    }

    @Test
    void shouldSaveBoat() {
        Boat boat = new Boat(UUID.randomUUID(), "Titanic", Category.OCEAN_LINER
                ,"The best ocean liner", "ssdf-445-ggggxc", LocalDate.now());
        Mockito.when(boatRepositoryPort.saveBoat(boat)).thenReturn(boat);

        Boat saved = boatService.saveBoat(boat);

        Assertions.assertThat(saved).isEqualTo(boat);
        Mockito.verify(boatRepositoryPort).saveBoat(boat);
    }

    @Test
    void shouldFindById() {
        UUID id = UUID.randomUUID();
        Boat boat = new Boat(id, "Bateau", Category.CATAMARAN
                ,null, "FF445YY", LocalDate.now());
        when(boatRepositoryPort.findById(id)).thenReturn(Optional.of(boat));

        Boat result = boatService.findById(id.toString());

        Assertions.assertThat(result).isEqualTo(boat);
        verify(boatRepositoryPort).findById(id);
    }

    @Test
    void shouldThrowWhenNotFoundById() {
        UUID id = UUID.randomUUID();
        when(boatRepositoryPort.findById(id)).thenReturn(Optional.empty());

        Assertions.assertThatThrownBy(() -> boatService.findById(id.toString()))
                .isInstanceOf(NotFoundException.class)
                .hasMessageContaining("Boat not found with id");
    }

    @Test
    void shouldFindAllBoats() {
        List<Boat> boats = List.of(
                new Boat(UUID.randomUUID(), "Boat 1", Category.SAILBOAT,null, "FF445YY"
                        , LocalDate.now()),
                new Boat(UUID.randomUUID(), "Boat 2", Category.YACHT,"My Yacht", "RR-345-DC"
                        , LocalDate.now())
        );
        when(boatRepositoryPort.findAllBoat()).thenReturn(boats);

        List<Boat> result = boatService.findAllBoat();

        Assertions.assertThat(result).hasSize(2).containsExactlyElementsOf(boats);
    }

    @Test
    void shouldUpdateBoat() {
        UUID id = UUID.randomUUID();
        Boat existing = new Boat(id, "Old", Category.CATAMARAN,null, "FF445YY"
                , LocalDate.now());
        when(boatRepositoryPort.findById(id)).thenReturn(Optional.of(existing));

        Boat updated = new Boat(id, "New Name", Category.YACHT,null, "FF445YY"
                , LocalDate.now());
        when(boatRepositoryPort.saveBoat(any())).thenReturn(updated);

        Boat result = boatService.updateBoat(id.toString(), "New Name", Category.YACHT, null, null);

        Assertions.assertThat(result.getName()).isEqualTo("New Name");
        Assertions.assertThat(result.getCategory()).isEqualTo(Category.YACHT);

        ArgumentCaptor<Boat> captor = ArgumentCaptor.forClass(Boat.class);
        verify(boatRepositoryPort).saveBoat(captor.capture());
        Assertions.assertThat(captor.getValue().getId()).isEqualTo(id);
    }

    @Test
    void shouldDeleteBoat() {
        UUID id = UUID.randomUUID();
        boatService.deleteBoat(id.toString());

        verify(boatRepositoryPort).delete(id);
    }
}
