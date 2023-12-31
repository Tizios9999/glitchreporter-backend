package com.ds.glitchreporter.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ds.glitchreporter.models.ERole;
import com.ds.glitchreporter.models.Role;
import com.ds.glitchreporter.models.User;
import com.ds.glitchreporter.repository.RoleRepository;
import com.ds.glitchreporter.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;

/**
 * Service used to retrieve the list of users,
 * change their role, or delete them.
 */

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private RoleRepository roleRepository;

    public void changeUserRole(Long userId, ERole newRole) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new EntityNotFoundException("User not found"));

        Role role = roleRepository.findByName(newRole)
            .orElseThrow(() -> new EntityNotFoundException("Role not found"));

        user.getRoles().clear();
        user.getRoles().add(role); 
        userRepository.save(user);
    }

	public void deleteUser(Long userId) {
		User user = userRepository.findById(userId)
	            .orElseThrow(() -> new EntityNotFoundException("User not found"));
		
		user.setDeleted(true);
		userRepository.save(user);
	}
    
}