package de.gtwsp21.handmanserv.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import de.gtwsp21.handmanserv.domain.Auftrag;
import de.gtwsp21.handmanserv.domain.BackofficeMitarbeiter;
import de.gtwsp21.handmanserv.domain.Bauherr;
import de.gtwsp21.handmanserv.domain.Benutzer;
import de.gtwsp21.handmanserv.domain.Berater;
import de.gtwsp21.handmanserv.domain.Versicherungsnehmer;
import de.gtwsp21.handmanserv.repository.AuftragRepository;
import de.gtwsp21.handmanserv.service.IAuftragService;

@Service
public class AuftragService implements IAuftragService {
	
	@Autowired
	private AuftragRepository auftragRepository;

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
	
	
	
}
