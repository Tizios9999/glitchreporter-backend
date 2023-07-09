package com.ds.glitchreporter.models;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "priorities", 
    uniqueConstraints = { 
      @UniqueConstraint(columnNames = "name"),
    })
public class Priority {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @NotBlank
  @Size(max = 20)
  private String name;

  @Size(max = 6)
  @Column(name = "text_color_code")
  private String textColorCode;
  
  @Size(max = 6)
  @Column(name = "bg_color_code")
  private String bgColorCode;
  
  private Integer level;
  

  private Set<Priority> priorities = new HashSet<>();

  public Priority() {
  }

  public Priority(String name, String textColorCode, String bgColorCode, Integer level) {
    this.name = name;
    this.textColorCode = textColorCode;
    this.bgColorCode = bgColorCode;
    this.level = level;
  }
  
  // Getters and setters

	public int getId() {
		return id;
	}
	
	public void setId(Integer id) {
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

	public Set<Priority> getPriorities() {
		return priorities;
	}
	
	public void setPriorities(Set<Priority> priorities) {
		this.priorities = priorities;
	}
	  
   
}
