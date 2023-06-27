package com.dantas.helpdesk.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.dantas.helpdesk.domain.dtos.EmployeeDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Employee extends People {
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@OneToMany(mappedBy = "employee")
	private List<Tiket> tiket = new ArrayList<>();

	public Employee() {
		super();
	}

	public Employee(Integer id, String name, String cpf, String email, String password) {
		super(id, name, cpf, email, password);
	}
	
	public Employee(EmployeeDTO obj) {
		super();
		this.id = obj.getId();
		this.name = obj.getName();
		this.cpf = obj.getCpf();
		this.email = obj.getEmail();
		this.password = obj.getPassword();
		this.profiles = obj.getProfiles().stream().map(x -> x.getCode()).collect(Collectors.toSet());
		this.dataCreatedUser = obj.getDataCreatedUser();
	}

	public List<Tiket> getTiket() {
		return tiket;
	}

	public void setTiket(List<Tiket> tiket) {
		this.tiket = tiket;
	}
	
	
}