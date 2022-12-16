package com.project.eunice.mapper;

import com.project.eunice.Repo.DbContracts.IAuthService;
import com.project.eunice.dto.PasswordResetRequest;
import com.project.eunice.dto.RegistrationResquest;
import com.project.eunice.dto.auth.AuthResponse;
import com.project.eunice.dto.auth.AuthRequest;
import com.project.eunice.dto.user.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class AuthMapper {

    private final IAuthService authenticationService;
    private final UserMapper userMapper;

    public AuthResponse login(AuthRequest request) {
        Map<String, String> credentials = authenticationService.login(request.getEmail(), request.getPassword());
        AuthResponse response = new AuthResponse();
        response.setEmail(credentials.get("email"));
        response.setToken(credentials.get("token"));
        response.setUserRole(credentials.get("userRole"));
        return response;
    }

    public String registerUser( RegistrationResquest registrationRequest) {
        return authenticationService.registerUser(userMapper.convertToEntity(registrationRequest), registrationRequest.getPassword2());
    }


}
