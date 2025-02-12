package com.etrade.usermanagement.mapper;


import com.etrade.usermanagement.model.client.ClientDTO;
import com.etrade.usermanagement.model.client.ClientEntity;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper extends UserMapper {

    public ClientMapper(RoleMapper roleMapper) {
        super(roleMapper);
    }

    public ClientDTO toDTO(ClientEntity entity) {
        if (entity == null) {
            return null;
        }

        ClientDTO dto = new ClientDTO();
        mapEntityToDto(entity, dto);
        dto.setClientType(entity.getClientType());
        return dto;
    }

    public ClientEntity toEntity(ClientDTO dto) {
        if (dto == null) {
            return null;
        }

        ClientEntity entity = new ClientEntity();
        mapDtoToEntity(dto, entity);
        entity.setClientType(dto.getClientType());
        return entity;
    }
}