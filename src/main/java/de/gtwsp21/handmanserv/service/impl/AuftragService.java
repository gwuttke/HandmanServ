package de.gtwsp21.handmanserv.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.gtwsp21.handmanserv.command.AuftragCommand;
import de.gtwsp21.handmanserv.domain.Adresse;
import de.gtwsp21.handmanserv.domain.Auftrag;
import de.gtwsp21.handmanserv.domain.Auftragstatus;
import de.gtwsp21.handmanserv.domain.BackofficeMitarbeiter;
import de.gtwsp21.handmanserv.domain.Bauherr;
import de.gtwsp21.handmanserv.domain.Benutzer;
import de.gtwsp21.handmanserv.domain.Berater;
import de.gtwsp21.handmanserv.domain.Gebiet;
import de.gtwsp21.handmanserv.domain.Versicherungsnehmer;
import de.gtwsp21.handmanserv.model.helper.GebietHelper;
import de.gtwsp21.handmanserv.repository.AuftragRepository;
import de.gtwsp21.handmanserv.repository.BenutzerRepository;
import de.gtwsp21.handmanserv.repository.VersicherungsnehmerRepository;
import de.gtwsp21.handmanserv.service.IAuftragService;

@Service
public class AuftragService implements IAuftragService {
	
	@Autowired
	private AuftragRepository auftragRepository;
	
	@Autowired
	private BenutzerService benutzerService;
	
	@Autowired
	private BenutzerRepository benutzerRepository;
	
	@Autowired
	private GebietHelper gebietHelper;
	
	@Autowired
	private VersicherungsnehmerRepository versicherungsnehmerRepository;

	@Override
	public List<Auftrag> listAuftraege(Benutzer b,Versicherungsnehmer v) {
		return  findAuftragByUser(b,v);
	}

	private List<Auftrag> findAuftragByUser(Benutzer steller,Versicherungsnehmer v){
		List<Auftrag> auftraege = new ArrayList<Auftrag>();
		
		if(steller instanceof Versicherungsnehmer) {
			auftraege.addAll(auftragRepository.findByAdresse(((Versicherungsnehmer) steller).getAdresse()));
		}else if(steller instanceof Bauherr) {
			auftraege.addAll(auftragRepository.findByAngelegtVon(steller));
			auftraege.addAll(auftragRepository.findByBauherr((Bauherr) steller));
			auftraege.addAll(auftragRepository.findByAdresseGebietInAndBauherr(((Bauherr) steller).getGebiete(),null));
		}else if(steller instanceof Berater && v != null) {
			auftraege.addAll(auftragRepository.findByVersicherungsnehmer(v));
			
		}else if(steller instanceof BackofficeMitarbeiter) {
			auftraege.addAll(auftragRepository.findAll());
		}
		
		return auftraege;
	}
	
	private synchronized String findNextAuftragNummer(LocalDate ld) {
		LocalDateTime begin = LocalDateTime.of(ld.getYear(),Month.JANUARY,1,0,0);
		LocalDateTime end = LocalDateTime.of(ld.getYear(),Month.DECEMBER,31,0,0);
		Long nummber = auftragRepository.countByErstellungsdatumBetween(begin, end) +1L;
		
		return String.format("%d%06d",ld.getYear(), nummber);
	}

	@Override
	public Auftrag generate(AuftragCommand command) {
		Optional<Versicherungsnehmer> versicherterOpt = versicherungsnehmerRepository.findById(command.getVersicherungsnehmerId());
		Auftrag auftrag = null;
		if(versicherterOpt.isPresent()) {
			Versicherungsnehmer v = versicherterOpt.get();
			Adresse a = null;
			Benutzer angelegtVon = benutzerRepository.getById(command.getAngelegtVonId());
			if(command.isVersichertenAdresse()) {
				a = v.getAdresse();
			}else {
				Gebiet geb = gebietHelper.findGebietByPlz(command.getPlz());
				a = new Adresse(geb, command.getStrasse(), command.getHausnummer(), command.getPlz(), command.getOrt());
			}
			auftrag = new Auftrag(v,a,angelegtVon,LocalDateTime.now(),command.getAuftragstext(),null,null,Auftragstatus.findByNummer(command.getStatus()),
					command.getKurzbeschreibung(),findNextAuftragNummer(LocalDate.now()));
			auftragRepository.save(auftrag);
		}
		
		
		return auftrag;
		
	}
	
	
	
}
