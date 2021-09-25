package de.gtwsp21.handmanserv.domain;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.PrimaryKeyJoinColumns;
import javax.persistence.Table;

@Entity
@Table(name = "Versicherungsnehmer")
@PrimaryKeyJoinColumns({
        @PrimaryKeyJoinColumn(name="Benutzer_id", 
            referencedColumnName="id")})
public class Versicherungsnehmer extends Benutzer {

	public Versicherungsnehmer() {
		super();
	}

	public Versicherungsnehmer(String nachname, String vorname, String eMailadresse, String passwort, String anrede,
			String telefonnummer) {
		super(nachname, vorname, eMailadresse, passwort, anrede, telefonnummer);
	}

	@OneToOne
	private Adresse adresse;
	
	private String telefonnummer;
	
	private String policennummer;
	
	@Override
	public int getRolleNr() {
		return 3;
	}

	@Override
	public String getRolleName() {
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
	
	@Override
	public String[] getRolleForSecurity() {
		return new String[] {ROLE_NAME_VERSICHERUNGSNEHMER};
	}

}
