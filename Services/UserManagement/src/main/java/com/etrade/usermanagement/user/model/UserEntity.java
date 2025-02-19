package com.etrade.usermanagement.user.model;


import com.etrade.usermanagement.enums.Gender;
import com.etrade.usermanagement.enums.Status;
import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;


@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "users")

public abstract class UserEntity {
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private UUID userId;

    @Column(unique = true, nullable = false)
    private Long cin;

    @Column(name = "first_name", nullable = false)
    private String firstName;


    @Column(name = "middle_name")
    private String middleName;


    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(unique = true, nullable = false)
    private String username;

    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "address")
    private String address;

    @Column(name = "phone_number")
    private String phoneNumber;


    @Enumerated(EnumType.STRING)
    private Status accountStatus = Status.PENDING;

    @Column(name = "creation_date", updatable = false)
    private LocalDateTime creationDate;

    @Column(name = "update_date")
    private LocalDateTime updateDate;

    public void activate() {
        if (this.accountStatus != Status.ACTIVE) {
            this.accountStatus = Status.ACTIVE;
            this.updateDate = LocalDateTime.now();
        }
    }

    public void deactivate() {
        if (this.accountStatus != Status.INACTIVE) {
            this.accountStatus = Status.INACTIVE;
            this.updateDate = LocalDateTime.now();
        }
    }

    public void block() {
        if (this.accountStatus != Status.BLOCKED) {
            this.accountStatus = Status.BLOCKED;
            this.updateDate = LocalDateTime.now();
        }
    }

    // Audit methods
    @PrePersist
    protected void onCreate() {
        this.creationDate = LocalDateTime.now();
        this.updateDate = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updateDate = LocalDateTime.now();
    }


    public String getFullName() {
        return middleName != null
                ? String.format("%s %s %s", firstName, middleName, lastName)
                : String.format("%s %s", firstName, lastName);
    }

    public boolean isAdult() {
        return dateOfBirth != null && dateOfBirth.plusYears(18).isBefore(LocalDate.now());
    }


    public void encodePassword(String encodedPassword) {
        this.password = encodedPassword;
    }
}
