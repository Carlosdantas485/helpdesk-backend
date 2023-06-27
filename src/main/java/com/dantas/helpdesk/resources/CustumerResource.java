package com.dantas.helpdesk.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

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

import com.dantas.helpdesk.domain.Custumer;
import com.dantas.helpdesk.domain.dtos.CustumerDTO;
import com.dantas.helpdesk.services.CustumerService;

@RestController
@RequestMapping(value = "/client")
public class CustumerResource {
	
	@Autowired
	private CustumerService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<CustumerDTO> findById(@PathVariable Integer id) {
		Custumer obj = service.findById(id);
		return ResponseEntity.ok().body(new CustumerDTO(obj));
	}
	
	@GetMapping
	public ResponseEntity<List<CustumerDTO>> findAll(){ 
		List<Custumer> list = service.findAll();
		List<CustumerDTO> listDTO = list.stream().map(obj -> new CustumerDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@PostMapping
	public ResponseEntity<CustumerDTO> create(@Valid @RequestBody CustumerDTO objDTO){
		
		Custumer newObj = service.create(objDTO);
		URI	uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<CustumerDTO> update(@PathVariable Integer id, @Valid @RequestBody CustumerDTO objDTO){
		Custumer obj = service.update(id, objDTO);
		return ResponseEntity.ok().body(new CustumerDTO(obj));
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<CustumerDTO> delete(@PathVariable Integer id){
		service.delet(id);
		return ResponseEntity.noContent().build();
	}
	
}