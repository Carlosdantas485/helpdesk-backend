package com.dantas.helpdesk.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dantas.helpdesk.domain.Tiket;
import com.dantas.helpdesk.domain.Custumer;
import com.dantas.helpdesk.domain.Employee;
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
	private EmployeeService tecnicService;
	
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
		
		return repository.save(newTiket(objDTO));
	}
	
	public Tiket update(Integer id, @Valid TiketDTO objDTO) {
		objDTO.setId(id);
		Tiket oldObj = findById(id);
		oldObj = newTiket(objDTO);
		
		return repository.save(oldObj);
	}
	
	private Tiket newTiket(TiketDTO obj) {
		
		Employee employee = tecnicService.findById(obj.getEmployee());
		Custumer custumer = clientService.findById(obj.getCustumer());
		Tiket tiket = new Tiket();
		
		if(obj.getId() != null) {
			tiket.setId(obj.getId());
		}
		
		if(obj.getStatus().equals(2)) {
			tiket.setCloseData(LocalDate.now());
		}
		
		tiket.setEmployee(employee);
		tiket.setCustumer(custumer);
		tiket.setPriority(Priority.toEnum(obj.getPriority()));
		tiket.setStatus(Status.toEnum(obj.getStatus()));
		tiket.setTitle(obj.getTitle());
		tiket.setObservation(obj.getObservation());
		
		return tiket;
	}

	


}
