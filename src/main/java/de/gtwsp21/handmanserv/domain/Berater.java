package de.gtwsp21.handmanserv.domain;

import java.util.List;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Table(name = "Berater")
public class Berater extends Benutzer {

	@ManyToMany
	@JoinTable(name = "Gebiet_Berater",
    joinColumns = @JoinColumn(name = "BeraterId"),
    inverseJoinColumns = @JoinColumn(name = "GebietId"))
	private List<Gebiet> gebiete;
	
	@Override
	int getRolleNr() {
		return 1;
	}

	@Override
	String getRolleName() {
		return "Berater";
	}
	
	

}
