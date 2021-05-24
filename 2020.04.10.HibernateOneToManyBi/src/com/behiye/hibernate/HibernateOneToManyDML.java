package com.behiye.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.behiye.entity.Kurs;
import com.behiye.entity.Ogretmen;
import com.behiye.entity.OgretmenDetay;

public class HibernateOneToManyDML {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Ogretmen.class).addAnnotatedClass(OgretmenDetay.class).addAnnotatedClass(Kurs.class)
				.buildSessionFactory();

		// create session
		Session session = sessionFactory.getCurrentSession();

		Ogretmen ogr = new Ogretmen(null, "ali", "can", "ac1@gmail");
		ogr.addKurs(new Kurs("Java1", 600, ogr));
		ogr.addKurs(new Kurs("DB1", 400, null));
		ogr.addKurs(new Kurs("WEB1", 500, null));

		session.beginTransaction();

		/*
		 * List<Kurs> kurslar =
		 * session.createQuery("from Kurs where ogretmen=20").getResultList();
		 * 
		 * for (Kurs dept : kurslar) { System.out.println(dept.getKursAdi()); }
		 */

		Ogretmen ogr1 = session.get(Ogretmen.class, 20);

		Kurs k = ogr1.getKurslar().get(0);
		ogr1.getKurslar().remove(0);
		session.remove(k);

		Kurs k2 = ogr1.getKurslar().get(0);
		k2.setKursAdi("DB4");
		session.save(k2);

		session.save(ogr1);

		session.getTransaction().commit();

		session.close();

	}

}
