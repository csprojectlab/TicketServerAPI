package com.ticketserver.dao;

import java.util.ArrayList;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.ticketserver.dao.interfaces.ITicketDao;
import com.ticketserver.hibernate.HibernateUtils;
import com.ticketserver.model.Ticket;

public class TicketDaoImpl implements ITicketDao {
	private SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

	@Override
	public Ticket addTicket(Ticket ticket) {
		try {
			Session session = this.sessionFactory.openSession();
			session.beginTransaction();
			session.persist(ticket);
			session.getTransaction().commit();
			session.close();
		} catch (HibernateException cause) {
			System.out.println(cause);
		}
		return ticket;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Ticket> getTickets() {
		List<Ticket> tickets = new ArrayList<>();
		try {
			Session session = this.sessionFactory.openSession();
			session.beginTransaction();
			String queryString = "from Ticket";
			tickets = (List<Ticket>) session.createQuery(queryString).list();
			session.getTransaction().commit();
			session.close();
		} catch (HibernateException cause) {
			System.out.println(cause);
		}
		return tickets;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Ticket> getTicketsById(Long id) {
		List<Ticket> tickets = new ArrayList<>();
		try {
			Session session = this.sessionFactory.openSession();
			session.beginTransaction();
			String queryString = "from Ticket where userId=:id";
			tickets = (List<Ticket>) session.createQuery(queryString)
											 .setParameter("id", id.intValue()).list();
			session.getTransaction().commit();
			session.close();
		} catch (HibernateException cause) {
			System.out.println(cause);
		}
		return tickets;
	}

	@Override
	public Ticket getUniqueTicket(Long id) {
		Ticket ticket = null;
		try {
			Session session = this.sessionFactory.openSession();
			session.beginTransaction();
			String queryString = "from Ticket where id=:id";
			ticket = (Ticket)session.createQuery(queryString)
									.setParameter("id", id.longValue()).uniqueResult();
			session.getTransaction().commit();
			session.close();
			System.out.println(ticket);
		} catch (HibernateException cause) {
			System.out.println(cause);
		}
		return ticket;
	}
}
