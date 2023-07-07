package com.ds.glitchreporter.models;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "statuses", 
    uniqueConstraints = { 
      @UniqueConstraint(columnNames = "status"),
    })
public class Status {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @NotBlank
  @Size(max = 30)
  private String status;

  @Size(max = 6)
  private String primaryColorCode;
  
  @Size(max = 6)
  private String secondaryColorCode;

  private Set<Status> statuses = new HashSet<>();

  public Status() {
  }

  public Status(String status, String primaryColorCode, String secondaryColorCode) {
    this.status = status;
    this.primaryColorCode = primaryColorCode;
    this.secondaryColorCode = secondaryColorCode;
  }
  
  // Getters and setters

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
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
