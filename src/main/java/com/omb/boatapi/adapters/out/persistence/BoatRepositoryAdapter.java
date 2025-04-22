package com.omb.boatapi.adapters.out.persistence;

import com.omb.boatapi.adapters.out.persistence.jpa.entity.BoatEntity;
import com.omb.boatapi.adapters.out.persistence.jpa.repository.BoatJpaRepository;
import com.omb.boatapi.adapters.out.persistence.mapper.BoatMapper;
import com.omb.boatapi.application.port.out.BoatRepositoryPort;
import com.omb.boatapi.domain.exception.NotFoundException;
import com.omb.boatapi.domain.model.Boat;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class BoatRepositoryAdapter implements BoatRepositoryPort {

    private final BoatJpaRepository boatJpaRepository;
    private final BoatMapper mapper;

    @Override
    public List<Boat> findAllBoat() {
        List<BoatEntity> boatEntities = boatJpaRepository.findAll();
        return mapper.toListDomain(boatEntities);
    }

    @Override
    public Optional<Boat> findById(UUID id) {
        return mapper.toDomain(boatJpaRepository.findById(id));
    }

    @Override
    public Boat saveBoat(Boat boat) {
        BoatEntity boatEntity = mapper.toEntity(boat);
        return mapper.toDomain(boatJpaRepository.save(boatEntity));
    }

    @Override
    public void delete(UUID id) {
        BoatEntity boatEntity = boatJpaRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Boat not found for id: " + id));
        boatJpaRepository.delete(boatEntity);
    }
}
