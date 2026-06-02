package com.sanjib.spring.mysql.api.dto;

import com.sanjib.spring.mysql.api.model.Ticket;

public class TicketDTO {

	
	private Long userId;
	private String category;
	private double amount;
	
	public TicketDTO(Ticket ticket) {
		
		this.userId = ticket.getId();
		this.category = ticket.getCategory();
		this.amount = ticket.getAmount();
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
	
}
