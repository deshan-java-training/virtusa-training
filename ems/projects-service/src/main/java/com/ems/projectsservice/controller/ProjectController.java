package com.ems.projectsservice.controller;

import com.ems.projectsservice.model.Project;
import com.ems.projectsservice.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProjectController {
@Autowired
ProjectService projectService;

    @RequestMapping(value = "/projects", method = RequestMethod.POST)
    @PreAuthorize("hasRole('ROLE_manager') AND hasAuthority('create_perm')")
    public Project saveProject(@RequestBody Project project){
    projectService.saveProject(project);
    return project;
    }

    @RequestMapping(value = "/projects", method = RequestMethod.GET)
    public List<Project> getAllProjects(){
    return projectService.getAllProjects();
    }


    @RequestMapping(value = "/projects-list/{ids}", method = RequestMethod.GET)
    public List<Project> getProjects(@PathVariable List<Integer> ids){
        return projectService.getProjectsByIds(ids);
    }

    @RequestMapping(value = "/projects/{id}", method = RequestMethod.GET)
    public Optional<Project> getProjectById(@PathVariable int id){
        return projectService.findProjectById(id);
    }
}
