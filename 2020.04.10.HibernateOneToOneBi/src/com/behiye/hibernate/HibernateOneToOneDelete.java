package com.behiye.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.behiye.entity.Ogretmen;
import com.behiye.entity.OgretmenDetay;

public class HibernateOneToOneDelete {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Ogretmen.class).addAnnotatedClass(OgretmenDetay.class).buildSessionFactory();

		// create session
		Session session = sessionFactory.getCurrentSession();

		session.beginTransaction();

		Ogretmen ogr = session.get(Ogretmen.class, 15);

		session.delete(ogr);
		// session.save(ogrDty);

		session.getTransaction().commit();
		session.close();
	}

}
