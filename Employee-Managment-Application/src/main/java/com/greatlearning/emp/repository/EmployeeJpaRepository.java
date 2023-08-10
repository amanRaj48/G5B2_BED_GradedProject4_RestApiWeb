package com.greatlearning.emp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greatlearning.emp.model.Employee;

@Repository
public interface EmployeeJpaRepository extends JpaRepository<Employee, Long> {
	
	Employee findByFirstNameLike(String firstName);
	
	 List<Employee> findAllByOrderByFirstNameAsc();
	 List<Employee> findAllByOrderByFirstNameDesc();
	

}
