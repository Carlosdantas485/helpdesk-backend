package com.dantas.helpdesk.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.dantas.helpdesk.domain.Tecnic;
import com.dantas.helpdesk.domain.dtos.TecnicDTO;
import com.dantas.helpdesk.services.TecnicService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/tecnics")
public class TecnicResource {
	
	@Autowired
	private TecnicService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<TecnicDTO> findById(@PathVariable Integer id) {
		Tecnic obj = service.findById(id);
		return ResponseEntity.ok().body(new TecnicDTO(obj));
	}
	
	@GetMapping
	public ResponseEntity<List<TecnicDTO>> findAll(){ 
		List<Tecnic> list = service.findAll();
		List<TecnicDTO> listDTO = list.stream().map(obj -> new TecnicDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@PostMapping
	public ResponseEntity<TecnicDTO> create(@Valid @RequestBody TecnicDTO objDTO){
		
		Tecnic newObj = service.create(objDTO);
		URI	uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<TecnicDTO> update(@PathVariable Integer id, @Valid @RequestBody TecnicDTO objDTO){
		Tecnic obj = service.update(id, objDTO);
		return ResponseEntity.ok().body(new TecnicDTO(obj));
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<TecnicDTO> delete(@PathVariable Integer id){
		service.delet(id);
		return ResponseEntity.noContent().build();
	}
	
}