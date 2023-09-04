package com.ds.glitchreporter.dto.response;

import java.util.Date;
import java.util.List;

public class JwtResponseDTO {
  private String token;
  private String type = "Bearer";
  private Long id;
  private String username;
  private String email;
  private List<String> roles;
  private Date expiration; 

  public JwtResponseDTO(String accessToken, Long id, String username, String email, List<String> roles, Date expiration) {
    this.token = accessToken;
    this.id = id;
    this.username = username;
    this.email = email;
    this.roles = roles;
    this.expiration = expiration;
  }

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
