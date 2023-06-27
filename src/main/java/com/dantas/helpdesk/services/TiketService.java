package com.dantas.helpdesk.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dantas.helpdesk.domain.Tiket;
import com.dantas.helpdesk.domain.Custumer;
import com.dantas.helpdesk.domain.Tecnic;
import com.dantas.helpdesk.domain.dtos.TiketDTO;
import com.dantas.helpdesk.domain.enums.Priority;
import com.dantas.helpdesk.domain.enums.Status;
import com.dantas.helpdesk.domain.repositories.TiketRepository;
import com.dantas.helpdesk.services.exceptions.ObjectNotFoundException;

@Service
public class TiketService {
	
	@Autowired
	private TiketRepository repository;
	
	@Autowired
	private TecnicService tecnicService;
	
	@Autowired
	private CustumerService clientService;
	
	public Tiket findById(Integer id) {
		Optional<Tiket> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found! ID:" + id));
		
	}
	
	public List<Tiket> findAll(){
		return repository.findAll();
	}
	
	public Tiket create(@Valid TiketDTO objDTO) {
		
		return repository.save(newCalled(objDTO));
	}
	
	public Tiket update(Integer id, @Valid TiketDTO objDTO) {
		objDTO.setId(id);
		Tiket oldObj = findById(id);
		oldObj = newCalled(objDTO);
		
		return repository.save(oldObj);
	}
	
	private Tiket newCalled(TiketDTO obj) {
		
		Tecnic tecnic = tecnicService.findById(obj.getTecnic());
		Custumer client = clientService.findById(obj.getClient());
		Tiket called = new Tiket();
		
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
