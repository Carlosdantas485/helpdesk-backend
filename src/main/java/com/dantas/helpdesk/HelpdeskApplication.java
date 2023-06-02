package com.dantas.helpdesk;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dantas.helpdesk.domain.Called;
import com.dantas.helpdesk.domain.Client;
import com.dantas.helpdesk.domain.Tecnic;
import com.dantas.helpdesk.domain.enums.Priority;
import com.dantas.helpdesk.domain.enums.Profile;
import com.dantas.helpdesk.domain.enums.Status;
import com.dantas.helpdesk.domain.repositories.CalledRepository;
import com.dantas.helpdesk.domain.repositories.ClientRepository;
import com.dantas.helpdesk.domain.repositories.TecnicRepository;

@SpringBootApplication
public class HelpdeskApplication implements CommandLineRunner {
	
	@Autowired
	private TecnicRepository tecnicoRepository;
	
	@Autowired
	private ClientRepository clienteRepository;
	
	@Autowired
	private CalledRepository calledRepository;
 
	public static void main(String[] args) {
		SpringApplication.run(HelpdeskApplication.class, args);
	}
 
	@Override
	public void run(String... args) throws Exception {
		
		Tecnic tec1 = new Tecnic(null, "Carlos Dantas", "13220629784", "carlos@gmail.com", "Test123*");
		tec1.addProfiles(Profile.ADMIN);
		
		Client cli1 = new Client(null, "Thiago Mello", "13220629734", "linux@gmail.com", "Test123*");
		
		Called c1 = new Called(null, Priority.MEDIUM, Status.INPROGRESS, "Called 01", "First Calles", tec1, cli1);
	
		tecnicoRepository.saveAll(Arrays.asList(tec1));
		clienteRepository.saveAll(Arrays.asList(cli1));
		calledRepository.saveAll(Arrays.asList(c1));
	
	
	}
 
}
