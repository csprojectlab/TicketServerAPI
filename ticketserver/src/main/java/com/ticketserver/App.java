package com.ticketserver;

import java.io.File;

import java.io.FileInputStream;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ticketserver.hibernate.HibernateUtils;

/**
 * Hello world! Again.
 *
 */
public class App {
	private static SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
	public static void main(String[] args) {		

	}
	
	public void blobCode() {
		File file = new File("F:\\NodeProject\\spriteAnimation\\image\\horse.png");
		byte[] bfile = new byte[(int)file.length()];
		try {
			FileInputStream input = new FileInputStream(file);
			input.read(bfile);
			input.close();
		} catch (Exception e) {
			System.out.println("ERROR");
		}
////		Book book = new Book();
//		book.setName("FIRST BOOK");
//		book.setImage(bfile);
		
		Session session = sessionFactory.openSession();
		try {
			Transaction t = session.beginTransaction();
//			session.save(book);
			t.commit();
			session.close();
		} catch (Exception e) {
			System.out.println("Error saving to database");
		}
	}
}
