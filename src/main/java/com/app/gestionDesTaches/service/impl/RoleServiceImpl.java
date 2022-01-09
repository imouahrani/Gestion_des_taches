package com.app.gestionDesTaches.service.impl;
import com.app.gestionDesTaches.*;

import java.util.*;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.gestionDesTaches.model.Role;
import com.app.gestionDesTaches.repository.RoleRepository;
import com.app.gestionDesTaches.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleRepository repository;

	@Override
	public Optional<Role> findOne(Long id) {
		return repository.findById(id);
	}

	@Override
	public List<Role> findAll() {
		return repository.findAll();
	}

	@Override
	public void save(Role Role) {
		repository.save(Role);

	}

	@Override
	public void update(Role Role) {
		repository.save(Role);
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}

	@Override
	public void delete(Role Role) {
		repository.delete(Role);
	}

	@Override
	public Role findByCode(String code) {
		return repository.findByCode(code);
	}

}
