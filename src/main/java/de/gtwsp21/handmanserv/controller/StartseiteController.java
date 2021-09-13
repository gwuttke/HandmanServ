package de.gtwsp21.handmanserv.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import de.gtwsp21.handmanserv.service.StartseiteService;

@Controller
public class StartseiteController {

	@Autowired
	private StartseiteService startseiteService;
	
	
	@GetMapping(name = "/")
	public String startseite(Model model, Principal principal) {

		model.addAttribute("model",startseiteService.getStartseite(principal));
		
		return "startseite";
		
	}
}
