package com.ems.tasksservice.repository;

import com.ems.tasksservice.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TasksRepo extends JpaRepository<Task, Integer> {

public List<Task> findByTaskidIn(List<Integer> tasksList);
}
