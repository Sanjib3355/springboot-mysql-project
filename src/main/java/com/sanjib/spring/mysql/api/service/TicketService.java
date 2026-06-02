package com.sanjib.spring.mysql.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.sanjib.spring.mysql.api.dao.TicketDao;
import com.sanjib.spring.mysql.api.dto.TicketDTO;
import com.sanjib.spring.mysql.api.model.Ticket;

import jakarta.transaction.Transactional;

@Service
@Component
public interface TicketService {

	//BOOK MULTIPLE TICKETS
	public List<TicketDTO> bookTicket(List<TicketDTO> ticketList);
	                                                   
	//BOOK A NEW TICKET
	public Ticket createTicket(Ticket t);

	//UPDATE A TICKET
	public String updateTicketFare(Ticket tic);
	

	//GET A TICKEY BY IT'S ID
	public Ticket getTicketById(Long id);

    //GET ALL TICKETS
	public List<Ticket> getTickets();
	
	//DELETING A TICKET BY IT'S ID
	public String deleteTicketById(Long id);
		

	//DELETE A TICKET
	public String deleteTicket(Ticket ticket);

}
