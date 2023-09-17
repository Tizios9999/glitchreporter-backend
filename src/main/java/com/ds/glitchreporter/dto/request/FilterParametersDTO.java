package com.ds.glitchreporter.dto.request;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Data Transfer Object (DTO) for representing filter parameters used to filter tickets in the GlitchReporter application.
 * This class is used to transfer filtering criteria, such as priority and status IDs, from the frontend to the backend.
 */

public class FilterParametersDTO {

	@JsonProperty("priorityIds")
	private List<Long> priorityIds;
	
	@JsonProperty("statusIds")
    private List<Long> statusIds;
    
	public List<Long> getPriorityIds() {
		return priorityIds;
	}
	public void setPriorityIds(List<Long> priorityIds) {
		this.priorityIds = priorityIds;
	}
	public List<Long> getStatusIds() {
		return statusIds;
	}
	public void setStatusIds(List<Long> statusIds) {
		this.statusIds = statusIds;
	}
    
    
}
