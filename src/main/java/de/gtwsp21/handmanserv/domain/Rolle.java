package de.gtwsp21.handmanserv.domain;

import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import de.gtwsp21.handmanserv.domain.compositid.RollenId;


@Entity
@Table(name = "authorities")
public class Rolle {

	@EmbeddedId
    private RollenId rollenId;

	protected Rolle() {
	}
	
	public Rolle(RollenId rollenId) {
		super();
		this.rollenId = rollenId;
	}

	public RollenId getRollenId() {
		return rollenId;
	}

	public void setRollenId(RollenId rollenId) {
		this.rollenId = rollenId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(rollenId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rolle other = (Rolle) obj;
		return Objects.equals(rollenId, other.rollenId);
	}

	
	
}