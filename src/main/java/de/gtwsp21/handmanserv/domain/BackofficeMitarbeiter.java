package de.gtwsp21.handmanserv.domain;

import javax.persistence.Table;

@Table(name="BackofficeMitarbeiter")
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
