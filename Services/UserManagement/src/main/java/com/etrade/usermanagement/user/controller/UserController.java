package com.etrade.usermanagement.user.controller;

import com.etrade.usermanagement.user.dto.UserCredentialsDTO;
import com.etrade.usermanagement.user.dto.UserDTO;
import com.etrade.usermanagement.user.service.UserServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImp service;

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(service.createUser(userDTO));
    }

    @GetMapping("/hello")
    public String hello() { return "hello!" ; }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody UserCredentialsDTO dto) {
        if (service.verifyCredentials(dto)) {
            UserDTO user = service.getUserByCredentials(dto);
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
    }

}
