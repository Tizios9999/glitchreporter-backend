package com.ds.glitchreporter.dto;

public class UploadedFileDTO {
	
	private String name;
	private String path;
	
	public UploadedFileDTO(String name, String path) {
		this.name = name;
		this.path = path;
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

}
