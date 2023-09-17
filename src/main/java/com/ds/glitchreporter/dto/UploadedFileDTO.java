package com.ds.glitchreporter.dto;

import com.ds.glitchreporter.models.UploadedFile;

/**
 * Data Transfer Object (DTO) for representing an uploaded file in the GlitchReporter application.
 * This class is used to transfer information about an uploaded file, including its unique identifier, name, and file path,
 * between different parts of the application.
 */

public class UploadedFileDTO {
	
	private Long id;
	private String name;
	private String path;
	
	public UploadedFileDTO(String name, String path) {
		this.name = name;
		this.path = path;
	}
	
	public UploadedFileDTO(UploadedFile uploadedFile) {
		this.id = uploadedFile.getId();
		this.name = uploadedFile.getName();
		this.path = uploadedFile.getPath();
	}
	
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

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public String toString() {
		return "UploadedFileDTO [name=" + name + ", path=" + path + "]";
	}

	
	
}
