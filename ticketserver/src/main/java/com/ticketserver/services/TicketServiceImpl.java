package com.ticketserver.services;

import java.util.ArrayList;
import java.util.List;

import com.ticketserver.dao.CommentDaoImpl;
import com.ticketserver.dao.TicketDaoImpl;
import com.ticketserver.dao.interfaces.ICommentDao;
import com.ticketserver.dao.interfaces.ITicketDao;
import com.ticketserver.dto.AssignTicketDto;
import com.ticketserver.dto.CommentDto;
import com.ticketserver.dto.Entries;
import com.ticketserver.dto.PageSizeDto;
import com.ticketserver.dto.TicketDto;
import com.ticketserver.model.Comment;
import com.ticketserver.model.Ticket;
import com.ticketserver.services.interfaces.ITicketService;
import com.ticketserver.utils.CommentUtils;
import com.ticketserver.utils.TicketUtils;

public class TicketServiceImpl implements ITicketService {
	private ITicketDao ticketDao = new TicketDaoImpl();
	private ICommentDao commentDao = new CommentDaoImpl();

	@Override
	public Ticket addTicket(Ticket ticket) {
		Ticket addedTicket = null;
		addedTicket = this.ticketDao.addTicket(ticket);
		return addedTicket;
	}

	@Override
	public List<TicketDto> getTickets() {
		List<Ticket> tickets = this.ticketDao.getTickets(); // GET ALL TICKETS.
		List<TicketDto> ticketsDto = new ArrayList<>();
		for (Ticket ticket : tickets)
			ticketsDto.add(TicketUtils.generateTicketDto(ticket)); // GENERATE CORRESPONDNG DTO
		return ticketsDto;
	}

	@Override
	public List<TicketDto> getTicketById(int id) {
		List<Ticket> tickets = this.ticketDao.getTicketsById(new Long(id));
		List<TicketDto> ticketsDto = new ArrayList<>();
		for (Ticket ticket : tickets)
			ticketsDto.add(TicketUtils.generateTicketDto(ticket));
		return ticketsDto;
	}

	@Override
	public CommentDto addComment(CommentDto comment) {
		CommentDto addedComment = this.commentDao.addComment(comment);
		return addedComment;
	}

	@Override
	public List<CommentDto> getComments(int ticketId) {
		List<Comment> comments = this.commentDao.getComments((long) ticketId);
		if (comments == null)
			return null;
		List<CommentDto> commentsDto = new ArrayList<>();
		for (Comment comment : comments) {
			commentsDto.add(CommentUtils.generateCommentDto(comment));
		}
		return commentsDto;
	}

	@Override
	public TicketDto assignTicket(AssignTicketDto assignTicketDto) {
		Ticket updtTicket = this.ticketDao.assignTicket((long) assignTicketDto.getTicketId(), assignTicketDto.getOwnedBy());
		TicketDto ticketDto = TicketUtils.generateTicketDto(updtTicket);
		return ticketDto;
	}

	@Override
	public List<TicketDto> paginatedTickets(PageSizeDto pageInfo) {
		List<Ticket> tickets = this.ticketDao.paginatedTickets(pageInfo.getStart(), pageInfo.getPageSize());
		List<TicketDto> ticketsDto = new ArrayList<>();
		for (Ticket ticket : tickets) 
			ticketsDto.add(TicketUtils.generateTicketDto(ticket));
		return ticketsDto;
	}

	@Override
	public List<TicketDto> paginatedTickets(int userId, PageSizeDto pageInfo) {
		List<Ticket> tickets = this.ticketDao.paginatedTickets(userId, pageInfo.getStart(), pageInfo.getPageSize());
		List<TicketDto> ticketsDto = new ArrayList<>();
		for (Ticket ticket : tickets) 
			ticketsDto.add(TicketUtils.generateTicketDto(ticket));
		return ticketsDto;
	}

	@Override
	public Entries getTicketCount() {
		long numberOfTickets = this.ticketDao.getTicketCount();
		Entries ent = new Entries();
		ent.setSize(numberOfTickets);
		return ent;
	}

	@Override
	public Entries getTicketCount(int userId) {
		long numberOfTickets = this.ticketDao.getTicketCount(userId);
		Entries ent = new Entries();
		ent.setSize(numberOfTickets);
		return ent;
	}

	

}
