package com.dantas.helpdesk.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dantas.helpdesk.domain.Called;
import com.dantas.helpdesk.domain.Client;
import com.dantas.helpdesk.domain.Tecnic;
import com.dantas.helpdesk.domain.dtos.CalledDTO;
import com.dantas.helpdesk.domain.enums.Priority;
import com.dantas.helpdesk.domain.enums.Status;
import com.dantas.helpdesk.domain.repositories.CalledRepository;
import com.dantas.helpdesk.services.exceptions.ObjectNotFoundException;

@Service
public class CalledService {
	
	@Autowired
	private CalledRepository repository;
	
	@Autowired
	private TecnicService tecnicService;
	
	@Autowired
	private ClientService clientService;
	
	public Called findById(Integer id) {
		Optional<Called> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found! ID:" + id));
		
	}
	
	public List<Called> findAll(){
		return repository.findAll();
	}
	
	public Called create(@Valid CalledDTO objDTO) {
		
		return repository.save(newCalled(objDTO));
	}
	
	public Called update(Integer id, @Valid CalledDTO objDTO) {
		objDTO.setId(id);
		Called oldObj = findById(id);
		oldObj = newCalled(objDTO);
		
		return repository.save(oldObj);
	}
	
	private Called newCalled(CalledDTO obj) {
		
		Tecnic tecnic = tecnicService.findById(obj.getTecnic());
		Client client = clientService.findById(obj.getClient());
		Called called = new Called();
		
		if(obj.getId() != null) {
			called.setId(obj.getId());
		}
		
		if(obj.getStatus().equals(2)) {
			called.setCloseData(LocalDate.now());
		}
		
		called.setTecnic(tecnic);
		called.setClient(client);
		called.setPriority(Priority.toEnum(obj.getPriority()));
		called.setStatus(Status.toEnum(obj.getStatus()));
		called.setTitle(obj.getTitle());
		called.setObservation(obj.getObservation());
		
		return called;
	}

	


}
