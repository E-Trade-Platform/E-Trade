package com.etrade.usermanagement.user.repository;

import com.etrade.usermanagement.user.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {}
