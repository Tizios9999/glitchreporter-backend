package com.ds.glitchreporter.dto;

import java.util.List;

public class TicketPageDTO {
    
	private long totalTickets;
    
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
