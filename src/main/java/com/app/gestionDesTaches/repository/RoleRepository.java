package com.app.gestionDesTaches.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.gestionDesTaches.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

	Role findByCode(String code);

}
