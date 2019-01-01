package com.ticketserver.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="Comment")
@Table(name="comment")
public class Comment {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(name="author", nullable=false)
	private String author;
	@Column(name="comment", nullable=false)
	private String comment;
	@Temporal(TemporalType.DATE)
	@Column(name="commented_on")
	private Date date;
	@ManyToOne(
			fetch=FetchType.LAZY
			)
	private Ticket ticket;
	
	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(!(o instanceof Comment)) return false;
		return (id != null) && (id.equals(((Comment)o).id));
	}
	@Override
	public int hashCode() {
		return 31;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Ticket getTicket() {
		return ticket;
	}
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	
}
