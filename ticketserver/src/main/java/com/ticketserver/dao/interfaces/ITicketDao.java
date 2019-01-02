package com.ticketserver.dao.interfaces;

import java.util.List;

import com.ticketserver.model.Ticket;

public interface ITicketDao {
	Ticket addTicket(Ticket ticket);

	List<Ticket> getTickets();

	List<Ticket> getTicketsById(Long id);

	Ticket getUniqueTicket(Long id);

	Ticket assignTicket(long ticketId, String ownedBy);
	
	List<Ticket> paginatedTickets(int start, int pageSize);
	
	List<Ticket> paginatedTickets(int userId, int start, int pageSize);
}
