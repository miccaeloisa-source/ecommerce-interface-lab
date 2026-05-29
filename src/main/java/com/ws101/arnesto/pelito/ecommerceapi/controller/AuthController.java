package com.ws101.arnesto.pelito.ecommerceapi.controller;

import com.ws101.arnesto.pelito.ecommerceapi.dto.AuthenticationRequest;
import com.ws101.arnesto.pelito.ecommerceapi.dto.AuthenticationResponse;
import com.ws101.arnesto.pelito.ecommerceapi.jwt.JwtService;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;

    private final JwtService jwtService;

    public AuthController(
            AuthenticationManager authenticationManager,
            JwtService jwtService
    ) {

        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public AuthenticationResponse login(
            @RequestBody AuthenticationRequest request
    ) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        var user =
                org.springframework.security.core.userdetails.User
                        .withUsername(request.getUsername())
                        .password("")
                        .authorities("USER")
                        .build();

        String token =
                jwtService.generateToken(user);

        return new AuthenticationResponse(token);
    }
}