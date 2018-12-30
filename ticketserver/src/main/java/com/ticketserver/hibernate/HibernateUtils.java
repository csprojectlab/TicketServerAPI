package com.ticketserver.hibernate;


import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ticketserver.dao.Book;
import com.ticketserver.dao.Person;
import com.ticketserver.model.Comment;
import com.ticketserver.model.Ticket;

@SuppressWarnings("deprecation")
public class HibernateUtils {
	private static SessionFactory sessionFactory;

	static {
		try {
			sessionFactory = new Configuration().configure().addAnnotatedClass(Person.class)
					.addAnnotatedClass(Book.class)
					.addAnnotatedClass(Ticket.class)
					.addAnnotatedClass(Comment.class)
					.buildSessionFactory();
			System.out.println("created session factory");
		} catch (HibernateException cause) {
			System.out.println("Error Creating Session Factory");
			System.out.println(cause.getMessage());
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}

