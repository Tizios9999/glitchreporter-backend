package com.ds.glitchreporter.dto.response;

/**
 * Data Transfer Object (DTO) for representing a response message in the GlitchReporter application.
 * This class is used to transfer simple messages as responses, typically for user feedback or status updates.
 */

public class MessageResponseDTO {
	  private String message;

	  public MessageResponseDTO(String message) {
	    this.message = message;
	  }

	  public String getMessage() {
	    return message;
	  }

	  public void setMessage(String message) {
	    this.message = message;
	  }
	}
