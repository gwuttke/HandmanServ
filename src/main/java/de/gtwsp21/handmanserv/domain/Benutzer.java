package de.gtwsp21.handmanserv.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "benutzer")
@Inheritance(
    strategy = InheritanceType.JOINED
)
public abstract class Benutzer implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4551508668978194141L;
	
	@Transient
	private final String ROLE_PREFIX="ROLE_";
	@Transient
	final String ROLE_NAME_BAUHERR=ROLE_PREFIX +"BAUHERR";
	@Transient
	final String ROLE_NAME_IT_MITARBEITER=ROLE_PREFIX +"ITMitarbeiter";
	@Transient
	final String ROLE_NAME_VERSICHERUNGSNEHMER=ROLE_PREFIX +"VERSICHERUNGSNEHMER";
	@Transient
	final String ROLE_NAME_BACKOFFICE=ROLE_PREFIX +"BACKOFFICE";
	@Transient
	final String ROLE_NAME_BERATER=ROLE_PREFIX + "BERATER";
	@Transient
	final String ROLE_NAME_HANDWERKER=ROLE_PREFIX + "HANDWERKER";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nachname;
	
	private String vorname;
	
	@Column(name = "e_mailadresse")
	private String eMailadresse;
	
	private String passwort;
	
	private String anrede;

	private boolean enabled;
	
	@OneToMany
	private List<Rolle> rolle;
	
	public Benutzer() {
		super();
	}
	
	public Benutzer(String nachname, String vorname, String eMailadresse, String passwort, String anrede,
			String telefonnummer) {
		this();
		this.nachname = nachname;
		this.vorname = vorname;
		this.eMailadresse = eMailadresse;
		this.passwort = passwort;
		this.anrede = anrede;
		this.telefonnummer = telefonnummer;
	}

	@Column(name = "letzte_anmeldung")
	private LocalDateTime letzteAnmeldung;
	
	private String telefonnummer;
	
	public String getAnrede() {
		return anrede;
	}

	public void setAnrede(String anrede) {
		this.anrede = anrede;
	}
		
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String geteMailadresse() {
		return eMailadresse;
	}

	public void seteMailadresse(String eMailadresse) {
		this.eMailadresse = eMailadresse;
	}

	public String getPasswort() {
		return passwort;
	}

	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public LocalDateTime getLetzteAnmeldung() {
		return letzteAnmeldung;
	}

	public void setLetzteAnmeldung(LocalDateTime letzteAnmeldung) {
		this.letzteAnmeldung = letzteAnmeldung;
	}

	public String getTelefonnummer() {
		return telefonnummer;
	}

	public void setTelefonnummer(String telefonnummer) {
		this.telefonnummer = telefonnummer;
	}

	@Transient
	public abstract int getRolleNr();
	@Transient
	public abstract String getRolleName();
	@Transient
	public abstract String[] getRolleForSecurity();
	
}
