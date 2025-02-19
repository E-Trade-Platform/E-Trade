package com.etrade.usermanagement.user.service;

import com.etrade.usermanagement.user.model.UserEntity;
import com.etrade.usermanagement.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<UserEntity> getAllUsers() { return userRepository.findAll(); }
    public UserEntity getUserById(Long id) { return userRepository.findById(id).orElseThrow(); }
    public UserEntity saveUser(UserEntity user) { return userRepository.save(user); }
    public void deleteUser(Long id) { userRepository.deleteById(id); }
}
