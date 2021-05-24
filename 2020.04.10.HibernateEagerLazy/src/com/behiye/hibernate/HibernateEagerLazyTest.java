package com.behiye.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.behiye.entity.Kurs;
import com.behiye.entity.Ogretmen;
import com.behiye.entity.OgretmenDetay;

public class HibernateEagerLazyTest {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Ogretmen.class).addAnnotatedClass(OgretmenDetay.class).addAnnotatedClass(Kurs.class)
				.buildSessionFactory();

		// create session
		Session session = sessionFactory.getCurrentSession();
		/*
		 * Ogretmen ogr = new Ogretmen(null, "ayse", "can", "ac5@gmail"); OgretmenDetay
		 * ogrDty = new OgretmenDetay("java", "sinema", "ws", "fb_p");
		 * 
		 * ogr.addKurs(new Kurs("Javae", 600, ogr)); ogr.addKurs(new Kurs("DBe", 400,
		 * null)); ogr.addKurs(new Kurs("WEBe", 500, null));
		 */
		session.beginTransaction();
		// session.save(ogr);

		Ogretmen ali = session.get(Ogretmen.class, 25);

		System.out.println(ali);
		System.out.println(ali.getKurslar());

		session.getTransaction().commit();

		session.close();

		System.out.println(ali);
		System.out.println(ali.getKurslar());

	}

}
