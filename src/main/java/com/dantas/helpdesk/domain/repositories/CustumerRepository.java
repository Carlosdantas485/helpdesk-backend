package com.dantas.helpdesk.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dantas.helpdesk.domain.Custumer;


public interface CustumerRepository extends JpaRepository<Custumer, Integer> {

}
