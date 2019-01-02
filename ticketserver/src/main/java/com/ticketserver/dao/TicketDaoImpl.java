package com.ticketserver.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;

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

	@Override
	public Ticket assignTicket(long ticketId, String ownedBy) {
		Ticket ticket = null;
		Session session = null;
		try {
			session = this.sessionFactory.openSession();
			session.beginTransaction();
			String queryString = "from Ticket where id=:id";
			ticket = (Ticket)session.createQuery(queryString)
									.setParameter("id", ticketId).uniqueResult();
			if(ticket == null)
				throw new NullPointerException();
			ticket.setOwnedBy(ownedBy);
			ticket.setStatus("ASSIGNED");			
		} catch (HibernateException cause) {
			System.out.println(cause);
		} finally {
			session.getTransaction().commit();
			session.close();
		}
		return ticket;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Ticket> paginatedTickets(int start, int pageSize) {
		List<Ticket> tickets = null;
		Session session = null;
		try {
			session = this.sessionFactory.openSession();
			session.beginTransaction();
			Query hql = session.createQuery("from Ticket")
								.setFirstResult(start)
								.setMaxResults(pageSize);
			tickets = (List<Ticket>) hql.list();
		} catch (HibernateException cause) {
			System.out.println(cause);
		} finally {
			session.getTransaction().commit();
			session.close();
		}
		return tickets;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Ticket> paginatedTickets(int userId, int start, int pageSize) {
		List<Ticket> tickets = null;
		Session session = null;
		try {
			session = this.sessionFactory.openSession();
			session.beginTransaction();
			Query hql = session.createQuery("from Ticket where userId=:id")
								.setParameter("id", userId)
								.setFirstResult(start)
								.setMaxResults(pageSize);
			tickets = (List<Ticket>) hql.list();
		} catch (HibernateException cause) {
			System.out.println(cause);
		} finally {
			session.getTransaction().commit();
			session.close();
		}
		return tickets;
	}

	@Override
	public long getTicketCount() {
		long count = 0;
		Session session = null;
		try {
			session = this.sessionFactory.openSession();
			session.beginTransaction();
			Criteria criteriaCount = session.createCriteria(Ticket.class);
			criteriaCount.setProjection(Projections.rowCount());
			count = (long) criteriaCount.uniqueResult();
		} catch (HibernateException cause) {
			System.out.println(cause);
		} finally {
			session.getTransaction().commit();
			session.close();
		}
		return count;
	}

	@Override
	public long getTicketCount(int userId) {
		long count = 0;
		Session session = null;
		try {
			session = this.sessionFactory.openSession();
			session.beginTransaction();
			Query query = session.createQuery(
					"select count(*) from Ticket where userId=:id")
					.setParameter("id", userId);
		    count = (long) query.uniqueResult();
		} catch (HibernateException cause) {
			System.out.println(cause);
		} finally {
			session.getTransaction().commit();
			session.close();
		}
		return count;
	}
}
