package com.nathaniel.multitenant_saas.dto.auth;

import java.util.UUID;

public record AuthResponse(
    String token,
    String email,
    UUID organizationId
) {}
