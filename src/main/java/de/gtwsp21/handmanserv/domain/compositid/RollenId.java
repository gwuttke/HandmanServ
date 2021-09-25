package de.gtwsp21.handmanserv.domain.compositid;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
@Embeddable
public class RollenId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9031726475607164094L;

	private String email;
	
	private String berechtigung;

	public String getEmail() {
		return email;
	}

	public RollenId(String email, String berechtigung) {
		super();
		this.email = email;
		this.berechtigung = berechtigung;
	}

	@Override
	public int hashCode() {
		return Objects.hash(berechtigung, email);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RollenId other = (RollenId) obj;
		return Objects.equals(berechtigung, other.berechtigung) && Objects.equals(email, other.email);
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBerechtigung() {
		return berechtigung;
	}

	public void setBerechtigung(String berechtigung) {
		this.berechtigung = berechtigung;
	}
	
}
