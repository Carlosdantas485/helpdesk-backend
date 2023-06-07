package com.dantas.helpdesk.domain;

import java.util.ArrayList;
import java.util.List;

import com.dantas.helpdesk.domain.enums.Profile;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Tecnic extends People {
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@OneToMany(mappedBy = "tecnic")
	private List<Called> called = new ArrayList<>();

	public Tecnic() {
		super();
	}

	public Tecnic(Integer id, String name, String cpf, String email, String password) {
		super(id, name, cpf, email, password);
	}

	public List<Called> getCalled() {
		return called;
	}

	public void setCalled(List<Called> called) {
		this.called = called;
	}
	
	
}