package com.dantas.helpdesk.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.dantas.helpdesk.domain.Custumer;
import com.dantas.helpdesk.domain.People;
import com.dantas.helpdesk.domain.dtos.CustumerDTO;
import com.dantas.helpdesk.domain.repositories.CustumerRepository;
import com.dantas.helpdesk.domain.repositories.PeopleRepository;
import com.dantas.helpdesk.services.exceptions.DataIntegrityViolationException;
import com.dantas.helpdesk.services.exceptions.ObjectNotFoundException;

@Service
public class CustumerService {
	
	@Autowired
	private CustumerRepository repository;
	
	@Autowired
	private PeopleRepository peopleRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	public Custumer findById(Integer id) {
		Optional<Custumer> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found! Id: "+ id));
	}
	
	public List<Custumer> findAll(){
		return repository.findAll();
	}

	public Custumer create(CustumerDTO objDTO) {
		objDTO.setId(null);
		objDTO.setPassword(encoder.encode(objDTO.getPassword()));
		CPFvalidateAndEmail(objDTO);
		Custumer newObj = new Custumer(objDTO);
		return repository.save(newObj);
	}
	
	public Custumer update(Integer id,@Valid CustumerDTO objDTO) {
		objDTO.setId(id);
		Custumer oldObj = findById(id);
		CPFvalidateAndEmail(objDTO);
		oldObj = new Custumer(objDTO);
		return repository.save(oldObj);
	}
	
	public void delet(Integer id) {
		Custumer obj = findById(id);
		
		if(obj.getCalled().size() > 0) {
			throw new DataIntegrityViolationException("This client can't be deleted because he has tasks opened!");
		}
		repository.deleteById(id);
	}
	
	private void CPFvalidateAndEmail(CustumerDTO objDTO) {
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
