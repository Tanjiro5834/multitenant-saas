package com.nathaniel.multitenant_saas.repository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.UUID;
import com.nathaniel.multitenant_saas.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long>{
    Optional<Organization> findByName(String name);
    Optional<Organization> findById(UUID id);
    Optional<Organization> findByAdminEmail(String email);
    boolean existsByName(String name);
    boolean existByAdminEmail(String email);
}   
