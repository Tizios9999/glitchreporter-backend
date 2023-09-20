package com.ds.glitchreporter.controllers;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ds.glitchreporter.dto.request.AuthenticationRequestDTO;
import com.ds.glitchreporter.dto.request.LoginRequestDTO;
import com.ds.glitchreporter.dto.response.JwtResponseDTO;
import com.ds.glitchreporter.dto.response.MessageResponseDTO;
import com.ds.glitchreporter.models.ERole;
import com.ds.glitchreporter.models.Role;
import com.ds.glitchreporter.models.User;
import com.ds.glitchreporter.repository.RoleRepository;
import com.ds.glitchreporter.repository.UserRepository;
import com.ds.glitchreporter.security.jwt.JwtUtils;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
  @Autowired
  AuthenticationManager authenticationManager;

  @Autowired
  UserRepository userRepository;

  @Autowired
  RoleRepository roleRepository;

  @Autowired
  PasswordEncoder encoder;

  @Autowired
  JwtUtils jwtUtils;

  //Endpoint for user authentication
  @PostMapping("/signin")
  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequestDTO loginRequest) {

	  try {
		  Authentication authentication = authenticationManager.authenticate(
			      new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

			  SecurityContextHolder.getContext().setAuthentication(authentication);
			  JwtResponseDTO jwtResponse = jwtUtils.generateJwtResponse(authentication);

			  return ResponseEntity.ok(jwtResponse);
	  } catch (BadCredentialsException e) {
      return ResponseEntity
          .badRequest()
          .body(new MessageResponseDTO("Invalid credentials. Please check your username and password."));
	  } catch (UsernameNotFoundException e) {
	  // Same error message for bad credentials as a security measure.
      return ResponseEntity
          .badRequest()
          .body(new MessageResponseDTO("Invalid credentials. Please check your username and password."));
	  } catch (Exception e) {
      // Other exceptions
      String errorMessage = e.getMessage();
      return ResponseEntity
          .badRequest()
          .body(new MessageResponseDTO("Error during login: " + errorMessage));
	  }
  }
	 

  @PostMapping("/signup")
  public ResponseEntity<?> registerUser(@Valid @RequestBody AuthenticationRequestDTO signUpRequest) {
    if (userRepository.existsByUsername(signUpRequest.getUsername())) {
      return ResponseEntity
          .badRequest()
          .body(new MessageResponseDTO("Error: Username is already taken!"));
    }

    if (userRepository.existsByEmail(signUpRequest.getEmail())) {
      return ResponseEntity
          .badRequest()
          .body(new MessageResponseDTO("Error: Email is already in use!"));
    }

    // Create new user's account
    User user = new User(signUpRequest.getUsername(), 
               signUpRequest.getEmail(),
               encoder.encode(signUpRequest.getPassword()));

    Set<String> strRoles = signUpRequest.getRole();
    Set<Role> roles = new HashSet<>();

    if (strRoles == null) {
      Role userRole = roleRepository.findByName(ERole.ROLE_USER)
          .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
      roles.add(userRole);
    } else {
      strRoles.forEach(role -> {
        switch (role) {
        case "admin":
          Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
          roles.add(adminRole);

          break;
        case "agent":
          Role agentRole = roleRepository.findByName(ERole.ROLE_AGENT)
              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
          roles.add(agentRole);

          break;
        default:
          Role userRole = roleRepository.findByName(ERole.ROLE_USER)
              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
          roles.add(userRole);
        }
      });
    }

    user.setRoles(roles);
    userRepository.save(user);

    Authentication authentication = authenticationManager.authenticate(
    	      new UsernamePasswordAuthenticationToken(signUpRequest.getUsername(), signUpRequest.getPassword()));

    	  SecurityContextHolder.getContext().setAuthentication(authentication);
    	  JwtResponseDTO jwtResponse = jwtUtils.generateJwtResponse(authentication);

    	  return ResponseEntity.ok(jwtResponse);
  }
  
  //Endpoint for changing user password
  @PutMapping("/changepassword")
  public ResponseEntity<?> changePassword(@Valid @RequestBody AuthenticationRequestDTO changePasswordRequest) {
	
	String credentialsError = "Error: wrong username or password!"; // Generic as a security measure
	  
    if (!userRepository.existsByUsername(changePasswordRequest.getUsername())) {
      return ResponseEntity
          .badRequest()
          .body(new MessageResponseDTO(credentialsError));
    }

    // Find the user by username
    Optional<User> optUser = userRepository.findByUsername(changePasswordRequest.getUsername());
    User user = optUser.get();
    
    if (!user.getEmail().equals(changePasswordRequest.getEmail())) {
        return ResponseEntity
            .badRequest()
            .body(new MessageResponseDTO(credentialsError));
      }
    
    // Change the user's password
    user.setPassword(encoder.encode(changePasswordRequest.getPassword()));

    userRepository.save(user);
    
    return ResponseEntity.ok("Password changed successfully!");
  }
}