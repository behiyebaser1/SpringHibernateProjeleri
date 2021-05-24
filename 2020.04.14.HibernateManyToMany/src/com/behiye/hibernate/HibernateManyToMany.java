package com.behiye.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.behiye.entity.Kurs;
import com.behiye.entity.Ogrenci;
import com.behiye.entity.Ogretmen;
import com.behiye.entity.OgretmenDetay;

public class HibernateManyToMany {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Ogretmen.class).addAnnotatedClass(OgretmenDetay.class).addAnnotatedClass(Kurs.class)
				.addAnnotatedClass(Ogrenci.class).buildSessionFactory();

		// create session
		Session session = sessionFactory.getCurrentSession();

		session.beginTransaction();

		// Ogretmen ogr = session.get(Ogretmen.class, 18);
		// Kurs kurs = session.get(Kurs.class, 18);

		// Ogrenci ogrenci1 = new Ogrenci("behiye", "baþer", 111);
		// Ogrenci ogrenci2 = new Ogrenci("özge", "demirbaþ", 222);

		// kurs.addOgrenci(ogrenci1);
		// kurs.addOgrenci(ogrenci2);

		// session.save(kurs);

		Ogrenci ogrenci = session.get(Ogrenci.class, 3);
		// Kurs kurs = session.get(Kurs.class, 17);
		// ogrenci.addKurs(kurs);

		List<Ogrenci> ogrenciler = session.createQuery("from Ogrenci where id=3").getResultList();

		System.out.println(ogrenci);

		for (Ogrenci ogr : ogrenciler) {
			System.out.println(ogr.getKurslar());
		}

		session.getTransaction().commit();

		session.close();

	}

}
