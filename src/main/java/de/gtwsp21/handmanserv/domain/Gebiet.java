package de.gtwsp21.handmanserv.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Gebiet")
public class Gebiet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String bereich;
	
	protected Gebiet() {
		super();
	}
	

	public Gebiet(String name, String bereich) {
		this();
		this.name = name;
		this.bereich = bereich;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBereich() {
		return bereich;
	}

	public void setBereich(String bereich) {
		this.bereich = bereich;
	}

}
