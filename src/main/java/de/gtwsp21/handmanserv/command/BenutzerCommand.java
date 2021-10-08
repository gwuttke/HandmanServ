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
import de.gtwsp21.handmanserv.domain.Handwerker;
import de.gtwsp21.handmanserv.domain.ITMitarbeiter;
import de.gtwsp21.handmanserv.domain.Versicherungsnehmer;
import de.gtwsp21.handmanserv.validator.EmailValid;

public class BenutzerCommand {

	@NotNull
    @Size(min = 1, message = "Bitte wählen Sie eine Anrede")
	private String anrede;
	
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
    
    private List<Long> gebiete;
    
    private List<Long> gewerke;
    
    private String police;
    
    private String strasse;
    
    private String nummer;
    
    private String plz;
    
    private String ort;
    
    private String land;

	public String getPolice() {
		return police;
	}

	public void setPolice(String police) {
		this.police = police;
	}

	public String getStrasse() {
		return strasse;
	}

	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}

	public String getNummer() {
		return nummer;
	}

	public void setNummer(String nummer) {
		this.nummer = nummer;
	}

	public String getPlz() {
		return plz;
	}

	public void setPlz(String plz) {
		this.plz = plz;
	}

	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

	public String getLand() {
		return land;
	}

	public void setLand(String land) {
		this.land = land;
	}

	public int getRolle() {
		return rolle;
	}

	public void setRolle(int rolle) {
		this.rolle = rolle;
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

	public List<Long> getGebiete() {
		return gebiete;
	}

	public void setGebiete(List<Long> gebiete) {
		this.gebiete = gebiete;
	}

	public List<Long> getGewerke() {
		return gewerke;
	}

	public void setGewerke(List<Long> gewerke) {
		this.gewerke = gewerke;
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
			return new Berater(nachname, vorname, email, null, anrede, telefonnummer, null);
		case 2:
			return new Bauherr(nachname,vorname,email,null,anrede,telefonnummer,null);
		case 3:
			return new Versicherungsnehmer(nachname, vorname, email, null, anrede, telefonnummer);
		case 4:
			return new Handwerker(nachname, vorname, email, null, anrede, telefonnummer, null, null);
		case 5:
			return new BackofficeMitarbeiter(nachname, vorname, email, null, anrede, telefonnummer);
		case 6:
			return new ITMitarbeiter(nachname, vorname, email, null, anrede, telefonnummer);
		default:
			throw new IllegalArgumentException(String.format("Den Benutzertyp mit der Rollennummer: %s gibt es nicht!",rolle));
		}
    }
    
	
}
