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
@Table(name = "Bauherr")
@PrimaryKeyJoinColumns({
    @PrimaryKeyJoinColumn(name="Benutzer_id", 
        referencedColumnName="id")})
public class Bauherr extends Benutzer {

	@ManyToMany
	@JoinTable(name = "Gebiet_Bauherr",
    joinColumns = @JoinColumn(name = "BauherrId"),
    inverseJoinColumns = @JoinColumn(name = "GebietId"))
	private List<Gebiet> gebiete;
	
	@Override
	int getRolleNr() {
		return 2;
	}

	@Override
	String getRolleName() {
		return "Bauherr";
	}

}
