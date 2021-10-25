package de.gtwsp21.handmanserv.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.PrimaryKeyJoinColumns;
import javax.persistence.Table;

@Entity
@Table(name = "berater")
@PrimaryKeyJoinColumns({
    @PrimaryKeyJoinColumn(name="benutzer_id", 
        referencedColumnName="id")})
public class Berater extends Benutzer {

	public Berater() {
		super();
	}

	public Berater(String nachname, String vorname, String eMailadresse, String passwort, String anrede,
			String telefonnummer,List<Gebiet> gebiete) {
		super(nachname, vorname, eMailadresse, passwort, anrede, telefonnummer);
		this.gebiete=gebiete;
	}

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "gebiet_berater",
    joinColumns = @JoinColumn(name = "berater_id"),
    inverseJoinColumns = @JoinColumn(name = "gebiet_id"))
	private List<Gebiet> gebiete;
	
	public List<Gebiet> getGebiete() {
		return gebiete;
	}

	public void setGebiete(List<Gebiet> gebiete) {
		this.gebiete = gebiete;
	}

	@Override
	public int getRolleNr() {
		return 1;
	}

	@Override
	public String getRolleName() {
		return "Berater";
	}
	
	@Override
	public String[] getRolleForSecurity() {
		return new String[] {ROLE_NAME_BERATER};
	}

}
