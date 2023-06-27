package com.dantas.helpdesk.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.dantas.helpdesk.domain.Client;
import com.dantas.helpdesk.domain.People;
import com.dantas.helpdesk.domain.dtos.ClientDTO;
import com.dantas.helpdesk.domain.repositories.ClientRepository;
import com.dantas.helpdesk.domain.repositories.PeopleRepository;
import com.dantas.helpdesk.services.exceptions.DataIntegrityViolationException;
import com.dantas.helpdesk.services.exceptions.ObjectNotFoundException;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repository;
	
	@Autowired
	private PeopleRepository peopleRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	public Client findById(Integer id) {
		Optional<Client> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found! Id: "+ id));
	}
	
	public List<Client> findAll(){
		return repository.findAll();
	}

	public Client create(ClientDTO objDTO) {
		objDTO.setId(null);
		objDTO.setPassword(encoder.encode(objDTO.getPassword()));
		CPFvalidateAndEmail(objDTO);
		Client newObj = new Client(objDTO);
		return repository.save(newObj);
	}
	
	public Client update(Integer id,@Valid ClientDTO objDTO) {
		objDTO.setId(id);
		Client oldObj = findById(id);
		CPFvalidateAndEmail(objDTO);
		oldObj = new Client(objDTO);
		return repository.save(oldObj);
	}
	
	public void delet(Integer id) {
		Client obj = findById(id);
		
		if(obj.getCalled().size() > 0) {
			throw new DataIntegrityViolationException("This client can't be deleted because he has tasks opened!");
		}
		repository.deleteById(id);
	}
	
	private void CPFvalidateAndEmail(ClientDTO objDTO) {
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
