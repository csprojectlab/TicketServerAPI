package com.ticketserver.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.ticketserver.dto.AssignTicketDto;
import com.ticketserver.dto.CommentDto;
import com.ticketserver.dto.Entries;
import com.ticketserver.dto.PageSizeDto;
import com.ticketserver.dto.TicketDto;
import com.ticketserver.model.Ticket;
import com.ticketserver.services.TicketServiceImpl;
import com.ticketserver.services.interfaces.ITicketService;

@Path("/tickets")
public class TicketResource {
	private ITicketService ticketService = new TicketServiceImpl();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/count")
	public Response ticketCount() {
		Entries ent = this.ticketService.getTicketCount();
		return Response.status(Status.OK).entity(ent).build();
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/user/{userId}/count")
	public Response ticketCount(@PathParam("userId") int userId) {
		Entries ent = this.ticketService.getTicketCount(userId);
		return Response.status(Status.OK).entity(ent).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/user/{userId}/paginated")
	public Response paginatedTicketsByUserId(@PathParam("userId") int userId, PageSizeDto pageInfo) {
		List<TicketDto> paginatedTicketsByUserId = this.ticketService.paginatedTickets(userId, pageInfo);
		return Response.status(Status.OK).entity(paginatedTicketsByUserId).build();
	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/paginated")
	public Response paginatedTickets(PageSizeDto pageInfo) {
		List<TicketDto> paginatedTickets = this.ticketService.paginatedTickets(pageInfo);
		return Response.status(Status.OK).entity(paginatedTickets).build();
	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/assignticket")
	public Response assignTicket(AssignTicketDto assignTicketDto) {
		TicketDto ticketDto = this.ticketService.assignTicket(assignTicketDto);
		return Response.status(Status.OK).entity(ticketDto).build();
	}
	
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{ticketId}/comments")
	public Response getComments(@PathParam("ticketId") int id) {
		List<CommentDto> comments = this.ticketService.getComments(id);
		return Response.status(Status.OK).entity(comments).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/addcomment")
	public Response addComment(CommentDto comment) {
		CommentDto addedComment = this.ticketService.addComment(comment);
		return Response.status(Status.OK).entity(addedComment).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/user/{id}")
	public Response getTicketById(@PathParam("id") int id) {
		List<TicketDto> tickets = this.ticketService.getTicketById(id);
		return Response.status(Status.OK).entity(tickets).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTickets() {
		List<TicketDto> tickets = this.ticketService.getTickets();
		return Response.status(Status.OK).entity(tickets).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/addticket")
	public Response addTicket(Ticket ticket) {
		Ticket addedTicket = this.ticketService.addTicket(ticket);
		return Response.status(Status.OK).entity(addedTicket).build();
	}

}
