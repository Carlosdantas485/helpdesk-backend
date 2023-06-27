package com.dantas.helpdesk.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.dantas.helpdesk.domain.People;
import com.dantas.helpdesk.domain.Employee;
import com.dantas.helpdesk.domain.dtos.EmployeeDTO;
import com.dantas.helpdesk.domain.repositories.PeopleRepository;
import com.dantas.helpdesk.domain.repositories.EmployeeRepository;
import com.dantas.helpdesk.services.exceptions.DataIntegrityViolationException;
import com.dantas.helpdesk.services.exceptions.ObjectNotFoundException;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repository;

	@Autowired
	private PeopleRepository peopleRepository;

	@Autowired
	private BCryptPasswordEncoder encoder;

	public Employee findById(Integer id) {
		Optional<Employee> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found! Id: " + id));
	}

	public List<Employee> findAll() {
		return repository.findAll();
	}

	public Employee create(EmployeeDTO objDTO) {
		objDTO.setId(null);
		objDTO.setPassword(encoder.encode(objDTO.getPassword()));
		CPFvalidateAndEmail(objDTO);
		Employee newObj = new Employee(objDTO);
		return repository.save(newObj);
	}

	public Employee update(Integer id, @Valid EmployeeDTO objDTO) {
		objDTO.setId(id);
		Employee oldObj = findById(id);
		CPFvalidateAndEmail(objDTO);
		oldObj = new Employee(objDTO);
		return repository.save(oldObj);
	}

	public void delet(Integer id) {
		Employee obj = findById(id);
		if (obj.getTiket().size() > 0) {
			throw new DataIntegrityViolationException("This tecnic can't be deleted because he has tasks opened!");
		}
		repository.deleteById(id);
	}

	private void CPFvalidateAndEmail(EmployeeDTO objDTO) {
		Optional<People> obj = peopleRepository.findByCpf(objDTO.getCpf());

		if (obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("CPF already exists!");
		}

		obj = peopleRepository.findByEmail(objDTO.getEmail());

		if (obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("Email already exists!");
		}
	}

}
