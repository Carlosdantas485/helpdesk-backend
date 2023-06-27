package com.dantas.helpdesk.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.dantas.helpdesk.domain.Tiket;
import com.dantas.helpdesk.domain.dtos.TiketDTO;
import com.dantas.helpdesk.services.TiketService;

@RestController
@RequestMapping(value = "/called")
public class TiketResource {
	
	@Autowired
	private TiketService service;
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<TiketDTO> findById(@PathVariable Integer id){
		Tiket obj = service.findById(id);
		return ResponseEntity.ok().body(new TiketDTO(obj));
	}
	
	@GetMapping
	public ResponseEntity<List<TiketDTO>> findAll(){
		List<Tiket> list = service.findAll();
		List<TiketDTO> listDTO = list.stream().map(obj -> new TiketDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	
	@PostMapping
	public ResponseEntity<TiketDTO> create(@Valid @RequestBody TiketDTO objDTO){
		
		Tiket newObj = service.create(objDTO);
		URI	uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<TiketDTO> update(@PathVariable Integer id, @Valid @RequestBody TiketDTO objDTO){
		Tiket obj = service.update(id, objDTO);
		return ResponseEntity.ok().body(new TiketDTO(obj));
	} 
}
