package de.gtwsp21.handmanserv.domain;

import javax.persistence.Table;

@Table(name = "ITMitarbeiter")
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
