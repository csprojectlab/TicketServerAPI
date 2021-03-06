package com.ticketserver.services.interfaces;

import java.util.List;

import com.ticketserver.dto.AssignTicketDto;
import com.ticketserver.dto.CommentDto;
import com.ticketserver.dto.Entries;
import com.ticketserver.dto.PageSizeDto;
import com.ticketserver.dto.TicketDto;
import com.ticketserver.model.Ticket;

public interface ITicketService {
	Ticket addTicket(Ticket ticket);
	List<TicketDto> getTickets();
	List<TicketDto> getTicketById(int id);
	CommentDto addComment(CommentDto comment);
	List<CommentDto> getComments(int ticketId);
	TicketDto assignTicket(AssignTicketDto ticketDto);
	List<TicketDto> paginatedTickets(PageSizeDto pageSize);
	List<TicketDto> paginatedTickets(int userId, PageSizeDto pageSize);	
	Entries getTicketCount();
	Entries getTicketCount(int userId);
}
