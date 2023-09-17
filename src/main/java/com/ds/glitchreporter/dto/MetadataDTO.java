package com.ds.glitchreporter.dto;

import java.util.List;

import com.ds.glitchreporter.models.Priority;
import com.ds.glitchreporter.models.Status;
import com.ds.glitchreporter.models.Topic;

/**
 * Data Transfer Object (DTO) for representing metadata in the GlitchReporter application.
 * This class is used to transfer metadata-related information between different parts of the application,
 * such as controllers, services, and views. Metadata includes topics, priorities, and statuses.
 */

public class MetadataDTO {

	private List<Topic> topics;
    private List<Priority> priorities;
    private List<Status> statuses;
    
    /**
     * Constructs a new MetadataDTO object with the provided lists of topics, priorities, and statuses.
     *
     * @param topics     A list of topics available in the application.
     * @param priorities A list of priorities available in the application.
     * @param statuses   A list of statuses available in the application.
     */
    
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
