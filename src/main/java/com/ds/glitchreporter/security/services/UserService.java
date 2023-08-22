package com.ds.glitchreporter.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ds.glitchreporter.models.ERole;
import com.ds.glitchreporter.models.Role;
import com.ds.glitchreporter.models.User;
import com.ds.glitchreporter.repository.RoleRepository;
import com.ds.glitchreporter.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;

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

        user.getRoles().clear(); // Rimuovi tutti i ruoli precedenti
        user.getRoles().add(role); // Aggiungi il nuovo ruolo
        userRepository.save(user);
    }
}