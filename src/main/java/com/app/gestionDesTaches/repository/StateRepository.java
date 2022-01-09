package com.app.gestionDesTaches.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.gestionDesTaches.model.State;

public interface StateRepository extends JpaRepository<State, Long> {

	State findByCode(String code);

}
