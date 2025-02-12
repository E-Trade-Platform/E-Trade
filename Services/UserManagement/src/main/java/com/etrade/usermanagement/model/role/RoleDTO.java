package com.etrade.usermanagement.model.role;

import com.etrade.usermanagement.model.shared.Permission;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.UUID;

import java.util.Set;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoleDTO {
    private UUID id;

    @NotBlank(message = "Role name is required")
    private String name;

    @NotBlank(message = "Role description is required")
    private String description;

    private Set<Permission> permissions;
}