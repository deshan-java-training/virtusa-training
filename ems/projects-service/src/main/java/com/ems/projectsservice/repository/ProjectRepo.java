package com.ems.projectsservice.repository;

import com.ems.projectsservice.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepo extends JpaRepository<Project, Integer> {

}
