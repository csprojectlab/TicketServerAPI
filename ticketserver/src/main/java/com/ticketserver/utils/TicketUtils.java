package com.ticketserver.utils;

import com.ticketserver.dto.TicketDto;
import com.ticketserver.model.Ticket;

public class TicketUtils {
	// GENERATES DTO FOR A TICKET. COMMENTS ARE NOT INCLUDED.
	public static TicketDto generateTicketDto(Ticket ticket) {
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
}
