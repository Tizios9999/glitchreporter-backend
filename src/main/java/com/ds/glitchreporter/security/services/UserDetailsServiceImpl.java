package com.ds.glitchreporter.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ds.glitchreporter.models.User;

import com.ds.glitchreporter.repository.UserRepository;

/**
 * UserDetailsServiceImpl is a service class that implements the UserDetailsService
 * interface. It is responsible for loading user details from the database during authentication.
 */

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
  @Autowired
  UserRepository userRepository;

  /**
   * Loads user details by their username.
   * @param username The username of the user to load
   * @return UserDetails object representing the user
   * @throws UsernameNotFoundException Thrown if the user is not found
   */
  
  @Override
  @Transactional
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepository.findByUsername(username)
        .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

    return UserDetailsImpl.build(user);
  }

}
