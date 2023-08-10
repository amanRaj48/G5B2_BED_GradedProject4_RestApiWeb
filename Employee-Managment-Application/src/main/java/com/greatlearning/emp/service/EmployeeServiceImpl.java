package com.greatlearning.emp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.emp.model.Employee;
import com.greatlearning.emp.repository.EmployeeJpaRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService  {
	
	@Autowired
	private final EmployeeJpaRepository employeeRepository;
	
	public EmployeeServiceImpl(EmployeeJpaRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}


	@Override
	public List<Employee> viewAllEmployees() {
		List<Employee> employees = this.employeeRepository.findAll();
		return employees;
	}

	@Override
	public Employee createEmployee(Employee employee) {
		return this.employeeRepository.save(employee);
	}

	@Override
	public Employee updateEmployee(long id, Employee employee) {
		Optional<Employee> employee1 = this.employeeRepository.findById(id);
		if(employee1.isPresent()) {
			Employee tempEmployee = employee1.get();
			tempEmployee.setFirstName(employee.getFirstName());
			tempEmployee.setLastName(employee.getLastName());
			tempEmployee.setEmail(employee.getEmail());
			return employeeRepository.save(tempEmployee);
		}
		throw new IllegalArgumentException("Invalid id passed");
	}

	@Override
	public void deleteEmployee(long id) {
		this.employeeRepository.deleteById(id);
		
	}


	@Override
	public Employee findEmployeeById(long id) {
		Optional<Employee> optonalEmployee = this.employeeRepository.findById(id);
		return optonalEmployee.orElseThrow();
	}


	@Override
	public Employee findEmployeeByFirstName(String firstName) {
		
		return this.employeeRepository.findByFirstNameLike(firstName);
	}


	@Override
	public List<Employee> findAllEmployeeByFirstNameAsc() {
		List<Employee> employees1 = this.employeeRepository.findAllByOrderByFirstNameAsc();
		return employees1;
	}


	@Override
	public List<Employee> findAllEmployeeByFirstNameDesc() {
		List<Employee> employees2 = this.employeeRepository.findAllByOrderByFirstNameDesc();
		return employees2;
	}

}
