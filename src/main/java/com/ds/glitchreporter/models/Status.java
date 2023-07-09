package com.ds.glitchreporter.models;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "statuses", 
    uniqueConstraints = { 
      @UniqueConstraint(columnNames = "name"),
    })
public class Status {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @NotBlank
  @Size(max = 30)
  private String name;

  @Size(max = 6)
  private String primaryColorCode;
  
  @Size(max = 6)
  private String secondaryColorCode;

  private Set<Status> statuses = new HashSet<>();

  public Status() {
  }

  public Status(String name, String primaryColorCode, String secondaryColorCode) {
    this.name = name;
    this.primaryColorCode = primaryColorCode;
    this.secondaryColorCode = secondaryColorCode;
  }
  
  // Getters and setters

	public Integer getId() {
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
	
	public Set<Status> getStatuses() {
		return statuses;
	}
	
	public void setStatuses(Set<Status> statuses) {
		this.statuses = statuses;
	}
  
   
}
