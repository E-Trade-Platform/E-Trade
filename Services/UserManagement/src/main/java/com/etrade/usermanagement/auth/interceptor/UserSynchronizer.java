package com.etrade.usermanagement.auth.interceptor;

import com.etrade.usermanagement.user.dto.UserDTO;
import com.etrade.usermanagement.user.dto.UserMapper;
import com.etrade.usermanagement.user.model.UserEntity;
import com.etrade.usermanagement.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserSynchronizer {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public void synchronizeWithIdp(Jwt token) {
        log.info("Synchronizing user with idp");
        getUserEmail(token).ifPresent(userEmail -> {
            log.info("Synchronizing user having email {}", userEmail);
            UserDTO user = userMapper.fromTokenAttributes(token.getClaims());
            UserEntity entity = userMapper.toEntity(user);
            userRepository.save(entity);

        });

    }

    private Optional<String> getUserEmail(Jwt token) {
        Map<String, Object> attributes = token.getClaims();
        if (attributes.containsKey("email")) {
            return Optional.of(attributes.get("email").toString());
        }
        return Optional.empty();

    }
}