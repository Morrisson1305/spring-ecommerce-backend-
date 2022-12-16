package com.project.eunice.dto.user;

import com.project.eunice.Domain.enums.Role;
import jakarta.validation.constraints.NotBlank;

import java.util.Set;

public class UserRequest {
    @NotBlank(message = "First name cannot be empty")
    private String firstName;

    @NotBlank(message = "Last name cannot be empty")
    private String lastName;

    @NotBlank(message = "Username cannot be empty")
    private String username;

    @NotBlank(message = "Email cannot be empty")
    private String email;

    private String city;
    private String address;
    private String telephone;
    private String postIndex;
    private String provider;
    private boolean active;
    private String activationCode;
    private String passwordResetCode;
    private Set<Role> roles;
}
