package com.greatlearning.emp.service;

import java.util.List;

import com.greatlearning.emp.model.Employee;

public interface EmployeeService {
	
	List<Employee> viewAllEmployees();
	
	Employee createEmployee(Employee employee);
	
	Employee updateEmployee(long id,Employee employee);
	
	void deleteEmployee(long id);
	
	Employee findEmployeeById(long id);
	
	Employee findEmployeeByFirstName(String firstName);
	
	List<Employee> findAllEmployeeByFirstNameAsc();
	
	List<Employee> findAllEmployeeByFirstNameDesc();

}
