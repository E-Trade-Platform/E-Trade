package com.etrade.usermanagement.model.user;

import com.etrade.usermanagement.model.role.RoleDTO;
import com.etrade.usermanagement.model.shared.Gender;
import com.etrade.usermanagement.model.shared.Status;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.UUID;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@Setter

public class UserDTO {
    private UUID userId;

    @NotNull(message = "CIN is required")
    private Long cin;

    @NotBlank(message = "First name is required")
    private String firstName;

    private String middleName;

    @NotBlank(message = "Last name is required")
    private String lastName;

    @NotBlank(message = "Username is required")
    private String username;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    private String email;

    private String password;

    private Gender gender;

    @Past(message = "Date of birth must be in the past")
    private LocalDate dateOfBirth;

    private String address;

    private String phoneNumber;

    @NotNull(message = "Role is required")
    private RoleDTO role;

    private Status accountStatus;

    private LocalDateTime creationDate;

    private LocalDateTime updateDate;
}