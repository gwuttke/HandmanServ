package de.gtwsp21.handmanserv.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StartseiteController {

	
	@GetMapping(name = "/")
	public String startseite(Model model, Principal principal) {
		
		model.addAttribute("user", principal.getName());
		return "startseite";
		
	}
}
