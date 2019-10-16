package com.ems.projectsservice.repository;

import com.deshan.ems.commons.model.project.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepo extends JpaRepository<Project, Integer> {

    public List<Project> findByProjidIn(List<Integer> idList);

}
