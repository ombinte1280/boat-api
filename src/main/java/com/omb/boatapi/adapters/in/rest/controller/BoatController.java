package com.omb.boatapi.adapters.in.rest.controller;

import com.omb.boatapi.adapters.in.rest.dto.CreateBoatRequest;
import com.omb.boatapi.adapters.in.rest.dto.PatchBoatRequest;
import com.omb.boatapi.application.port.in.BoatService;
import com.omb.boatapi.domain.model.Boat;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("boats")
@RequiredArgsConstructor
public class BoatController {

    private final BoatService boatService;

    @GetMapping
    public ResponseEntity<List<Boat>> getAllBoats() {
        return ResponseEntity.ok(boatService.findAllBoat());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Boat> getBoatById(@PathVariable final String id) {
        return ResponseEntity.ok(boatService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Boat> createBoat(@Valid @RequestBody final CreateBoatRequest request) {
        Boat newBoat = new Boat(null, request.getName(), request.getCategory());
        return ResponseEntity.ok(boatService.saveBoat(newBoat));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Boat> patchBoat(@PathVariable final String id, @Valid @RequestBody final PatchBoatRequest request) {
        return ResponseEntity.ok(boatService.updateBoat(id, request.getName(), request.getCategory()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBoat(@PathVariable final String id) {
        boatService.deleteBoat(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
