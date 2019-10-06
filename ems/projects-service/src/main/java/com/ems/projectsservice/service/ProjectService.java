package com.ems.projectsservice.service;

import com.ems.projectsservice.model.Project;
import com.ems.projectsservice.repository.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProjectService {

    @Autowired
    ProjectRepo projectRepo;

    public List<Project> getAllProjects(){
    return  projectRepo.findAll();
    }

    public Project saveProject(Project project){
        return projectRepo.save(project);
    }
}
