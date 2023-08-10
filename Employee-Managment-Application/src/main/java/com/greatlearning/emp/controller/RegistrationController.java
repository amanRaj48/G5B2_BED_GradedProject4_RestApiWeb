package com.greatlearning.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.emp.model.Role;
import com.greatlearning.emp.model.User;
import com.greatlearning.emp.service.RoleService;
import com.greatlearning.emp.service.UserService;

@RestController
@RequestMapping("/api/registration")
public class RegistrationController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/roles")
    public Role createRole(@RequestBody Role role) {
        return roleService.createRole(role);
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User user) {
        
        User user1 = new User(user.getUsername(), user.getPassword());
        String hashedPassword = passwordEncoder.encode(user.getPassword());
        user1.setPassword(hashedPassword);
        
        for (Role role : user.getRoles()) {
            Role role1 = roleService.getRoleById(role.getId());
            String preAddedRole = "ROLE_" + role1.getRole();
            role1.setRole(preAddedRole);
            user1.addRole(role1);
        }

        
        return userService.createUser(user1);
    }
}
