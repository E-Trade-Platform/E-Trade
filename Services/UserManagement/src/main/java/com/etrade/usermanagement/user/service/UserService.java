package com.etrade.usermanagement.user.service;

import com.etrade.usermanagement.user.dto.UserCredentialsDTO;
import com.etrade.usermanagement.user.dto.UserDTO;
import com.etrade.usermanagement.user.model.UserEntity;


public interface UserService {

    UserEntity getUserByEmail(String email);
    UserDTO createUser(UserDTO dto);
    boolean verifyCredentials(UserCredentialsDTO dto);

    UserDTO getUserByCredentials(UserCredentialsDTO dto);
}
