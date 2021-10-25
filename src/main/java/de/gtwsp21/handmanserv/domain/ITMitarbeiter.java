package de.gtwsp21.handmanserv.domain;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.PrimaryKeyJoinColumns;
import javax.persistence.Table;

@Entity
@Table(name = "itmitarbeiter ")
@PrimaryKeyJoinColumns({
    @PrimaryKeyJoinColumn(name="benutzer_id", 
        referencedColumnName="id")})
public class ITMitarbeiter extends Benutzer{

	public ITMitarbeiter() {
		super();
	}

	public ITMitarbeiter(String nachname, String vorname, String eMailadresse, String passwort, String anrede,
			String telefonnummer) {
		super(nachname, vorname, eMailadresse, passwort, anrede, telefonnummer);
	}

	@Override
	public int getRolleNr() {
		return 6;
	}

	@Override
	public String getRolleName() {
		return "IT";
	}

	@Override
	public String[] getRolleForSecurity() {
		return new String[] {ROLE_NAME_IT_MITARBEITER};
	}
	
}
