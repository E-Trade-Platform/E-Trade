package com.etrade.usermanagement.user.service;



import com.etrade.usermanagement.user.dto.UserCredentialsDTO;
import com.etrade.usermanagement.user.dto.UserMapper;
import com.etrade.usermanagement.user.dto.UserDTO;
import com.etrade.usermanagement.user.model.UserEntity;
import com.etrade.usermanagement.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
@EnableMethodSecurity
public class UserServiceImp implements UserService{
    private final UserMapper userMapperFactory;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImp(UserMapper userMapperFactory,
                          UserRepository userRepository,
                          PasswordEncoder passwordEncoder) {
        this.userMapperFactory = userMapperFactory;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDTO createUser(UserDTO dto) {

        UserEntity entity = userMapperFactory.toEntity(dto);
        entity.setPassword(passwordEncoder.encode(entity.getPassword()));
        entity = userRepository.save(entity);
        return userMapperFactory.toDTO(entity);
    }

    @Override
    public UserEntity getUserByEmail(String email) {
        return userRepository.fetchUserByEmail(email);
    }

    public UserDTO getUserByUsername(String username) {
        UserEntity user = userRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        return userMapperFactory.toDTO(user);
    }


    @Override
    public boolean verifyCredentials(UserCredentialsDTO credentialsDTO) {
        Optional<UserEntity> userOpt = userRepository.findByUsername(credentialsDTO.getUsername());

        return userOpt.isPresent() &&
                passwordEncoder.matches(credentialsDTO.getPassword(), userOpt.get().getPassword());
    }

    @Override
    public UserDTO getUserByCredentials(UserCredentialsDTO dto) {
        return null;
    }


}
