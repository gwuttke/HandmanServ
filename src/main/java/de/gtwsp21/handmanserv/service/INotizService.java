package de.gtwsp21.handmanserv.service;

import de.gtwsp21.handmanserv.domain.Auftrag;
import de.gtwsp21.handmanserv.domain.Benutzer;

public interface INotizService {

	Auftrag addNotiz(long auftragId, Benutzer benutzer, String text);

}