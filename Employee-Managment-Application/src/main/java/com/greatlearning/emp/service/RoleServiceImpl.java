package com.greatlearning.emp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.greatlearning.emp.model.Role;
import com.greatlearning.emp.repository.RoleRepository;

import java.util.Optional; // Import this

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role getRoleById(int id) {
        Optional<Role> roleOptional = roleRepository.findById(id);
        return roleOptional.orElse(null); // Return null if optional is empty
    }

	@Override
	public Role findRoleByName(String name) {
		
		return this.findRoleByName(name);
	}
}
