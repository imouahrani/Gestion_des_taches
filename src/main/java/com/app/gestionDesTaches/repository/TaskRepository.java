package com.app.gestionDesTaches.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.gestionDesTaches.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

	int countByStateCode(String code);

	List<Task> findByStateCode(String code);
}
