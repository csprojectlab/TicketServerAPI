package com.ticketserver.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ticketserver.dao.interfaces.ICommentDao;
import com.ticketserver.dto.CommentDto;
import com.ticketserver.hibernate.HibernateUtils;
import com.ticketserver.model.Comment;
import com.ticketserver.model.Ticket;

public class CommentDaoImpl implements ICommentDao {
	private SessionFactory sessionFactory = HibernateUtils.getSessionFactory();	

	@Override
	public CommentDto addComment(CommentDto comment) {
		Comment c = new Comment();
		c.setAuthor(comment.getAuthor());
		c.setComment(comment.getComment());
		c.setDate(new Date());
		Ticket ticket = null;
		Session session = null;
		try {
			session = this.sessionFactory.openSession();
			session.beginTransaction();
			String queryString = "from Ticket where id=:id";
			ticket = (Ticket)session.createQuery(queryString)
									.setParameter("id", (long)comment.getTicketId()).uniqueResult();
			if(ticket == null)	
				throw new NullPointerException();
			ticket.addComment(c);
		} catch (HibernateException cause) {
			System.out.println(cause);
		} finally {
			session.getTransaction().commit();
			session.close();
		}
		return comment;
	}

	@Override
	public List<Comment> getComments(long ticketId) {
		Session session = null;
		Ticket ticket = null;
		List<Comment> comments = null;
		try {
			session = this.sessionFactory.openSession();
			session.beginTransaction();
			String queryString = "from Ticket where id=:id";
			ticket = (Ticket)session.createQuery(queryString)
									.setParameter("id", ticketId).uniqueResult();
			if(ticket == null)	
				throw new NullPointerException();
			ticket.getComments().size();	// TRIGGERING .
			comments = ticket.getComments();   // GET THE COMMENTS.
		} catch (HibernateException cause) {
			System.out.println(cause);
		} finally {
			session.getTransaction().commit();
			session.close();
		}
		return comments;
	}

}
