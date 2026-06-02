package com.sanjib.spring.mysql.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sanjib.spring.mysql.api.dto.TicketDTO;
import com.sanjib.spring.mysql.api.model.Ticket;
import com.sanjib.spring.mysql.api.serviceImpl.TicketServiceImpl;

@RestController
@RequestMapping("/ticket")
public class TicketController {

	@Autowired
	private TicketServiceImpl ticketServiceImpl;
	
	private TicketController(TicketServiceImpl service) {
		this.ticketServiceImpl = service;
	}
	
	public Ticket createTicket(Ticket t ) {

		return ticketServiceImpl.createTicket(t);
			
	}
	
	@PutMapping("/updateTicket")
	public String updateTicketFare(@RequestBody Ticket tic) {
		
		return ticketServiceImpl.updateTicketFare(tic);
	}
	
	@PostMapping(value = "/bookTickets")
	public ResponseEntity<List<TicketDTO>> bookTicket(@RequestBody List<TicketDTO> ticketDTO){
		
		return ResponseEntity.ok(ticketServiceImpl.bookTicket(ticketDTO));
		
	}
	
	@GetMapping(value ="/getTickets")
	public List<Ticket> getTickets(){
		return ticketServiceImpl.getTickets();
	}
	
	
	@DeleteMapping("/deleteTicket")
	public String deleteTicket(@RequestBody Ticket ticket) throws Exception {
		return ticketServiceImpl.deleteTicket(ticket);
	}
	
	@DeleteMapping("/deleteTicketById/{id}")
	public String delteTicketById(@PathVariable("id") Long id) {
		return ticketServiceImpl.deleteTicketById(id);
	}
	
}
