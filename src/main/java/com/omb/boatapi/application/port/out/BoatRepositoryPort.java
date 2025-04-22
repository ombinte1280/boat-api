package com.omb.boatapi.application.port.out;

import com.omb.boatapi.domain.model.Boat;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BoatRepositoryPort {

    List<Boat> findAllBoat();
    Optional<Boat> findById(final UUID id);
    Boat saveBoat(final Boat boat);
    void delete(final UUID id);
}
