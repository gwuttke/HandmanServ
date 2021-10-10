package de.gtwsp21.handmanserv.service;

import java.util.List;

import de.gtwsp21.handmanserv.domain.Auftrag;
import de.gtwsp21.handmanserv.domain.Benutzer;
import de.gtwsp21.handmanserv.domain.Versicherungsnehmer;

public interface IAuftragService {

	 List<Auftrag> listAuftraege(Benutzer b,Versicherungsnehmer v);

}