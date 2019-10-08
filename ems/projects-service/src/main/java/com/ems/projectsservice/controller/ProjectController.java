package com.ems.projectsservice.controller;

import com.ems.projectsservice.model.Project;
import com.ems.projectsservice.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProjectController {
@Autowired
ProjectService projectService;

    @RequestMapping(value = "/projects", method = RequestMethod.POST)
    public Project saveProject(@RequestBody Project project){
    projectService.saveProject(project);
    return project;
    }

    @RequestMapping(value = "/projects", method = RequestMethod.GET)
    public List<Project> getAllProjects(){
    return projectService.getAllProjects();
    }


    @RequestMapping(value = "/projects/{ids}", method = RequestMethod.GET)
    public List<Project> getProjects(@PathVariable List<Integer> ids){
        return projectService.getProjectsByIds(ids);
    }
}
