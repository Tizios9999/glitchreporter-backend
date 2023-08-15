package com.ds.glitchreporter.payload.request;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FilterParameters {

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
