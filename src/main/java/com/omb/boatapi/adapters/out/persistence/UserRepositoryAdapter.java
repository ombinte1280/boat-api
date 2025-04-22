package com.omb.boatapi.adapters.out.persistence;

import com.omb.boatapi.adapters.out.persistence.jpa.entity.UserEntity;
import com.omb.boatapi.adapters.out.persistence.jpa.repository.UserJpaRepository;
import com.omb.boatapi.adapters.out.persistence.mapper.UserMapper;
import com.omb.boatapi.application.port.out.UserRepositoryPort;
import com.omb.boatapi.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepositoryAdapter implements UserRepositoryPort {

    private final UserJpaRepository userJpaRepository;
    private final UserMapper userMapper;

    @Override
    public User save(User user) {
        UserEntity userEntity = userMapper.toEntity(user);
        return userMapper.toDomain(userJpaRepository.save(userEntity));
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userMapper.toDomain(userJpaRepository.findByUsername(username));
    }

}
