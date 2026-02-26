package com.nathaniel.multitenant_saas.dto.project;

import lombok.Data;
import lombok.Builder;
import java.time.Instant;
import java.util.UUID;
@Data
@Builder
public class ProjectResponse {
    private UUID id;
    private String name;
    private String description;
    private Instant createdAt;
}
