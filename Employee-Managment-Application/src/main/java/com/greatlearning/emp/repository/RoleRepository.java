package com.greatlearning.emp.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greatlearning.emp.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
	
	//Role findRoleByName(String name);

	

}
