package com.dantas.helpdesk.domain.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dantas.helpdesk.domain.People;



public interface PeopleRepository extends JpaRepository<People, Integer> {
	Optional<People> findByCpf(String cpf);
	Optional<People> findByEmail(String email);
	
	
}
