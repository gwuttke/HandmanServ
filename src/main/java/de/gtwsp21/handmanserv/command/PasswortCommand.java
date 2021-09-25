package de.gtwsp21.handmanserv.command;

public class PasswortCommand {

	private String token;
	
	private String newPasswort;
	
	private String confirmPasswort;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getNewPasswort() {
		return newPasswort;
	}

	public void setNewPasswort(String newPasswort) {
		this.newPasswort = newPasswort;
	}

	public String getConfirmPasswort() {
		return confirmPasswort;
	}

	public void setConfirmPasswort(String confirmPasswort) {
		this.confirmPasswort = confirmPasswort;
	}
	
	
}
