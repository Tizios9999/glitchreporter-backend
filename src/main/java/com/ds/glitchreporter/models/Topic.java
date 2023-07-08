package com.ds.glitchreporter.models;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "topics", 
    uniqueConstraints = { 
      @UniqueConstraint(columnNames = "name"),
    })
public class Topic {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  @Size(max = 40)
  private String name;

  private Set<Topic> topics = new HashSet<>();

  public Topic() {
  }

  public Topic(String name) {
    this.name = name;
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
	
	public Set<Topic> getTopics() {
		return topics;
	}
	
	public void setTopics(Set<Topic> topics) {
		this.topics = topics;
	}

}