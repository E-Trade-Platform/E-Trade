package com.etrade.usermanagement.mapper;

import com.etrade.usermanagement.model.role.RoleDTO;
import com.etrade.usermanagement.model.role.Role;
import org.springframework.stereotype.Component;
import java.util.HashSet;

@Component
public class RoleMapper {

    public RoleDTO toDTO(Role role) {
        if (role == null) {
            return null;
        }

        return RoleDTO.builder()
                .id(role.getId())
                .name(role.getName())
                .description(role.getDescription())
                .permissions(role.getPermissions())
                .build();
    }

    public Role toEntity(RoleDTO dto) {
        if (dto == null) {
            return null;
        }

        return Role.builder()
                .id(dto.getId())
                .name(dto.getName())
                .description(dto.getDescription())
                .permissions(dto.getPermissions() != null ?
                        new HashSet<>(dto.getPermissions()) : new HashSet<>())
                .build();
    }
}