package com.ds.glitchreporter.dto.request;

import jakarta.validation.constraints.NotBlank;

/**
 * Data Transfer Object (DTO) for representing a login request in the GlitchReporter application.
 * This class is used to transfer login credentials, including the username and password, for user authentication.
 */

public class LoginRequestDTO {
	@NotBlank
  private String username;

	@NotBlank
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}