package com.omb.boatapi.application.port.in;

import com.omb.boatapi.domain.model.Boat;
import com.omb.boatapi.domain.model.Category;

import java.util.List;

public interface BoatService {

    Boat saveBoat(final Boat boat);
    Boat findById(final String id);
    List<Boat> findAllBoat();
    Boat updateBoat(final String id, final String name, final Category category
            , final String description, final String registration);
    void deleteBoat(final String id);
}
