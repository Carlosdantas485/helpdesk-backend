package com.dantas.helpdesk.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.dantas.helpdesk.domain.dtos.CustumerDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Custumer extends People {
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@OneToMany(mappedBy = "client")
	private List<Tiket> calleds = new ArrayList<>();

	public Custumer() {
		super();
	}

	public Custumer(Integer id, String name, String cpf, String email, String password) {
		super(id, name, cpf, email, password);
	}
	
	public Custumer(CustumerDTO obj) {
		super();
		this.id = obj.getId();
		this.name = obj.getName();
		this.cpf = obj.getCpf();
		this.email = obj.getEmail();
		this.password = obj.getPassword();
		this.profiles = obj.getProfiles().stream().map(x -> x.getCode()).collect(Collectors.toSet());
		this.dataCreatedUser = obj.getDataCreatedUser();
	}

	public List<Tiket> getCalled() {
		return calleds;
	}

	public void setCalled(List<Tiket> called) {
		this.calleds = called;
	}
	

}
