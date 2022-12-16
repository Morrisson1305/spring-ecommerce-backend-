package com.project.eunice.controller;


import com.project.eunice.dto.auth.AuthRequest;
import com.project.eunice.dto.auth.AuthResponse;
import com.project.eunice.exception.InputFieldException;
import com.project.eunice.mapper.AuthMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.project.eunice.dto.RegistrationResquest;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class RegistrationController {

    private final AuthMapper authenticationMapper;

    @PostMapping("/registration")
    public ResponseEntity<String> registration(@Valid @RequestBody RegistrationResquest request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new InputFieldException(bindingResult);
        }
        return ResponseEntity.ok(authenticationMapper.registerUser( request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        return ResponseEntity.ok(authenticationMapper.login(request));
    }
}
