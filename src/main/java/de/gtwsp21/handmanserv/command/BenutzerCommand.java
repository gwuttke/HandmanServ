package de.gtwsp21.handmanserv.command;

import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import de.gtwsp21.handmanserv.domain.BackofficeMitarbeiter;
import de.gtwsp21.handmanserv.domain.Bauherr;
import de.gtwsp21.handmanserv.domain.Benutzer;
import de.gtwsp21.handmanserv.domain.Berater;
import de.gtwsp21.handmanserv.domain.Gebiet;
import de.gtwsp21.handmanserv.domain.Gewerk;
import de.gtwsp21.handmanserv.domain.Handwerker;
import de.gtwsp21.handmanserv.domain.ITMitarbeiter;
import de.gtwsp21.handmanserv.domain.Versicherungsnehmer;
import de.gtwsp21.handmanserv.validator.EmailValid;

public class BenutzerCommand {

	@NotNull
    @Size(min = 1, message = "Bitte wählen Sie eine Anrede")
	private String anrede;
	
	@NotNull
    @Size(min = 1, message = "Bitte geben Sie eine Telefonnummer an")
	private String telefonnummer;
	
	@NotNull
    @Size(min = 1, message = "Bitte geben Sie einen Vornamen an")
    private String vorname;

    @NotNull
    @Size(min = 1, message = "Bitte geben Sie einen Nachnamen an")
    private String nachname;

    @EmailValid
    @NotNull
    @Size(min = 1, message = "Bitte geben Sie eine korrekte e-Mail an")
    private String email;
    
    @NotNull
    @Min(value = 1, message = "Bitte geben Sie einen Benutzertyp an")
    @Max(value = 6, message =  "Bitte geben Sie einen korrekten Benutzertyp an")
    private int rolle;
    
    private List<Gebiet> gebiete;
    
    private List<Gewerk> gewerke;

	public int getRolle() {
		return rolle;
	}

	public void setRolle(int rolle) {
		this.rolle = rolle;
	}

	public List<Gebiet> getGebiete() {
		return gebiete;
	}

	public void setGebiete(List<Gebiet> gebiete) {
		this.gebiete = gebiete;
	}

	public List<Gewerk> getGewerke() {
		return gewerke;
	}

	public void setGewerke(List<Gewerk> gewerke) {
		this.gewerke = gewerke;
	}

	public String getAnrede() {
		return anrede;
	}

	public void setAnrede(String anrede) {
		this.anrede = anrede;
	}

	public String getTelefonnummer() {
		return telefonnummer;
	}

	public void setTelefonnummer(String telefonnummer) {
		this.telefonnummer = telefonnummer;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
    
    public Benutzer toBenutzer(){
    	switch (rolle) {
		case 1:
			return new Berater(nachname, vorname, email, null, anrede, telefonnummer, gebiete);
		case 2:
			return new Bauherr(nachname,vorname,email,null,anrede,telefonnummer);
		case 3:
			return new Versicherungsnehmer(nachname, vorname, email, null, anrede, telefonnummer);
		case 4:
			return new Handwerker(nachname, vorname, email, null, anrede, telefonnummer, gebiete, gewerke);
		case 5:
			return new BackofficeMitarbeiter(nachname, vorname, email, null, anrede, telefonnummer);
		case 6:
			return new ITMitarbeiter(nachname, vorname, email, null, anrede, telefonnummer);
		default:
			throw new IllegalArgumentException(String.format("Den Benutzertyp mit der Rollennummer: %s gibt es nicht!",rolle));
		}
    }
    
	
}
