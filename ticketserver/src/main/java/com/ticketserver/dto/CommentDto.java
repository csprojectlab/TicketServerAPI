package com.ticketserver.dto;

public class CommentDto {
	private String author;
	private String comment;
	private int ticketId;
	private String date;
	
	public String toString() {
		return this.author + " : " + this.comment + " : " + this.ticketId;
	}
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getTicketId() {
		return ticketId;
	}
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	
}
