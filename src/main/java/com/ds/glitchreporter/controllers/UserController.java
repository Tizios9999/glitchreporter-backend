package com.ds.glitchreporter.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ds.glitchreporter.dto.RoleUpdateDTO;
import com.ds.glitchreporter.models.ERole;
import com.ds.glitchreporter.models.User;
import com.ds.glitchreporter.payload.response.MessageResponse;
import com.ds.glitchreporter.repository.UserRepository;
import com.ds.glitchreporter.services.UserService;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private UserService userService;

    @GetMapping("/getall")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> allUsers = userRepository.findAll();
        
        List<User> activeUsers = new ArrayList<>();
        
        for (User user : allUsers) {
        	if (!user.isDeleted()) {
        		activeUsers.add(user);
        	}
        }
        
        return ResponseEntity.ok(activeUsers);
    }
    
    @PutMapping("/changerole/{userId}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> changeUserRole(@PathVariable Long userId, @RequestBody RoleUpdateDTO roleUpdate) {
        try {
        	ERole newRole = ERole.valueOf(roleUpdate.getNewRoleString());
            userService.changeUserRole(userId, newRole);
            return ResponseEntity.ok(new MessageResponse("User role updated successfully!"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new MessageResponse("Error updating user role"));
        }
    }
    
    @DeleteMapping("/{userId}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> deleteUser(@PathVariable Long userId) {
        try {
            userService.deleteUser(userId);
            return ResponseEntity.ok(new MessageResponse("User deleted successfully!"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new MessageResponse("Error updating user role"));
        }
    }
}
