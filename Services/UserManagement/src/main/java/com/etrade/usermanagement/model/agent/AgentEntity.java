package com.etrade.usermanagement.model.agent;

import com.etrade.usermanagement.model.user.UserEntity;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
@DiscriminatorValue("AGENT")
@PrimaryKeyJoinColumn(name = "agent_id")
public class AgentEntity extends UserEntity {

}