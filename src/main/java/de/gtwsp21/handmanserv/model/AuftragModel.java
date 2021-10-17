package de.gtwsp21.handmanserv.model;

import java.util.List;

import de.gtwsp21.handmanserv.domain.Auftragstatus;
import de.gtwsp21.handmanserv.domain.Versicherungsnehmer;

public class AuftragModel {

	List<Auftragstatus> status;
	
	List<String> policen;
	
	Versicherungsnehmer versicherungsnehmer;

	public List<Auftragstatus> getStatus() {
		return status;
	}

	public void setStatus(List<Auftragstatus> status) {
		this.status = status;
	}

	public List<String> getPolicen() {
		return policen;
	}

	public void setPolicen(List<String> policen) {
		this.policen = policen;
	}

	public Versicherungsnehmer getVersicherungsnehmer() {
		return versicherungsnehmer;
	}

	public void setVersicherungsnehmer(Versicherungsnehmer versicherungsnehmer) {
		this.versicherungsnehmer = versicherungsnehmer;
	}
	
}
