package com.nathaniel.multitenant_saas.controller;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.nathaniel.multitenant_saas.dto.auth.AuthResponse;
import com.nathaniel.multitenant_saas.dto.auth.LoginRequest;
import com.nathaniel.multitenant_saas.dto.auth.RegisterRequest;
import com.nathaniel.multitenant_saas.entity.Organization;
import com.nathaniel.multitenant_saas.service.OrganizationService;
import com.nathaniel.multitenant_saas.entity.OrganizationStatus;

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

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request){
        try{
            Organization org = organizationService.registerOrganization(request);
            String token = String.valueOf(UUID.randomUUID());
            AuthResponse response = new AuthResponse(token, org.getAdminEmail(), org.getId());
            return ResponseEntity.ok(response);
        }catch(RuntimeException e){
            return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(new AuthResponse(null, request.adminEmail, null));
        }
    }
}
