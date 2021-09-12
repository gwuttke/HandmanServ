package de.gtwsp21.handmanserv.domain;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.PrimaryKeyJoinColumns;
import javax.persistence.Table;

@Entity
@Table(name="BackofficeMitarbeiter")
@PrimaryKeyJoinColumns({
    @PrimaryKeyJoinColumn(name="benutzer_id", 
        referencedColumnName="id")})
public class BackofficeMitarbeiter extends Benutzer {

	@Override
	int getRolleNr() {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	String getRolleName() {
		// TODO Auto-generated method stub
		return "Backoffice";
	}

}
