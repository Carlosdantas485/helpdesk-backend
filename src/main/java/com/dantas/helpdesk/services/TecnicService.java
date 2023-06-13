package com.dantas.helpdesk.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dantas.helpdesk.domain.People;
import com.dantas.helpdesk.domain.Tecnic;
import com.dantas.helpdesk.domain.dtos.TecnicDTO;
import com.dantas.helpdesk.domain.repositories.PeopleRepository;
import com.dantas.helpdesk.domain.repositories.TecnicRepository;
import com.dantas.helpdesk.services.exceptions.DataIntegrityViolationException;
import com.dantas.helpdesk.services.exceptions.ObjectNotFoundException;

import jakarta.validation.Valid;

@Service
public class TecnicService {
	
	@Autowired
	private TecnicRepository repository;
	
	@Autowired
	private PeopleRepository peopleRepository;
	
	public Tecnic findById(Integer id) {
		Optional<Tecnic> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found! Id: "+ id));
	}
	
	public List<Tecnic> findAll(){
		return repository.findAll();
	}

	public Tecnic create(TecnicDTO objDTO) {
		objDTO.setId(null);
		CPFvalidateAndEmail(objDTO);
		Tecnic newObj = new Tecnic(objDTO);
		return repository.save(newObj);
	}
	
	public Tecnic update(Integer id,@Valid TecnicDTO objDTO) {
		objDTO.setId(id);
		Tecnic oldObj = findById(id);
		CPFvalidateAndEmail(objDTO);
		oldObj = new Tecnic(objDTO);
		return repository.save(oldObj);
	}
	
	public void delet(Integer id) {
		Tecnic obj = findById(id);
		if(obj.getCalled().size() > 0) {
			throw new DataIntegrityViolationException("This tecnic can't be deleted because he has tasks opened!");
		}
		repository.deleteById(id);
	}
	
	private void CPFvalidateAndEmail(TecnicDTO objDTO) {
		Optional <People> obj = peopleRepository.findByCpf(objDTO.getCpf());
		
		if(obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("CPF already exists!");
		}
		
		obj =  peopleRepository.findByEmail(objDTO.getEmail());
		
		if(obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("Email already exists!");
		}
	}

	

	

}
