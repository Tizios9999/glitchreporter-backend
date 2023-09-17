package com.ds.glitchreporter.dto.response;

import java.util.Date;
import java.util.List;

/**
 * Data Transfer Object (DTO) for representing a response containing a JSON Web Token (JWT) in the GlitchReporter application.
 * This class is used to transfer information about the JWT, including the token itself, user details, roles, and token expiration.
 */

public class JwtResponseDTO {
	
  /**
   * The JSON Web Token (JWT) string.
   */
  private String token;
  
  /**
   * The type of token, typically "Bearer" for JWT.
   */ 
  private String type = "Bearer";
  

  /**
   * The user's unique identifier.
   */ 
  private Long id;
  
  /**
   * The username of the authenticated user.
   */  
  private String username;
  
  /**
   * The email address of the authenticated user.
   */  
  private String email;
  
  /**
   * The list of roles assigned to the authenticated user.
   */  
  private List<String> roles;
  
  /**
   * The expiration date and time of the JWT.
   */
  private Date expiration; 

  public JwtResponseDTO(String accessToken, Long id, String username, String email, List<String> roles, Date expiration) {
    this.token = accessToken;
    this.id = id;
    this.username = username;
    this.email = email;
    this.roles = roles;
    this.expiration = expiration;
  }

  // getters and setters
  
  public String getAccessToken() {
    return token;
  }

  public void setAccessToken(String accessToken) {
    this.token = accessToken;
  }

  public String getTokenType() {
    return type;
  }

  public void setTokenType(String tokenType) {
    this.type = tokenType;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public List<String> getRoles() {
    return roles;
  }
  
  public Date getExpiration() {
	return expiration;
  }

  public void setExpiration(Date expiration) {
	 this.expiration = expiration;
  }
}
