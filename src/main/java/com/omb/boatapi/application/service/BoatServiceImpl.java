package com.omb.boatapi.application.service;

import com.omb.boatapi.application.port.in.BoatService;
import com.omb.boatapi.application.port.out.BoatRepositoryPort;
import com.omb.boatapi.domain.exception.NotFoundException;
import com.omb.boatapi.domain.model.Boat;
import com.omb.boatapi.domain.model.Category;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoatServiceImpl implements BoatService {

    private final BoatRepositoryPort boatRepositoryPort;

    @Override
    public Boat saveBoat(Boat boat) {
        return boatRepositoryPort.saveBoat(boat);
    }

    @Override
    public Boat findById(String id) {
        UUID uuid = UUID.fromString(id);
        Optional<Boat> optionalQabila = boatRepositoryPort.findById(uuid);
        return optionalQabila.orElseThrow(() -> new NotFoundException("Boat not found with id : " + id));
    }

    @Override
    public List<Boat> findAllBoat() {
        return boatRepositoryPort.findAllBoat();
    }

    @Override
    public Boat updateBoat(String id, String name, Category category) {
        Boat boat = findById(id);
        if(name != null) {
            boat.setName(name);
        }

        if (category != null) {
            boat.setCategory(category);
        }
        return boatRepositoryPort.saveBoat(boat);
    }

    @Override
    public void deleteBoat(String id) {
        UUID uuid = UUID.fromString(id);
        boatRepositoryPort.delete(uuid);
    }
}
