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
  private String primaryColorCode;
  
  @Size(max = 6)
  private String secondaryColorCode;

  private Set<Priority> priorities = new HashSet<>();

  public Priority() {
  }

  public Priority(String name, String primaryColorCode, String secondaryColorCode) {
    this.name = name;
    this.primaryColorCode = primaryColorCode;
    this.secondaryColorCode = secondaryColorCode;
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

	public String getPrimaryColorCode() {
		return primaryColorCode;
	}
	
	public void setPrimaryColorCode(String primaryColorCode) {
		this.primaryColorCode = primaryColorCode;
	}
	
	public String getSecondaryColorCode() {
		return secondaryColorCode;
	}
	
	public void setSecondaryColorCode(String secondaryColorCode) {
		this.secondaryColorCode = secondaryColorCode;
	}
	
	public Set<Priority> getPriorities() {
		return priorities;
	}
	
	public void setPriorities(Set<Priority> priorities) {
		this.priorities = priorities;
	}
	  
   
}
