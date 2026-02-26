package com.nathaniel.multitenant_saas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.nathaniel.multitenant_saas.entity.Project;
import com.nathaniel.multitenant_saas.service.ProjectService;
import java.util.List;
@Controller
public class ProjectController {
    private final ProjectService projectService;
    public ProjectController(ProjectService projectService){
        this.projectService = projectService;
    }

    @GetMapping("/api/projects")
    public List<Project> getAllProjects(){
        return projectService.getAllProjects();
    }
}
