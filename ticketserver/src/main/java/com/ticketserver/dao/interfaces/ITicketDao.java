package com.ticketserver.dao.interfaces;

import java.util.List;

import com.ticketserver.model.Ticket;

public interface ITicketDao {
	Ticket addTicket(Ticket ticket);
	List<Ticket> getTickets();
	List<Ticket> getTicketsById(Long id);
}
