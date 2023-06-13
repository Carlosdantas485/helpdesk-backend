package com.dantas.helpdesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dantas.helpdesk.domain.Called;
import com.dantas.helpdesk.domain.Client;
import com.dantas.helpdesk.domain.Tecnic;
import com.dantas.helpdesk.domain.enums.Priority;
import com.dantas.helpdesk.domain.enums.Profile;
import com.dantas.helpdesk.domain.enums.Status;
import com.dantas.helpdesk.domain.repositories.CalledRepository;
import com.dantas.helpdesk.domain.repositories.ClientRepository;
import com.dantas.helpdesk.domain.repositories.TecnicRepository;

@Service
public class DBService {

	@Autowired
	private TecnicRepository tecnicRepository;

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private CalledRepository calledRepository;

	public void DBInstance() {

		Tecnic t1 = new Tecnic(null, "Valdir Cezar", "144.785.300-84", "(88) 98888-8888", "12344");
		t1.addProfiles(Profile.ADMIN);

		Client c1 = new Client(null, "Betina Campos", "598.508.200-80", "(88) 98888-7777", "12344");

		

		tecnicRepository.saveAll(Arrays.asList(t1));
		clientRepository.saveAll(Arrays.asList(c1));
		
		
		t1.addProfiles(Profile.ADMIN);
		
		Tecnic t2 = new Tecnic(null, "Linus Torvalds", "641.760.040-88", "(88) 94545-4545", "12344");
		Tecnic t3 = new Tecnic(null, "Alan Turing", "332.040.820-83", "(88) 96345-9874", "12344");
		Tecnic t4 = new Tecnic(null, "Richard Stallman", "756.192.280-96", "(88) 98745-8542", "12344");
		Tecnic t5 = new Tecnic(null, "Tim Berners-Lee", "926.076.200-66", "(88) 98545-3685", "12344");

		Client c2 = new Client(null, "Galileu Galilei", "089.637.320-70", "(88) 97854-6985", "12344");
		Client c3 = new Client(null, "Isaac Newton", "422.876.280-88", "(88) 95555-6541", "12344");
		Client c4 = new Client(null, "Marie Curie", "420.724.490-57", "(88) 96666-8523", "12344");
		Client c5 = new Client(null, "Albert Einstein", "047.166.710-20", "(88) 98755-4412", "12344");
		
		Called os1 = new Called(null, Priority.HIGHT, Status.INPROGRESS, "Trocar fonte do notebook", "dasdas", t2, c1);
		Called os2 = new Called(null, Priority.LOW, Status.INPROGRESS, "Trocar placa mãe", "asdasdas", t2, c2);
		Called os3 = new Called(null, Priority.HIGHT, Status.INPROGRESS, "Formatar para linux", "", t3, c3);
		Called os4 = new Called(null, Priority.MEDIUM, Status.INPROGRESS, "Ativar antivirus", "", t3, c4);
		Called os5 = new Called(null, Priority.MEDIUM, Status.INPROGRESS, "Criar sistema full stack", "", t5, c5);
		Called os6 = new Called(null, Priority.LOW, Status.INPROGRESS, "Trocar pasta térmica", "", t4, c1);

		
		tecnicRepository.saveAll(Arrays.asList(t1, t2, t3, t4, t5));
		clientRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5));
		calledRepository.saveAll(Arrays.asList(os1, os2, os3, os4, os5, os6));
		

	}
}
