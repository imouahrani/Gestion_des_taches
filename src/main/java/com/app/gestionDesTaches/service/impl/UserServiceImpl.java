package com.app.gestionDesTaches.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.gestionDesTaches.model.User;
import com.app.gestionDesTaches.repository.UserRepository;
import com.app.gestionDesTaches.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository repository;

	@Override
	public Optional<User> findOne(Long id) {
		return repository.findById(id);
	}

	@Override
	public List<User> findAll() {
		return repository.findAll();
	}

	@Override
	public void save(User user) {
		repository.save(user);

	}

	@Override
	public void update(User user) {
		repository.save(user);
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}

	@Override
	public void delete(User user) {
		repository.delete(user);
	}

	@Override
	public User findByEmail(String email) {
		return repository.findByEmail(email);
	}

}
