package de.gtwsp21.handmanserv.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import de.gtwsp21.handmanserv.command.BenutzerCommand;
import de.gtwsp21.handmanserv.exception.BenutzerExistiertSchonException;
import de.gtwsp21.handmanserv.service.IBenutzerService;

@Controller("/user")
public class UserController {
	
	@Autowired
	private IBenutzerService benutzerService;

	
	@GetMapping(value = "/erfassen")
	public String erfassen(ModelMap model) {
		
		model.addAttribute("data", benutzerService.loadRegistration());
		
		return "userErfassen";
	}
	
	@GetMapping(value = "/reg")
	public String reg(ModelMap model) {
		
		model.addAttribute("data", benutzerService.loadRegistration());
		
		return "startseite";
	}
	
	@PostMapping(name = "registrieren")
	public String registrieren(@Valid @ModelAttribute("benutzer") BenutzerCommand benutzerCommand, 
		      BindingResult result, ModelMap model) {
				
		if (result.hasErrors()) {
			return "registrieren"; 
		}
		try {	
			benutzerService.registerNewUserAccount(benutzerCommand);
		}catch (BenutzerExistiertSchonException e) {
			result.rejectValue("emailadresse", "Diese e-Mail Adresse existiert bereits!");
			return "registrieren"; 
		}
		return "login";
	}
	
}
