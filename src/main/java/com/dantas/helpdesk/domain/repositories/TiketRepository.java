package com.dantas.helpdesk.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dantas.helpdesk.domain.Tiket;

public interface TiketRepository extends JpaRepository<Tiket, Integer> {

}
