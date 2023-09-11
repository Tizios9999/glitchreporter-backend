package com.ds.glitchreporter.security.services;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.ds.glitchreporter.models.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * UserDetailsImpl implements the UserDetails interface, representing a custom user details class
 * used for authentication and authorization purposes.
 */

public class UserDetailsImpl implements UserDetails {
  private static final long serialVersionUID = 1L;

  private Long id;

  private String username;

  private String email;

  @JsonIgnore
  private String password;
  
  private boolean deleted;

  private Collection<? extends GrantedAuthority> authorities;

  /**
   * Constructor to create a UserDetailsImpl object.
   * @param id The user's ID
   * @param username The user's username
   * @param email The user's email
   * @param password The user's password (not exposed with @JsonIgnore)
   * @param authorities The user's granted authorities
   * @param deleted Whether the user is deleted or not
   */
  
  public UserDetailsImpl(Long id, String username, String email, String password,
      Collection<? extends GrantedAuthority> authorities, boolean deleted) {
    this.id = id;
    this.username = username;
    this.email = email;
    this.password = password;
    this.authorities = authorities;
    this.deleted = deleted;
  }

  /**
   * Build a UserDetailsImpl object from a User entity.
   * @param user The User entity
   * @return UserDetailsImpl representing the User entity
   */
  
  public static UserDetailsImpl build(User user) {
    List<GrantedAuthority> authorities = user.getRoles().stream()
        .map(role -> new SimpleGrantedAuthority(role.getName().name()))
        .collect(Collectors.toList());

    return new UserDetailsImpl(
        user.getId(), 
        user.getUsername(), 
        user.getEmail(),
        user.getPassword(), 
        authorities,
        user.isDeleted());
  }
  
  /**
   * Get the roles associated with the user.
   * @return List of roles as strings
   */
  
  public List<String> getRoles() {
	    return authorities.stream()
	        .map(GrantedAuthority::getAuthority)
	        .collect(Collectors.toList());
	  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities;
  }

  public Long getId() {
    return id;
  }

  public String getEmail() {
    return email;
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return username;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return !deleted;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    UserDetailsImpl user = (UserDetailsImpl) o;
    return Objects.equals(id, user.id);
  }
}
