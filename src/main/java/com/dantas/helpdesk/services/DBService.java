package com.dantas.helpdesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.dantas.helpdesk.domain.Tiket;
import com.dantas.helpdesk.domain.Custumer;
import com.dantas.helpdesk.domain.Employee;
import com.dantas.helpdesk.domain.enums.Priority;
import com.dantas.helpdesk.domain.enums.Profile;
import com.dantas.helpdesk.domain.enums.Status;
import com.dantas.helpdesk.domain.repositories.TiketRepository;
import com.dantas.helpdesk.domain.repositories.CustumerRepository;
import com.dantas.helpdesk.domain.repositories.EmployeeRepository;

@Service
public class DBService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private CustumerRepository custumerRepository;

	@Autowired
	private TiketRepository tiketRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;

	public void DBInstance() {

		Employee t1 = new Employee(
				null,
				"Valdir Cezar",
				"144.785.300-84",
				"carlosdantas485@gmail.com",
				encoder.encode("123"
			));
		t1.addProfiles(Profile.ADMIN);

		Custumer c1 = new Custumer(null, "Betina Campos", "598.508.200-80", "(88) 98888-7777", encoder.encode("12344"));

		

		employeeRepository.saveAll(Arrays.asList(t1));
		custumerRepository.saveAll(Arrays.asList(c1));
		
		
		t1.addProfiles(Profile.ADMIN);
		
		Employee t2 = new Employee(null, "Linus Torvalds", "641.760.040-88", "carlitos.super.l@hotmail.com", encoder.encode("1234"));
		Employee t3 = new Employee(null, "Alan Turing", "332.040.820-83", "(88) 96345-9874", encoder.encode("12344"));
		Employee t4 = new Employee(null, "Richard Stallman", "756.192.280-96", "(88) 98745-8542", encoder.encode("12344"));
		Employee t5 = new Employee(null, "Tim Berners-Lee", "926.076.200-66", "(88) 98545-3685", encoder.encode("12344"));

		Custumer c2 = new Custumer(null, "Galileu Galilei", "089.637.320-70", "cliente@email.com", encoder.encode("1234"));
		Custumer c3 = new Custumer(null, "Isaac Newton", "422.876.280-88", "(88) 95555-6541", encoder.encode("12344"));
		Custumer c4 = new Custumer(null, "Marie Curie", "420.724.490-57", "(88) 96666-8523", encoder.encode("12344"));
		Custumer c5 = new Custumer(null, "Albert Einstein", "047.166.710-20", "(88) 98755-4412", encoder.encode("12344"));
		Custumer c6 = new Custumer(null, "Carlos Alberto Dantas", "04716671020", "Carlosdantas485@gmail.com", encoder.encode("12344"));
		
		Tiket os1 = new Tiket(null, Priority.HIGH, Status.INPROGRESS, "Trocar fonte do notebook", "dasdas", t2, c1);
		Tiket os2 = new Tiket(null, Priority.LOW, Status.INPROGRESS, "Trocar placa mãe", "asdasdas", t2, c1);
		Tiket os3 = new Tiket(null, Priority.HIGH, Status.INPROGRESS, "Formatar para linux", "", t3, c3);
		Tiket os4 = new Tiket(null, Priority.MEDIUM, Status.INPROGRESS, "Ativar antivirus", "", t3, c4);
		Tiket os5 = new Tiket(null, Priority.MEDIUM, Status.INPROGRESS, "Criar sistema full stack", "", t5, c5);
		Tiket os6 = new Tiket(null, Priority.LOW, Status.INPROGRESS, "Trocar pasta térmica", "", t4, c1);

		
		employeeRepository.saveAll(Arrays.asList(t1, t2, t3, t4, t5));
		custumerRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5,c6));
		tiketRepository.saveAll(Arrays.asList(os1, os2, os3, os4, os5, os6));
		

	}
}
