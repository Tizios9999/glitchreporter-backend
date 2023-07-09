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
  @Column(name = "text_color_code")
  private String textColorCode;
  
  @Size(max = 6)
  @Column(name = "bg_color_code")
  private String bgColorCode;

  private Set<Status> statuses = new HashSet<>();

  public Status() {
  }

  public Status(String name, String textColorCode, String bgColorCode) {
    this.name = name;
    this.textColorCode = textColorCode;
    this.bgColorCode = bgColorCode;
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
	
	public Set<Status> getStatuses() {
		return statuses;
	}
	
	public void setStatuses(Set<Status> statuses) {
		this.statuses = statuses;
	}
  
   
}
