package de.gtwsp21.handmanserv.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.PrimaryKeyJoinColumns;
import javax.persistence.Table;

@Entity
@Table(name = "Berater")
@PrimaryKeyJoinColumns({
    @PrimaryKeyJoinColumn(name="benutzer_id", 
        referencedColumnName="id")})
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
