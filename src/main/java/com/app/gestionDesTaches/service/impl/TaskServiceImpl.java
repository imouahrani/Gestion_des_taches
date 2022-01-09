package com.app.gestionDesTaches.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.gestionDesTaches.model.Task;
import com.app.gestionDesTaches.repository.TaskRepository;
import com.app.gestionDesTaches.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService {
	@Autowired
	private TaskRepository repository;

	@Override
	public Optional<Task> findOne(Long id) {
		return repository.findById(id);
	}

	@Override
	public List<Task> findAll() {
		return repository.findAll();
	}

	@Override
	public void save(Task Task) {
		repository.save(Task);
	}

	@Override
	public void update(Task Task) {
		repository.save(Task);
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}

	@Override
	public void delete(Task Task) {
		repository.delete(Task);
	}

	@Override
	public int countByStateCode(String code) {
		return repository.countByStateCode(code);
	}

	@Override
	public long count() {
		return repository.count();
	}

	@Override
	public List<Task> findByStateCode(String code) {
		return repository.findByStateCode(code);
	}

}
