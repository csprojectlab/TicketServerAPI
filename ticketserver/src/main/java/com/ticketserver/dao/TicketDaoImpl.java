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

	
}
