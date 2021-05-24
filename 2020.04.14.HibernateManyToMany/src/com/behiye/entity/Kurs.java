package com.behiye.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "KURS")
public class Kurs {

	@Id
	@Column(name = "id")
	@SequenceGenerator(name = "kurs_seq", sequenceName = "seq_kurs", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "kurs_seq")
	private Integer id;

	@Column(name = "kurs_adi")
	private String kursAdi;

	@Column(name = "saat")
	private Integer saat;

	@ManyToOne
	@JoinColumn(name = "ogretmen_id")
	private Ogretmen ogretmen;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "ogrenci_kurs", joinColumns = @JoinColumn(name = "kurs_id"), inverseJoinColumns = @JoinColumn(name = "ogrenci_id"))
	private List<Ogrenci> ogrenciler;

	public void addOgrenci(Ogrenci o) {

		if (ogrenciler == null)
			ogrenciler = new ArrayList<Ogrenci>();

		ogrenciler.add(o);

	}

	public List<Ogrenci> getOgrenciler() {
		return ogrenciler;
	}

	public void setOgrenciler(List<Ogrenci> ogrenciler) {
		this.ogrenciler = ogrenciler;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getKursAdi() {
		return kursAdi;
	}

	public void setKursAdi(String kursAdi) {
		this.kursAdi = kursAdi;
	}

	public Integer getSaat() {
		return saat;
	}

	public void setSaat(Integer saat) {
		this.saat = saat;
	}

	public Ogretmen getOgretmen() {
		return ogretmen;
	}

	public void setOgretmen(Ogretmen ogretmen) {
		this.ogretmen = ogretmen;
	}

	public Kurs(String kursAdi, Integer saat, Ogretmen ogretmen) {
		super();
		this.kursAdi = kursAdi;
		this.saat = saat;
		this.ogretmen = ogretmen;
	}

	public Kurs() {
		super();
	}

	@Override
	public String toString() {
		return "Kurs:" + kursAdi;
	}

}
