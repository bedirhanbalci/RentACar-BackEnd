package com.tobeto.pair6.rentACar.controllers;

import com.tobeto.pair6.rentACar.services.abstracts.AuthService;
import com.tobeto.pair6.rentACar.services.dtos.auth.requests.LoginRequest;
import com.tobeto.pair6.rentACar.services.dtos.auth.requests.RegisterRequest;
import com.tobeto.pair6.rentACar.services.dtos.auth.responses.AuthenticationResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
@CrossOrigin
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public AuthenticationResponse register(@RequestBody RegisterRequest registerRequest) {
        return authService.register(registerRequest);
    }

    @PostMapping("/login")
    public AuthenticationResponse login(@RequestBody LoginRequest loginRequest) {
        return authService.login(loginRequest);
    }

    @PostMapping("/refreshToken")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        authService.refreshToken(request, response);
    }

}
