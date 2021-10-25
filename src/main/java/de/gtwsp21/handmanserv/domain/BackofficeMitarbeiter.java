package de.gtwsp21.handmanserv.domain;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.PrimaryKeyJoinColumns;
import javax.persistence.Table;

@Entity
@Table(name="backoffice_mitarbeiter")
@PrimaryKeyJoinColumns({
    @PrimaryKeyJoinColumn(name="benutzer_id", 
        referencedColumnName="id")})
public class BackofficeMitarbeiter extends Benutzer {

	public BackofficeMitarbeiter() {
		super();
	}

	public BackofficeMitarbeiter(String nachname, String vorname, String eMailadresse, String passwort, String anrede,
			String telefonnummer) {
		super(nachname, vorname, eMailadresse, passwort, anrede, telefonnummer);
	}

	@Override
	public int getRolleNr() {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public String getRolleName() {
		// TODO Auto-generated method stub
		return "Backoffice";
	}

	@Override
	public String[] getRolleForSecurity() {
		return new String[] {ROLE_NAME_BACKOFFICE};
	}

}
