package com.ticketserver.resources;

import com.ticketserver.services.TicketServiceImpl;
import com.ticketserver.services.interfaces.ITicketService;

public class TicketResource {
	private ITicketService ticketService = new TicketServiceImpl();
}
