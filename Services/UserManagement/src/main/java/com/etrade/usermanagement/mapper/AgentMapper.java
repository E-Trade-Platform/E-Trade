package com.etrade.usermanagement.mapper;


import com.etrade.usermanagement.model.agent.AgentDTO;
import com.etrade.usermanagement.model.agent.AgentDTO;
import com.etrade.usermanagement.model.agent.AgentEntity;
import org.springframework.stereotype.Component;

@Component
public class AgentMapper extends UserMapper {

    public AgentMapper(RoleMapper roleMapper) {
        super(roleMapper);
    }

    public AgentDTO toDTO(AgentEntity entity) {
        if (entity == null) {
            return null;
        }

        AgentDTO dto = new AgentDTO();
        mapEntityToDto(entity, dto);
        return dto;
    }

    public AgentEntity toEntity(AgentDTO dto) {
        if (dto == null) {
            return null;
        }

        AgentEntity entity = new AgentEntity();
        mapDtoToEntity(dto, entity);
        return entity;
    }
}