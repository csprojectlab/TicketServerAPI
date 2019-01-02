package com.ticketserver.services.interfaces;

import java.util.List;

import com.ticketserver.dto.CommentDto;
import com.ticketserver.dto.TicketDto;
import com.ticketserver.model.Ticket;

public interface ITicketService {
	Ticket addTicket(Ticket ticket);
	List<TicketDto> getTickets();
	List<TicketDto> getTicketById(int id);
	CommentDto addComment(CommentDto comment);
	List<CommentDto> getComments(int ticketId);
}
