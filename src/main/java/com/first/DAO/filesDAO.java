package com.first.DAO;

import java.security.PublicKey;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.SharedSessionContract;
import org.hibernate.cfg.Configuration;

import com.first.entity.Files;

public class filesDAO {

	private static SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
			.addAnnotatedClass(Files.class).buildSessionFactory();

	public void addFileDetails(Files file) {
		try (Session session = factory.getCurrentSession();) {

			session.beginTransaction();
			session.persist(file);
			session.getTransaction().commit();

		}

	}

	public List<Files> listing() {
		try (Session session = factory.getCurrentSession();) {
			session.beginTransaction();
			List<Files> files = session.createQuery("from files").getResultList();
			session.getTransaction().commit();
			return files;
		}
	}

	public static void updateInfo(String id, String caption, String label) {
		try (Session session = factory.getCurrentSession();) {
			Files file = new Files();
			session.beginTransaction();
			file = session.get(Files.class, id);
			if (!caption.isBlank()) {
				file.setCaption(caption);
			}
			if (!label.isBlank()) {
				file.setLabel(label);
			}
			session.getTransaction().commit();
		}

	}

	public static Files getImage(int id) {
		
		try (Session session = factory.getCurrentSession();) {

			session.beginTransaction();
			Files file=session.get(Files.class, id);
			return file;
			//session.getTransaction().commit();

		}
	}

	public static void deleteItem(int id) {
	
		try (Session session = factory.getCurrentSession();) {

			session.beginTransaction();
			Files file=session.get(Files.class, id);
			session.delete(file);
			session.getTransaction().commit();
		}
		
	}

}
