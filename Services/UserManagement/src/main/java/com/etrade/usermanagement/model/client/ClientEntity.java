package com.etrade.usermanagement.model.client;

import com.etrade.usermanagement.model.shared.ClientType;
import com.etrade.usermanagement.model.user.UserEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("CLIENT")
@PrimaryKeyJoinColumn(name = "client_id")
@Getter
@Setter
public class ClientEntity extends UserEntity {


    @Column(name = "client_type")
    @Enumerated(EnumType.STRING)
    private ClientType clientType;

}
