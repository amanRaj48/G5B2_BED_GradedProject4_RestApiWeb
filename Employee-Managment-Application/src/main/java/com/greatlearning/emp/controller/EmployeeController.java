package com.greatlearning.emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.emp.model.Employee;
import com.greatlearning.emp.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping
	public List<Employee> viewAllEmployees(){
		return this.employeeService.viewAllEmployees();
	}
	
	@PostMapping
	public Employee createEmployee(@RequestBody Employee employee) {
		return this.employeeService.createEmployee(employee);
	}
	
	@PutMapping("/{id}")
	public Employee updateEmployee(@PathVariable("id") long id, @RequestBody Employee employee) {
		return this.employeeService.updateEmployee(id, employee);
	}
	
	@DeleteMapping("/{id}")
	public void deleteStudentById(@PathVariable("id") long id) {
		this.employeeService.deleteEmployee(id);
	}
	
	@GetMapping("/{id}")
	public Employee findEmployeeById(@PathVariable("id") long id) {
		return this.employeeService.findEmployeeById(id);
	}
	
	@GetMapping("/search/{firstName}")
	public Employee findEmployeeByFirstname(@PathVariable("firstName") String firstName) {
		return this.employeeService.findEmployeeByFirstName(firstName);
	}

	@GetMapping("/sort")
	public List<Employee> getAllEmployeesSortedByFirstName(@RequestParam("order") String order){
		
		if("asc".equalsIgnoreCase(order)) {
			return this.employeeService.findAllEmployeeByFirstNameAsc();
		}else if("desc".equalsIgnoreCase(order)) {
			return this.employeeService.findAllEmployeeByFirstNameDesc();
			
		} else {
			throw new IllegalArgumentException("Invalid order parameter: " + order);
		}
		
	}
	
	
	

}
