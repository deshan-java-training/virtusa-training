package com.ems.tasksservice.repository;

import com.ems.tasksservice.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TasksRepo extends JpaRepository<Task, Integer> {

}
