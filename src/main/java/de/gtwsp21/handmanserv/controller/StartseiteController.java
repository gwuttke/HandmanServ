package de.gtwsp21.handmanserv.controller;

import java.security.Principal;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import de.gtwsp21.handmanserv.service.StartseiteService;

@Controller
public class StartseiteController {

	@Autowired
	private StartseiteService startseiteService;
	
	
	@GetMapping(value = "/")
	public String startseite(Model model, Principal principal) {

		model.addAttribute("model",startseiteService.getStartseite(principal));
		
		return "startseite";
		
	}
	
	@GetMapping(value = "/passwordReset")
	public String passwortReset(@RequestParam(required = false,name = "token",defaultValue = "") String token,Model model) {
		if(StringUtils.isNotBlank(token)) {
			model.addAttribute("token", token);
		}
		return "passwordReset";
	}
}
