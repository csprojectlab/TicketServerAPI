package com.ticketserver.services;

import com.ticketserver.dao.TicketDaoImpl;
import com.ticketserver.dao.interfaces.ITicketDao;
import com.ticketserver.model.Ticket;
import com.ticketserver.services.interfaces.ITicketService;

public class TicketServiceImpl implements ITicketService {
	private ITicketDao ticketDao = new TicketDaoImpl();

	@Override
	public Ticket addTicket(Ticket ticket) {
		
		return null;
	}
}
