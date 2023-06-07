package com.dantas.helpdesk.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dantas.helpdesk.domain.Tecnic;
import com.dantas.helpdesk.domain.repositories.TecnicRepository;
import com.dantas.helpdesk.services.exceptions.ObjectNotFoundException;

@Service
public class TecnicService {
	
	@Autowired
	private TecnicRepository repository;
	
	public Tecnic findById(Integer id) {
		Optional<Tecnic> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found! Id: "+ id));
	}

}
