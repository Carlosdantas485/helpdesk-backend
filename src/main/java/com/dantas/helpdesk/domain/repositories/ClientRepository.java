package com.dantas.helpdesk.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dantas.helpdesk.domain.Client;


public interface ClientRepository extends JpaRepository<Client, Integer> {

}
