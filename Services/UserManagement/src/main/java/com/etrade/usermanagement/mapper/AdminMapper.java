package com.etrade.usermanagement.mapper;


import com.etrade.usermanagement.model.admin.AdminDTO;
import com.etrade.usermanagement.model.admin.AdminEntity;
import org.springframework.stereotype.Component;

@Component
public class AdminMapper extends UserMapper {

    public AdminMapper(RoleMapper roleMapper) {
        super(roleMapper);
    }

    public AdminDTO toDTO(AdminEntity entity) {
        if (entity == null) {
            return null;
        }

        AdminDTO dto = new AdminDTO();
        mapEntityToDto(entity, dto);
        return dto;
    }

    public AdminEntity toEntity(AdminDTO dto) {
        if (dto == null) {
            return null;
        }

        AdminEntity entity = new AdminEntity();
        mapDtoToEntity(dto, entity);  // Using the renamed method
        return entity;
    }
}