package de.gtwsp21.handmanserv.service;

import java.security.Principal;

import org.springframework.stereotype.Service;

import de.gtwsp21.handmanserv.model.StartseitenModel;

@Service
public class StartseiteService {

	public StartseitenModel getStartseite(Principal principal) {
		StartseitenModel model = new StartseitenModel();
		
		model.setUsername(principal.getName());
		
		return model;
	}
	
}
