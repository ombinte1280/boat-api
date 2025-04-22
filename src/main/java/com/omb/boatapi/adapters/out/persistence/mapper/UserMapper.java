package com.omb.boatapi.adapters.out.persistence.mapper;

import com.omb.boatapi.adapters.out.persistence.jpa.entity.UserEntity;
import com.omb.boatapi.domain.model.User;
import org.mapstruct.Mapper;

import java.util.Optional;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toDomain(UserEntity userEntity);
    UserEntity toEntity(User user);

    default Optional<User> toDomain(Optional<UserEntity> entityOptional) {
        return entityOptional.map(this::toDomain);
    }
}
