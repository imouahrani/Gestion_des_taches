package com.app.gestionDesTaches.service;

import java.util.List;
import java.util.Optional;

import com.app.gestionDesTaches.model.State;

public interface StateService {
	Optional<State> findOne(Long id);

	List<State> findAll();

	void save(State state);

	void update(State state);

	void delete(Long id);

	void delete(State state);

	State findByCode(String code);

}
