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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "Auftrag",uniqueConstraints = @UniqueConstraint(columnNames = {"nummer"},name = "UX_Nummer"))
public class Auftrag {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	private Versicherungsnehmer versicherungsnehmer;
	
	@OneToOne
	private Adresse adresse;
	
	@OneToOne
	private Bauherr bauherr;
	
	@OneToOne
	private Benutzer angelegtVon;
	
	private LocalDateTime erstellungsdatum;
	
	@Column(length = 4000)
	private String auftragstext;
	
	private LocalDateTime beginndatum;
	
	private LocalDateTime enddatum;
	
	private Auftragstatus status;
	
	private String nummer;
	
	@OneToMany
	private List<Teilauftrag> teilauftrag;
	
	@OneToMany
	@JoinTable(name = "Auftrag_Notiz",
    joinColumns = @JoinColumn(name = "AuftragId"),
    inverseJoinColumns = @JoinColumn(name = "NotizId"))
	private List<Notiz> notizen;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Versicherungsnehmer getVersicherungsnehmer() {
		return versicherungsnehmer;
	}

	public void setVersicherungsnehmer(Versicherungsnehmer versicherungsnehmer) {
		this.versicherungsnehmer = versicherungsnehmer;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public Bauherr getBauherr() {
		return bauherr;
	}

	public void setBauherr(Bauherr bauherr) {
		this.bauherr = bauherr;
	}

	public Benutzer getAngelegtVon() {
		return angelegtVon;
	}

	public void setAngelegtVon(Benutzer angelegtVon) {
		this.angelegtVon = angelegtVon;
	}

	public LocalDateTime getErstellungsdatum() {
		return erstellungsdatum;
	}

	public void setErstellungsdatum(LocalDateTime erstellungsdatum) {
		this.erstellungsdatum = erstellungsdatum;
	}

	public String getAuftragstext() {
		return auftragstext;
	}

	public void setAuftragstext(String auftragstext) {
		this.auftragstext = auftragstext;
	}

	public LocalDateTime getBeginndatum() {
		return beginndatum;
	}

	public void setBeginndatum(LocalDateTime beginndatum) {
		this.beginndatum = beginndatum;
	}

	public LocalDateTime getEnddatum() {
		return enddatum;
	}

	public void setEnddatum(LocalDateTime enddatum) {
		this.enddatum = enddatum;
	}

	public Auftragstatus getStatus() {
		return status;
	}

	public void setStatus(Auftragstatus status) {
		this.status = status;
	}

	public String getNummer() {
		return nummer;
	}

	public void setNummer(String nummer) {
		this.nummer = nummer;
	}
	
}
