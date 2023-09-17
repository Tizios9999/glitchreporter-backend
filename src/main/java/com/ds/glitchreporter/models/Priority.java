package com.ds.glitchreporter.models;

import jakarta.persistence.*;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * Represents a priority level for support tickets in the GlitchReporter application.
 */

@Entity
@Table(name = "priorities")
public class Priority {
	
  /**
   * The unique identifier of the priority level.
   */	
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  /**
   * The name of the priority level. Must not be blank and should have a maximum length of 20 characters.
   */  
  @NotBlank
  @Size(max = 20)
  private String name;

  /**
   * The text color HEX code associated with this priority level.
   */
  @Size(max = 6)
  @Column(name = "text_color")
  private String textColorCode;

  /**
   * The background color HEX code associated with this priority level.
   */  
  @Size(max = 6)
  @Column(name = "bg_color")
  private String bgColorCode;
  
  /**
   * The priority level's ranking.
   */
  @Column(name = "level")
  private Integer level;

  public Priority() {
  }

  public Priority(String name, String textColorCode, String bgColorCode, Integer level) {
    this.name = name;
    this.textColorCode = textColorCode;
    this.bgColorCode = bgColorCode;
    this.level = level;
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
	
	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "Priority [id=" + id + ", name=" + name + ", textColorCode=" + textColorCode + ", bgColorCode="
				+ bgColorCode + ", level=" + level + "]";
	}
	
}
