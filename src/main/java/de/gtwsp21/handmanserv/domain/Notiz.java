package de.gtwsp21.handmanserv.domain;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Notiz")
public class Notiz {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	private Benutzer benutzer;
	
	@Column(length = 4000)
	private String text;
	
	private LocalDateTime date;

	@ManyToOne
	@JoinTable(name = "Auftrag_Notiz",
    joinColumns = @JoinColumn(name = "NotizId"),
    inverseJoinColumns = @JoinColumn(name = "AuftragId"))
	private Auftrag auftrag;
	
	public Auftrag getAuftrag() {
		return auftrag;
	}

	public void setAuftrag(Auftrag auftrag) {
		this.auftrag = auftrag;
	}

	protected Notiz() {
		super();
	}

	public Notiz(Benutzer benutzer, Auftrag auftrag, String text) {
		this();
		this.benutzer = benutzer;
		this.auftrag = auftrag;
		this.text = text;
		this.date = LocalDateTime.now();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Benutzer getBenutzer() {
		return benutzer;
	}

	public void setBenutzer(Benutzer benutzer) {
		this.benutzer = benutzer;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}
		
}
