package com.ticketserver.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity(name="Ticket")
@Table(name="ticket")
public class Ticket {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(name="user_id", nullable=false)
	private int userId;
	@Column(name="type", nullable=false)
	private String type;
	@Column(name="priority", nullable=false)
	private String priority;
	@Column(name="message", nullable=false)
	private String message;
	@Column(name="status", nullable=false)
	private String status;
	@Column(name="owned_by")
	private String ownedBy;
	@Column(name="raised_by", nullable=false)
	private String raisedBy;
	@OneToMany(
			mappedBy="ticket", 
			cascade=CascadeType.ALL,
			orphanRemoval=true)
	@OrderBy("date desc")
	private List<Comment> comments = new ArrayList<>();
	
	public void addComment(Comment comment) {
		comments.add(comment);
		comment.setTicket(this);
	}
	
	public void removeComment(Comment comment) {
		comments.remove(comment);
		comment.setTicket(null);
	}
	
	@Override
	public String toString() {
		return this.userId + " : " + this.message + " : " + this.ownedBy;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getOwnedBy() {
		return ownedBy;
	}
	public void setOwnedBy(String ownedBy) {
		this.ownedBy = ownedBy;
	}
	public String getRaisedBy() {
		return raisedBy;
	}
	public void setRaisedBy(String raisedBy) {
		this.raisedBy = raisedBy;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
}
