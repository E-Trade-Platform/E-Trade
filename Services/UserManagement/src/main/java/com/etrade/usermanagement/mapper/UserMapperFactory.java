package com.etrade.usermanagement.mapper;

import com.etrade.usermanagement.model.admin.AdminDTO;
import com.etrade.usermanagement.model.admin.AdminEntity;
import com.etrade.usermanagement.model.agent.AgentDTO;
import com.etrade.usermanagement.model.agent.AgentEntity;
import com.etrade.usermanagement.model.client.ClientDTO;
import com.etrade.usermanagement.model.client.ClientEntity;
import com.etrade.usermanagement.model.user.UserDTO;
import com.etrade.usermanagement.model.user.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapperFactory {
    private final AdminMapper adminMapper;
    private final AgentMapper agentMapper;
    private final ClientMapper clientMapper;

    public UserMapperFactory(AdminMapper adminMapper, AgentMapper agentMapper, ClientMapper clientMapper) {
        this.adminMapper = adminMapper;
        this.agentMapper = agentMapper;
        this.clientMapper = clientMapper;
    }

    public UserDTO toDTO(UserEntity entity) {
        if (entity instanceof AdminEntity) {
            return adminMapper.toDTO((AdminEntity) entity);
        } else if (entity instanceof AgentEntity) {
            return agentMapper.toDTO((AgentEntity) entity);
        } else if (entity instanceof ClientEntity) {
            return clientMapper.toDTO((ClientEntity) entity);
        }
        throw new IllegalArgumentException("Unknown user type: " + entity.getClass());
    }

    public UserEntity toEntity(UserDTO dto) {
        if (dto instanceof AdminDTO) {
            return adminMapper.toEntity((AdminDTO) dto);
        } else if (dto instanceof AgentDTO) {
            return agentMapper.toEntity((AgentDTO) dto);
        } else if (dto instanceof ClientDTO) {
            return clientMapper.toEntity((ClientDTO) dto);
        }
        throw new IllegalArgumentException("Unknown DTO type: " + dto.getClass());
    }
}