package com.nathaniel.multitenant_saas.service;

import org.springframework.stereotype.Service;

import com.nathaniel.multitenant_saas.dto.project.CreateProjectRequest;
import com.nathaniel.multitenant_saas.entity.Project;
import com.nathaniel.multitenant_saas.repository.ProjectRepository;

import java.util.List;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository){
        this.projectRepository = projectRepository;
    }

    public List<Project> getAllProjects(){
        return projectRepository.findAll();
    }

    public Project createProject(CreateProjectRequest request){
        if(projectRepository.findByName(request.name)){
            throw new RuntimeException("Project already exist.");
        }

        Project project = new Project();
        project.setName(request.name);
        project.setDescription(request.description);

        return projectRepository.save(project);
    }
}
