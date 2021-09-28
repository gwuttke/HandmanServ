package de.gtwsp21.handmanserv.model;

import java.util.List;

import org.apache.commons.lang3.tuple.Pair;

import de.gtwsp21.handmanserv.domain.Gebiet;
import de.gtwsp21.handmanserv.domain.Gewerk;

public class RegistrierenModel {
	
	private List<Pair<Integer, String>> benutzertyp;
	
	private List<Gewerk> gewerke;
	
	private List<Gebiet> gebiete;
	
	private List<String> anreden;

	public List<Pair<Integer, String>> getBenutzertyp() {
		return benutzertyp;
	}

	public void setBenutzertyp(List<Pair<Integer, String>> benutzertyp) {
		this.benutzertyp = benutzertyp;
	}

	public List<Gewerk> getGewerke() {
		return gewerke;
	}

	public void setGewerke(List<Gewerk> gewerke) {
		this.gewerke = gewerke;
	}

	public List<Gebiet> getGebiete() {
		return gebiete;
	}

	public void setGebiete(List<Gebiet> gebiete) {
		this.gebiete = gebiete;
	}

	public List<String> getAnreden() {
		return anreden;
	}

	public void setAnreden(List<String> anreden) {
		this.anreden = anreden;
	}

	

}
