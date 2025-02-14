package com.etrade.usermanagement.user.dto;

import com.etrade.usermanagement.shared.Gender;
import com.etrade.usermanagement.shared.Status;
import com.etrade.usermanagement.user.model.UserEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Map;

@Component
public class UserMapper {

    public UserMapper() {

    }

    public UserDTO toDTO(UserEntity entity) {
        if (entity == null) {
            return null; // Prevents NullPointerException
        }

        UserDTO dto = new UserDTO();
        dto.setUserId(entity.getUserId());
        dto.setCin(entity.getCin());
        dto.setFirstName(entity.getFirstName());
        dto.setMiddleName(entity.getMiddleName());
        dto.setLastName(entity.getLastName());
        dto.setUsername(entity.getUsername());
        dto.setEmail(entity.getEmail());
        dto.setGender(entity.getGender());
        dto.setDateOfBirth(entity.getDateOfBirth());
        dto.setAddress(entity.getAddress());
        dto.setPhoneNumber(entity.getPhoneNumber());
        dto.setAccountStatus(entity.getAccountStatus());
        dto.setCreationDate(entity.getCreationDate());
        dto.setUpdateDate(entity.getUpdateDate());


        return dto;
    }

    public UserEntity toEntity(UserDTO dto) {
        if (dto == null) {
            return null; // Prevents NullPointerException
        }

        UserEntity entity = new UserEntity();
        entity.setUserId(dto.getUserId());
        entity.setCin(dto.getCin());
        entity.setFirstName(dto.getFirstName());
        entity.setMiddleName(dto.getMiddleName());
        entity.setLastName(dto.getLastName());
        entity.setUsername(dto.getUsername());
        entity.setEmail(dto.getEmail());
        if (dto.getPassword() != null) { // Ensure we don’t overwrite passwords with null
            entity.setPassword(dto.getPassword());
        }
        entity.setGender(dto.getGender());
        entity.setDateOfBirth(dto.getDateOfBirth());
        entity.setAddress(dto.getAddress());
        entity.setPhoneNumber(dto.getPhoneNumber());
        entity.setAccountStatus(dto.getAccountStatus());


        return entity;
    }

    public UserCredentialsDTO toCredentialsDTO(UserEntity entity){
        UserCredentialsDTO dto = new UserCredentialsDTO();
        dto.setUsername(entity.getUsername());
        dto.setPassword(entity.getPassword());
        return dto;

    }


    public UserDTO fromTokenAttributes(Map<String, Object> attributes) {
        UserDTO user = new UserDTO();

        if (attributes.containsKey("sub")) {
            user.setUserId(Long.valueOf(attributes.get("sub").toString()));
        }

        if (attributes.containsKey("given_name")) {
            user.setFirstName(attributes.get("given_name").toString());
        } else if (attributes.containsKey("nickname")) {
            user.setFirstName(attributes.get("nickname").toString());
        }

        if (attributes.containsKey("family_name")) {
            user.setLastName(attributes.get("family_name").toString());
        }

        if (attributes.containsKey("email")) {
            user.setEmail(attributes.get("email").toString());
        }

        if (attributes.containsKey("preferred_username")) {
            user.setUsername(attributes.get("preferred_username").toString());
        }

        if (attributes.containsKey("gender")) {
            try {
                user.setGender(Gender.valueOf(attributes.get("gender").toString().toUpperCase()));
            } catch (IllegalArgumentException e) {
                user.setGender(null); // Handle invalid values gracefully
            }
        }

        if (attributes.containsKey("birthdate")) {
            user.setDateOfBirth(LocalDate.parse(attributes.get("birthdate").toString()));
        }

        if (attributes.containsKey("phone_number")) {
            user.setPhoneNumber(attributes.get("phone_number").toString());
        }

        if (attributes.containsKey("address")) {
            user.setAddress(attributes.get("address").toString());
        }

        if (attributes.containsKey("account_status")) {
            try {
                user.setAccountStatus(Status.valueOf(attributes.get("account_status").toString().toUpperCase()));
            } catch (IllegalArgumentException e) {
                user.setAccountStatus(Status.PENDING); // Default if invalid
            }
        }

        return user;
    }
}
