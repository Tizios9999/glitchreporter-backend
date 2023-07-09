package com.ds.glitchreporter.dto;

import java.util.List;

import com.ds.glitchreporter.models.Priority;
import com.ds.glitchreporter.models.Status;
import com.ds.glitchreporter.models.Topic;

public class MetadataDTO {

	private List<Topic> topics;
    private List<Priority> priorities;
    private List<Status> statuses;
    
	public MetadataDTO(List<Topic> topics, List<Priority> priorities, List<Status> statuses) {
		this.topics = topics;
		this.priorities = priorities;
		this.statuses = statuses;
	}

	public List<Topic> getTopics() {
		return topics;
	}

	public void setTopics(List<Topic> topics) {
		this.topics = topics;
	}

	public List<Priority> getPriorities() {
		return priorities;
	}

	public void setPriorities(List<Priority> priorities) {
		this.priorities = priorities;
	}

	public List<Status> getStatuses() {
		return statuses;
	}

	public void setStatuses(List<Status> statuses) {
		this.statuses = statuses;
	}

	
    
}
