package com.nathaniel.multitenant_saas.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nathaniel.multitenant_saas.entity.Organization;
import com.nathaniel.multitenant_saas.entity.User;

public interface UserRepository extends JpaRepository<User, UUID> {

    Optional<User> findByEmail(String email);

    List<User> findAllByOrganization(Organization organization);

    Optional<User> findByIdAndOrganization(UUID id, Organization organization);

    boolean existsByEmail(String email);
}