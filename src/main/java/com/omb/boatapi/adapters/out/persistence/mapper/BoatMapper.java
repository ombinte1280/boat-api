package com.omb.boatapi.adapters.out.persistence.mapper;

import com.omb.boatapi.adapters.out.persistence.jpa.entity.BoatEntity;
import com.omb.boatapi.domain.model.Boat;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface BoatMapper {

    Boat toDomain(BoatEntity boatEntity);
    BoatEntity toEntity(Boat boat);
    List<Boat> toListDomain(List<BoatEntity> boatEntities);
    List<BoatEntity> toListEntity(List<Boat> boats);

    default Optional<Boat> toDomain(Optional<BoatEntity> entityOptional) {
        return entityOptional.map(this::toDomain);
    }
}
