package com.sanjib.spring.mysql.api.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sanjib.spring.mysql.api.dto.TicketDTO;
import com.sanjib.spring.mysql.api.model.Ticket;

public interface TicketDao extends JpaRepository<Ticket, Long>{

	List<TicketDTO> saveAll(List<TicketDTO> ticketDTOlist);

}
