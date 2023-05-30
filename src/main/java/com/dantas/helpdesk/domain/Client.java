package com.dantas.helpdesk.domain;

import java.util.ArrayList;
import java.util.List;

import com.dantas.helpdesk.domain.enums.Profile;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class Client extends People {
	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy = "client")
	private List<Called> called = new ArrayList<>();

	public Client() {
		super();
		addProfiles(Profile.CLIENT);
	}

	public Client(Integer id, String name, String cpf, String email, String password) {
		super(id, name, cpf, email, password);
		addProfiles(Profile.CLIENT);
	}

	public List<Called> getCalled() {
		return called;
	}

	public void setCalled(List<Called> called) {
		this.called = called;
	}
	

}
