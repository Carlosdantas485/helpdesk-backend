package com.dantas.helpdesk.domain;

import java.util.ArrayList;
import java.util.List;

import com.dantas.helpdesk.domain.enums.Profile;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class Client extends People {
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@OneToMany(mappedBy = "client")
	private List<Called> calleds = new ArrayList<>();

	public Client() {
		super();
	}

	public Client(Integer id, String name, String cpf, String email, String password) {
		super(id, name, cpf, email, password);
	}

	public List<Called> getCalled() {
		return calleds;
	}

	public void setCalled(List<Called> called) {
		this.calleds = called;
	}
	

}
