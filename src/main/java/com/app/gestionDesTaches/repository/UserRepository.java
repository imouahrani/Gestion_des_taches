package com.app.gestionDesTaches.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.gestionDesTaches.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);
}
