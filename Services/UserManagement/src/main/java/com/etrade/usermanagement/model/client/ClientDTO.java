package com.etrade.usermanagement.model.client;

import com.etrade.usermanagement.model.shared.ClientType;
import com.etrade.usermanagement.model.user.UserDTO;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ClientDTO extends UserDTO {

    @NotNull(message = "Client type is required")
    private ClientType clientType;
}