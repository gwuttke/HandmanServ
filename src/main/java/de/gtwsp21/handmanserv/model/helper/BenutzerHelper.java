package de.gtwsp21.handmanserv.model.helper;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.stereotype.Component;

import de.gtwsp21.handmanserv.domain.BackofficeMitarbeiter;
import de.gtwsp21.handmanserv.domain.Bauherr;
import de.gtwsp21.handmanserv.domain.Benutzer;
import de.gtwsp21.handmanserv.domain.Berater;
import de.gtwsp21.handmanserv.domain.Handwerker;
import de.gtwsp21.handmanserv.domain.ITMitarbeiter;
import de.gtwsp21.handmanserv.domain.Versicherungsnehmer;

@Component
public class BenutzerHelper {
	
	private Benutzer[] allBenutzer = new Benutzer[] {new Berater(),new Bauherr(),
				new Versicherungsnehmer(),new Handwerker(),new BackofficeMitarbeiter(),new ITMitarbeiter()};
	
	public List<Pair<Integer,String>> getBenutzertypen(){
		List<Pair<Integer,String>> l = Stream.of(allBenutzer)
			.map(b -> new ImmutablePair<>(b.getRolleNr(), b.getRolleName())).collect(Collectors.toList());
		
		return l;
	}

}
