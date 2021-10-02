package de.gtwsp21.handmanserv.model;

public class PasswortResetModel {
	
	private String token;
	
	private String eMail;
	
	private String passwort;
	
	private String passwortConfirm;

	public String getPasswort() {
		return passwort;
	}

	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}

	public String getPasswortConfirm() {
		return passwortConfirm;
	}

	public void setPasswortConfirm(String passwortConfirm) {
		this.passwortConfirm = passwortConfirm;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
}
