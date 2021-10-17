package de.gtwsp21.handmanserv.command;

public class AuftragCommand {
	
	private Long versicherungsnehmerId;
	
	private String lokation;
	
	private String police;
	
	private String strasse;
	
	private String hausnummer;
	
	private String plz;
	
	private String ort;

	private Long bauherrId;
	
	private Long angelegtVonId;
	
	private String erstellungsdatum;
	
	private String auftragstext;
	
	private String beginndatum;
	
	private String enddatum;
	
	private int status;
	
	private String nummer;
	
	private String kurzbeschreibung;
	
	private boolean versichertenAdresse;
	
	public boolean isVersichertenAdresse() {
		return versichertenAdresse;
	}

	public void setVersichertenAdresse(boolean versichertenAdresse) {
		this.versichertenAdresse = versichertenAdresse;
	}

	public String getLokation() {
		return lokation;
	}

	public void setLokation(String lokation) {
		this.lokation = lokation;
	}

	public String getKurzbeschreibung() {
		return kurzbeschreibung;
	}

	public void setKurzbeschreibung(String kurzbeschreibung) {
		this.kurzbeschreibung = kurzbeschreibung;
	}


	public Long getVersicherungsnehmerId() {
		return versicherungsnehmerId;
	}

	public void setVersicherungsnehmerId(Long versicherungsnehmerId) {
		this.versicherungsnehmerId = versicherungsnehmerId;
	}

	public String getStrasse() {
		return strasse;
	}

	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}

	public String getHausnummer() {
		return hausnummer;
	}

	public void setHausnummer(String hausnummer) {
		this.hausnummer = hausnummer;
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

	public Long getBauherrId() {
		return bauherrId;
	}

	public void setBauherrId(Long bauherrId) {
		this.bauherrId = bauherrId;
	}

	public Long getAngelegtVonId() {
		return angelegtVonId;
	}

	public void setAngelegtVonId(Long angelegtVonId) {
		this.angelegtVonId = angelegtVonId;
	}

	public String getAuftragstext() {
		return auftragstext;
	}

	public void setAuftragstext(String auftragstext) {
		this.auftragstext = auftragstext;
	}

	public String getPolice() {
		return police;
	}

	public void setPolice(String police) {
		this.police = police;
	}

	public String getErstellungsdatum() {
		return erstellungsdatum;
	}

	public void setErstellungsdatum(String erstellungsdatum) {
		this.erstellungsdatum = erstellungsdatum;
	}

	public String getBeginndatum() {
		return beginndatum;
	}

	public void setBeginndatum(String beginndatum) {
		this.beginndatum = beginndatum;
	}

	public String getEnddatum() {
		return enddatum;
	}

	public void setEnddatum(String enddatum) {
		this.enddatum = enddatum;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getNummer() {
		return nummer;
	}

	public void setNummer(String nummer) {
		this.nummer = nummer;
	}

}
