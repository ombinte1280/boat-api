package com.omb.boatapi.adapters.in.rest.mapper;

import com.omb.boatapi.adapters.in.rest.dto.LoginResponse;
import com.omb.boatapi.domain.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserResponseMapper {

    LoginResponse toResponse(User user);
}
