package com.app.gestionDesTaches.service;
import java.util.List;
import java.util.Optional;

import com.app.gestionDesTaches.model.UserTask;

public interface UserTaskService {
	Optional<UserTask> findOne(Long id);

	List<UserTask> findAll();

	void save(UserTask userTask);

	void update(UserTask userTask);

	void delete(Long id);

	void delete(UserTask userTask);

	List<UserTask> findByUserEmailAndTaskStateCode(String email, String code);

	List<UserTask> findByUserEmail(String email);

}
