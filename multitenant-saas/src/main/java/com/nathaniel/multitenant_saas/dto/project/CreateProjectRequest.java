package com.nathaniel.multitenant_saas.dto.project;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
public class CreateProjectRequest {
    @NotBlank
    @Size(max = 100)
    public String name;

    @Size(max = 100)
    public String description;
}
