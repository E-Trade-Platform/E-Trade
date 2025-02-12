package com.etrade.usermanagement.model.admin;

import com.etrade.usermanagement.model.user.UserEntity;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
@DiscriminatorValue("ADMIN")
@PrimaryKeyJoinColumn(name = "admin_id")
public class AdminEntity extends UserEntity {

}