package com.etrade.usermanagement.mapper;

import com.etrade.usermanagement.model.user.UserDTO;
import com.etrade.usermanagement.model.user.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    private final RoleMapper roleMapper;

    public UserMapper(RoleMapper roleMapper) {
        this.roleMapper = roleMapper;
    }

    protected void mapEntityToDto(UserEntity source, UserDTO target) {
        target.setUserId(source.getUserId());
        target.setCin(source.getCin());
        target.setFirstName(source.getFirstName());
        target.setMiddleName(source.getMiddleName());
        target.setLastName(source.getLastName());
        target.setUsername(source.getUsername());
        target.setEmail(source.getEmail());
        target.setGender(source.getGender());
        target.setDateOfBirth(source.getDateOfBirth());
        target.setAddress(source.getAddress());
        target.setPhoneNumber(source.getPhoneNumber());
        target.setAccountStatus(source.getAccountStatus());
        target.setCreationDate(source.getCreationDate());
        target.setUpdateDate(source.getUpdateDate());

        if (source.getRole() != null) {
            target.setRole(roleMapper.toDTO(source.getRole()));
        }
    }

    protected void mapDtoToEntity(UserDTO source, UserEntity target) {
        target.setUserId(source.getUserId());
        target.setCin(source.getCin());
        target.setFirstName(source.getFirstName());
        target.setMiddleName(source.getMiddleName());
        target.setLastName(source.getLastName());
        target.setUsername(source.getUsername());
        target.setEmail(source.getEmail());
        if (source.getPassword() != null) {
            target.setPassword(source.getPassword());
        }
        target.setGender(source.getGender());
        target.setDateOfBirth(source.getDateOfBirth());
        target.setAddress(source.getAddress());
        target.setPhoneNumber(source.getPhoneNumber());
        target.setAccountStatus(source.getAccountStatus());

        if (source.getRole() != null) {
            target.setRole(roleMapper.toEntity(source.getRole()));
        }
    }
}