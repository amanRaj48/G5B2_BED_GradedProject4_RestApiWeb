package com.greatlearning.emp.service;

import com.greatlearning.emp.model.Role;

public interface RoleService {
	
	Role createRole(Role role);
	
	Role getRoleById(int id);
	
	Role findRoleByName(String name);

}
