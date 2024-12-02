package com.George.mcrm.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
@Table(name = "app_user")
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column(unique = true)  // Ensures uniqueness at the database level
    private String username;
    private String password;
    @NotNull(message = "role cannot be null")
    private String role;

}
