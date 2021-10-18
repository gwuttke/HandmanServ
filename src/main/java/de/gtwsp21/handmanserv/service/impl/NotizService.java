package de.gtwsp21.handmanserv.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.gtwsp21.handmanserv.domain.Auftrag;
import de.gtwsp21.handmanserv.domain.Benutzer;
import de.gtwsp21.handmanserv.domain.Notiz;
import de.gtwsp21.handmanserv.repository.NotizRepository;
import de.gtwsp21.handmanserv.service.IAuftragService;
import de.gtwsp21.handmanserv.service.IBenutzerService;
import de.gtwsp21.handmanserv.service.INotizService;

@Service
public class NotizService implements INotizService {

	@Autowired
	private IAuftragService auftragService;
	
	@Autowired
	private NotizRepository notizRepository;
	
	@Override
	public Auftrag addNotiz(long auftragId, Benutzer benutzer, String text) {
		Auftrag a = auftragService.get(auftragId);
		Notiz n = new Notiz(benutzer,a,text);
		notizRepository.save(n);
		a = auftragService.get(auftragId);
		return a;
	}
	
}
