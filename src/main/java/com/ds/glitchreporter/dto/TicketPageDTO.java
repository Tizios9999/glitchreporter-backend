package com.ds.glitchreporter.dto;

import java.util.List;

import com.ds.glitchreporter.dto.response.TicketPreviewDTO;

/**
 * Data Transfer Object (DTO) for representing a page of tickets in the GlitchReporter application.
 * This class is used to transfer information about a page of tickets, including the total number of tickets
 * and a list of ticket previews, between different parts of the application.
 */

public class TicketPageDTO {
    
	/**
     * The total number of tickets available.
     * Used to calculate the total number of pages along with the page size.
     */
	private long totalTickets;
    
	/**
     * The list of ticket previews on the page, represented as TicketPreviewDTO objects.
     */
	private List<TicketPreviewDTO> ticketList;

    public TicketPageDTO() {
    	
    }

	public long getTotalTickets() {
		return totalTickets;
	}

	public void setTotalTickets(long totalTickets) {
		this.totalTickets = totalTickets;
	}

	public List<TicketPreviewDTO> getTicketList() {
		return ticketList;
	}

	public void setTicketList(List<TicketPreviewDTO> ticketList) {
		this.ticketList = ticketList;
	}

	@Override
	public String toString() {
		return "TicketPageDTO [totalTickets=" + totalTickets + ", ticketList=" + ticketList + "]";
	}
    
    
}
