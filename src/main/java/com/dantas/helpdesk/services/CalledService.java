package com.dantas.helpdesk.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dantas.helpdesk.domain.Called;
import com.dantas.helpdesk.domain.repositories.CalledRepository;
import com.dantas.helpdesk.services.exceptions.ObjectNotFoundException;

@Service
public class CalledService {
	
	@Autowired
	private CalledRepository repository;
	
	public Called findById(Integer id) {
		Optional<Called> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found! ID:" + id));
		
	}
	
	public List<Called> findAll(){
		return repository.findAll();
	}


}
