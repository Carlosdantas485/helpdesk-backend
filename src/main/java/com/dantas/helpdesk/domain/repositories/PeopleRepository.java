package com.dantas.helpdesk.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dantas.helpdesk.domain.People;

public interface PeopleRepository extends JpaRepository<People, Integer> {

}
