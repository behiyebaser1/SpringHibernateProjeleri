package com.behiye.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.behiye.entity.Ogretmen;
import com.behiye.entity.OgretmenDetay;

public class HibernateOneToOne {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Ogretmen.class).addAnnotatedClass(OgretmenDetay.class).buildSessionFactory();

		// create session
		Session session = sessionFactory.getCurrentSession();

		OgretmenDetay ogrDty = new OgretmenDetay("java", "sineme", "http://google.com3", "http://face.com");

		Ogretmen ogr = new Ogretmen(ogrDty, "Omer", "karakas", "omerkarakas@hotmail4");

		session.beginTransaction();

		session.save(ogr);
		// session.save(ogrDty);

		session.getTransaction().commit();
		session.close();
	}

}
