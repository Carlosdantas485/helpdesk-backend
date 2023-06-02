package com.dantas.helpdesk.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dantas.helpdesk.domain.Called;

public interface CalledRepository extends JpaRepository<Called, Integer> {

}
