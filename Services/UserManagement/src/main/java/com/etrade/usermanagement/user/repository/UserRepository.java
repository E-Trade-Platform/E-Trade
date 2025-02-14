package com.etrade.usermanagement.user.repository;

import com.etrade.usermanagement.user.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    @Query(value = "SELECT U FROM UserEntity U WHERE U.email = :email")
    UserEntity fetchUserByEmail(@Param("email") final String email);
    @Query(value = "SELECT U FROM UserEntity U WHERE U.username = :username")
    Optional<UserEntity> findByUsername(String username);

}
