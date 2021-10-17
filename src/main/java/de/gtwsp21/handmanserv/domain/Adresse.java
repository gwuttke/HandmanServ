package de.gtwsp21.handmanserv.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Adresse")
public class Adresse {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	private Gebiet gebiet;
	
	private String strasse;
	
	private String hausnummer;
	
	private String plz;
	
	private String ort;

	
	
	protected Adresse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Adresse(Gebiet gebiet, String strasse, String hausnummer, String plz, String ort) {
		this();
		this.gebiet = gebiet;
		this.strasse = strasse;
		this.hausnummer = hausnummer;
		this.plz = plz;
		this.ort = ort;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Gebiet getGebiet() {
		return gebiet;
	}

	public void setGebiet(Gebiet gebiet) {
		this.gebiet = gebiet;
	}

	public String getStrasse() {
		return strasse;
	}

	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}

	public String getHausnummer() {
		return hausnummer;
	}

	public void setHausnummer(String hausnummer) {
		this.hausnummer = hausnummer;
	}

	public String getPlz() {
		return plz;
	}

	public void setPlz(String plz) {
		this.plz = plz;
	}

	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}
	
	
}
