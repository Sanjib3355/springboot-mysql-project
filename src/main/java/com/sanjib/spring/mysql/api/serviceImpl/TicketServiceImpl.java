package com.sanjib.spring.mysql.api.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sanjib.spring.mysql.api.dao.TicketDao;
import com.sanjib.spring.mysql.api.dto.TicketDTO;
import com.sanjib.spring.mysql.api.model.Ticket;
import com.sanjib.spring.mysql.api.service.TicketService;

public class TicketServiceImpl implements TicketService {

		@Autowired
		private TicketDao ticketDao;

		private TicketServiceImpl(TicketDao ticketDao) {

			this.ticketDao = ticketDao;
		}

		//BOOK MULTIPLE TICKETS
		public List<TicketDTO> bookTicket(List<TicketDTO> ticketList) {
			
			Ticket t = new Ticket();
			TicketDTO td = new TicketDTO(t);
			
			td.setAmount(t.getAmount());
			td.setCategory(t.getCategory());;
			td.setUserId(t.getId());
			
			//ticketDao.saveAll(ticketList);

			return ticketDao.saveAll(ticketList);
		}
		
		//BOOK A NEW TICKET
		public Ticket createTicket(Ticket t) {

			Ticket ticket = new Ticket();

			ticket.setId(t.getId());
			ticket.setCategory(t.getCategory());
			ticket.setAmount(t.getAmount());

			return ticketDao.save(ticket);

		}

		//UPDATE A TICKET
		public String updateTicketFare(Ticket tic) {
			
	        if (tic.getId() ==  null){
				
		    throw new IllegalArgumentException("Id is null");
				
			}
	 
	        else if(!ticketDao.existsById(tic.getId())) {
				return "Ticket With Id " + tic.getId() + " doesn't exists";
			}
			
			
			ticketDao.save(tic);

			return "Ticket Updated Successfully for ID : " + tic.getId();

		}

		//GET A TICKEY BY IT'S ID
		public Ticket getTicketById(Long id) {

			return ticketDao.findById(id).get();
		}

	    //GET ALL TICKETS
		public List<Ticket> getTickets() {

			return ticketDao.findAll();
		}
		
		//DELETING A TICKET BY IT'S ID
		public String deleteTicketById(Long id) {
			if (!ticketDao.existsById(id)) {
				//throw new Exception();
				return "Ticket Id doesn't exists";
			}
			ticketDao.deleteById(id);

			return "Ticket Deleted For Id : " + id;
		}

		//DELETE A TICKET
		public String deleteTicket(Ticket ticket) {
			if (!ticketDao.existsById(ticket.getId())) {
				//throw new Exception();
				return "Ticket with given Id doesn't exists";
			}
			else 
			ticketDao.delete(ticket);

			return "Ticket Deleted Successfully";
		}

	}
