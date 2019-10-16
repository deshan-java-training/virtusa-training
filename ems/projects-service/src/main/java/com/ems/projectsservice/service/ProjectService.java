package com.ems.projectsservice.service;

import com.deshan.ems.commons.model.project.Project;
import com.ems.projectsservice.repository.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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


    public List<Project> getProjectsByIds(List<Integer> empList){
        return projectRepo.findByProjidIn(empList);
    }

    public Optional<Project> findProjectById(int i){
        return projectRepo.findById(i);
    }
}
