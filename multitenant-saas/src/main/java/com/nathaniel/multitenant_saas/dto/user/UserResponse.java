package com.nathaniel.multitenant_saas.dto.user;

import lombok.Data;
import lombok.Builder;
import java.time.Instant;
import java.util.UUID;

import com.nathaniel.multitenant_saas.entity.Role;
@Data
@Builder
public class UserResponse {
    private UUID id;
    private String email;
    private Role role;
    private boolean isEnabled;
    private Instant createdAt;
}
