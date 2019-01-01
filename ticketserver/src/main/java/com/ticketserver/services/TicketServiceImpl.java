package com.ticketserver.services;

import java.util.ArrayList;
import java.util.List;

import com.ticketserver.dao.TicketDaoImpl;
import com.ticketserver.dao.interfaces.ITicketDao;
import com.ticketserver.dto.TicketDto;
import com.ticketserver.model.Ticket;
import com.ticketserver.services.interfaces.ITicketService;

public class TicketServiceImpl implements ITicketService {
	private ITicketDao ticketDao = new TicketDaoImpl();

	@Override
	public Ticket addTicket(Ticket ticket) {
		Ticket addedTicket = null;
		addedTicket = this.ticketDao.addTicket(ticket);
		return addedTicket;
	}

	@Override
	public List<TicketDto> getTickets() {
		List<Ticket> tickets = this.ticketDao.getTickets();   // GET ALL TICKETS.
		List<TicketDto> ticketsDto = new ArrayList<>();
		for(Ticket ticket : tickets) 
			ticketsDto.add(this.generateTicketDto(ticket));		// GENERATE CORRESPONDNG DTO
		return ticketsDto;
	}
	
	// GENERATES DTO FOR A TICKET. COMMENTS ARE NOT INCLUDED.
	private TicketDto generateTicketDto(Ticket ticket) {
		TicketDto dto = new TicketDto();
		dto.setUserId(ticket.getUserId());
		dto.setType(ticket.getType());
		dto.setStatus(ticket.getStatus());
		dto.setRaisedBy(ticket.getRaisedBy());
		dto.setPriority(ticket.getPriority());
		dto.setOwnedBy(ticket.getOwnedBy());
		dto.setMessage(ticket.getMessage());
		dto.setId(ticket.getId());
		return dto;
	}

	@Override
	public List<TicketDto> getTicketById(int id) {
		List<Ticket> tickets = this.ticketDao.getTicketsById(new Long(id));
		List<TicketDto> ticketsDto = new ArrayList<>();
		for (Ticket ticket : tickets)
			ticketsDto.add(this.generateTicketDto(ticket));
		return ticketsDto;
	}
}
