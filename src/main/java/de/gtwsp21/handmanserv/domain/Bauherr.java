package de.gtwsp21.handmanserv.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.PrimaryKeyJoinColumns;
import javax.persistence.Table;

@Entity
@Table(name = "Bauherr")
@PrimaryKeyJoinColumns({
    @PrimaryKeyJoinColumn(name="Benutzer_id", 
        referencedColumnName="id")})
public class Bauherr extends Benutzer {
	
	public Bauherr() {
		super();
	}

	public Bauherr(String nachname, String vorname, String eMailadresse, String passwort, String anrede,
			String telefonnummer) {
		super(nachname, vorname, eMailadresse, passwort, anrede, telefonnummer);
	}
	
	

	public Bauherr(String nachname, String vorname, String eMailadresse, String passwort, String anrede,
			String telefonnummer, List<Gebiet> gebiete) {
		super(nachname, vorname, eMailadresse, passwort, anrede, telefonnummer);
		this.gebiete = gebiete;
	}

	@ManyToMany
	@JoinTable(name = "Gebiet_Bauherr",
    joinColumns = @JoinColumn(name = "BauherrId"),
    inverseJoinColumns = @JoinColumn(name = "GebietId"))
	private List<Gebiet> gebiete;
	
	public List<Gebiet> getGebiete() {
		return gebiete;
	}

	public void setGebiete(List<Gebiet> gebiete) {
		this.gebiete = gebiete;
	}

	@Override
	public int getRolleNr() {
		return 2;
	}

	@Override
	public String getRolleName() {
		return "Bauherr";
	}
	
	@Override
	public String[] getRolleForSecurity() {
		return new String[] {ROLE_NAME_BAUHERR};
	}

}
