package com.nathaniel.multitenant_saas.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.nathaniel.multitenant_saas.dto.auth.AuthResponse;
import com.nathaniel.multitenant_saas.dto.auth.LoginRequest;
import com.nathaniel.multitenant_saas.service.OrganizationService;

public class AuthController {
    private final OrganizationService organizationService;

    public AuthController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        AuthResponse response = organizationService.login(request);
        return ResponseEntity.ok(response);
    }
}
