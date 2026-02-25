package com.nathaniel.multitenant_saas.service;

import com.nathaniel.multitenant_saas.dto.auth.AuthResponse;
import com.nathaniel.multitenant_saas.dto.auth.LoginRequest;
import com.nathaniel.multitenant_saas.dto.auth.RegisterRequest;
import com.nathaniel.multitenant_saas.entity.Organization;
import com.nathaniel.multitenant_saas.repository.OrganizationRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class OrganizationService {
    private final OrganizationRepository organizationRepository;

    public OrganizationService(OrganizationRepository organizationRepository){
        this.organizationRepository = organizationRepository;
    }

    public List<Organization> getAllOrganizations(){
        return organizationRepository.findAll();
    }

    public Organization registerOrganization(RegisterRequest registerRequest){
        if(organizationRepository.existByAdminEmail(registerRequest.adminEmail)){
            throw new RuntimeException("Admin email already exists.");
        }

        Organization org = new Organization();
        org.setName(registerRequest.name);
        org.setAdminEmail(registerRequest.adminEmail);
        org.setPassword(registerRequest.password);

        return organizationRepository.save(org);
    }

    public AuthResponse login(LoginRequest loginRequest){
        Organization organization = getOrganization(loginRequest.adminEmail);
        if(!organization.getPassword().equalsIgnoreCase(loginRequest.password)){
            throw new RuntimeException("Invalid Email or Password");
        }

        String sampleToken = "eyJhbGciOiJIUzI1NiJ9..." ;
        return new AuthResponse(sampleToken, organization.getAdminEmail(), organization.getId());
    }

    public Organization getOrganization(String email){
        return organizationRepository.findByAdminEmail(email)
        .orElseThrow(() -> new RuntimeException("Organization not found with admin email: " + email));
    }
}
