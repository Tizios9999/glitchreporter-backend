package com.ds.glitchreporter.models;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "priorities", 
    uniqueConstraints = { 
      @UniqueConstraint(columnNames = "priority"),
    })
public class Priority {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  @Size(max = 20)
  private String priority;

  @Size(max = 6)
  private String primaryColorCode;
  
  @Size(max = 6)
  private String secondaryColorCode;

  private Set<Priority> priorities = new HashSet<>();

  public Priority() {
  }

  public Priority(String priority, String primaryColorCode, String secondaryColorCode) {
    this.priority = priority;
    this.primaryColorCode = primaryColorCode;
    this.secondaryColorCode = secondaryColorCode;
  }
  
  // Getters and setters

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getPriority() {
	return priority;
}

public void setPriority(String priority) {
	this.priority = priority;
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
