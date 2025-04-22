package com.omb.boatapi.application.service;

import com.omb.boatapi.application.port.in.BoatService;
import com.omb.boatapi.application.port.out.BoatRepositoryPort;
import com.omb.boatapi.domain.model.Boat;
import com.omb.boatapi.domain.model.Category;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoatServiceImpl implements BoatService {

    private final BoatRepositoryPort boatRepositoryPort;

    @Override
    public Boat saveBoat(Boat boat) {
        return null;
    }

    @Override
    public Boat findById(String id) {
        return null;
    }

    @Override
    public List<Boat> findAllBoat() {
        return null;
    }

    @Override
    public Boat updateBoat(String id, String name, Category category) {
        return null;
    }

    @Override
    public void deleteBoat(String id) {

    }
}
