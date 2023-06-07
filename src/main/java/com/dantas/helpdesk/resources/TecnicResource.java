package com.dantas.helpdesk.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dantas.helpdesk.domain.Tecnic;
import com.dantas.helpdesk.domain.dtos.TecnicDTO;
import com.dantas.helpdesk.services.TecnicService;

@RestController
@RequestMapping(value = "/tecnics")
public class TecnicResource {
	
	//localhost:8080/tecnics/1
	
	@Autowired
	private TecnicService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<TecnicDTO> findById(@PathVariable Integer id) {
		Tecnic obj = service.findById(id);
		
		return ResponseEntity.ok().body(new TecnicDTO(obj));
	}
}
