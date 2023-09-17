package com.ds.glitchreporter.models;

import jakarta.persistence.*;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * Represents a status in the GlitchReporter application.
 */

@Entity
@Table(name = "statuses", 
    uniqueConstraints = { 
      @UniqueConstraint(columnNames = "name"),
    })
public class Status {
	
  /**
   * The unique identifier of the status.
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  /**
   * The name of the status.
   */
  @NotBlank
  @Size(max = 30)
  private String name;
  
  /**
   * The text color HEX code associated with the status.
   */
  @Size(max = 6)
  @Column(name = "text_color")
  private String textColorCode;

  /**
   * The background color HEX code associated with the status.
   */
  @Size(max = 6)
  @Column(name = "bg_color")
  private String bgColorCode;
  
  /**
   * Indicates whether the ticket status is open or closed.
   */
  @Column(name = "is_open")
  private Boolean isOpen;

  public Status() {
  }

  public Status(String name, String textColorCode, String bgColorCode, Boolean isOpen) {
    this.name = name;
    this.textColorCode = textColorCode;
    this.bgColorCode = bgColorCode;
    this.isOpen = isOpen;
  }
  
  // Getters and setters

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTextColorCode() {
		return textColorCode;
	}
	
	public void setTextColorCode(String textColorCode) {
		this.textColorCode = textColorCode;
	}
	
	public String getBgColorCode() {
		return bgColorCode;
	}
	
	public void setBgColorCode(String bgColorCode) {
		this.bgColorCode = bgColorCode;
	}
	
	public Boolean getIsOpen() {
		return isOpen;
	}

	public void setIsOpen(Boolean isOpen) {
		this.isOpen = isOpen;
	}
  
   
}
