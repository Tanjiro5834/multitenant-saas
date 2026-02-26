package com.nathaniel.multitenant_saas.dto.user;

import com.nathaniel.multitenant_saas.entity.Role;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CreateUserRequest {
    @Email
    @NotNull
    public String email;

    @Size(min = 8)
    public String password;

    @NotNull
    public Role role;
}
