package de.gtwsp21.handmanserv.model.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.gtwsp21.handmanserv.domain.Gebiet;
import de.gtwsp21.handmanserv.repository.GebietRepository;

@Component
public class GebietHelper {

	@Autowired
	private GebietRepository gebieteRepository;

	public Gebiet findGebietByPlz(final String plz) {
		return gebieteRepository.findAll().stream().filter(gebiet -> plz.startsWith(gebiet.getBereich())).findFirst().orElse(null);
	}
	
}
