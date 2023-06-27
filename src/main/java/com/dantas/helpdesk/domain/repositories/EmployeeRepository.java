package com.dantas.helpdesk.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dantas.helpdesk.domain.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
