package com.project.eunice.dto.auth;

import lombok.Data;

@Data
public class AuthResponse {
    private String email;
    private String token;
    private String userRole;
}
