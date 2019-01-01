package com.ticketserver.dao.interfaces;

import java.util.List;

import com.ticketserver.dto.CommentDto;
import com.ticketserver.model.Ticket;

public interface ITicketDao {
	Ticket addTicket(Ticket ticket);
	List<Ticket> getTickets();
	List<Ticket> getTicketsById(Long id);
	Ticket getUniqueTicket(Long id);
}
