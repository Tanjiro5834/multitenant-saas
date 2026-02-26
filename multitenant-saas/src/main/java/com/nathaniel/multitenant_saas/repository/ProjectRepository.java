package com.nathaniel.multitenant_saas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nathaniel.multitenant_saas.entity.Project;
import com.nathaniel.multitenant_saas.entity.Organization;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.UUID;
import java.util.Optional;
@Repository
public interface ProjectRepository extends JpaRepository<Project, Long>{
    Page<Project> findAllByOrganizationAndDeletedFalse(
            Organization organization,
            Pageable pageable
    );

    Optional<Project> findByIdAndOrganizationAndDeletedFalse(
            UUID id,
            Organization organization
    );

    boolean findByName(String name);
}
