package com.omb.boatapi.adapters.out.persistence.jpa.repository;

import com.omb.boatapi.adapters.out.persistence.jpa.entity.BoatEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BoatJpaRepository extends JpaRepository<BoatEntity, UUID> {
}
