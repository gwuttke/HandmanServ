package de.gtwsp21.handmanserv.domain;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.PrimaryKeyJoinColumns;
import javax.persistence.Table;

@Entity
@Table(name = "ITMitarbeiter")
@PrimaryKeyJoinColumns({
    @PrimaryKeyJoinColumn(name="benutzer_id", 
        referencedColumnName="id")})
public class ITMitarbeiter extends Benutzer{

	@Override
	int getRolleNr() {
		return 6;
	}

	@Override
	String getRolleName() {
		return "IT";
	}

}
