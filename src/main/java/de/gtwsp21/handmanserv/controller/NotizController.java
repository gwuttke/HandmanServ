package de.gtwsp21.handmanserv.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import de.gtwsp21.handmanserv.domain.Auftrag;
import de.gtwsp21.handmanserv.domain.Benutzer;
import de.gtwsp21.handmanserv.domain.Notiz;
import de.gtwsp21.handmanserv.service.IAuftragService;
import de.gtwsp21.handmanserv.service.IBenutzerService;
import de.gtwsp21.handmanserv.service.INotizService;

@Controller
@RequestMapping(value = "/notiz")
public class NotizController {
	
	@Autowired
	private INotizService notizService;
	
	@Autowired
	private IBenutzerService benutzerService;
	

	@RequestMapping(value = "/add")
	public String add(@RequestParam(value = "auftrag",required = true) Long auftragId,
			@RequestParam(value = "text") String text,Principal principal,Model model) {
		
		Auftrag a = notizService.addNotiz(auftragId, benutzerService.findUserByEmail(principal.getName()), text);
		
		model.addAttribute("auftrag", a);
		
		return "auftragDetailAnsicht :: notizen";
	}
	
}
