package de.gtwsp21.handmanserv.domain;

import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name = "Versicherungsnehmer")
public class Versicherungsnehmer extends Benutzer {

	@OneToOne
	private Adresse adresse;
	
	private String telefonnummer;
	
	private String policennummer;
	
	@Override
	int getRolleNr() {
		return 3;
	}

	@Override
	String getRolleName() {
		return "Versicherungsnehmer";
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public String getTelefonnummer() {
		return telefonnummer;
	}

	public void setTelefonnummer(String telefonnummer) {
		this.telefonnummer = telefonnummer;
	}

	public String getPolicennummer() {
		return policennummer;
	}

	public void setPolicennummer(String policennummer) {
		this.policennummer = policennummer;
	}

}
