package com.work.baseapp.repository;

import com.work.baseapp.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, String> {
}