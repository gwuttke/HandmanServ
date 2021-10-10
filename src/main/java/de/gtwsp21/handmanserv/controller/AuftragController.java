package de.gtwsp21.handmanserv.controller;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import de.gtwsp21.handmanserv.domain.Auftrag;
import de.gtwsp21.handmanserv.domain.Auftragstatus;
import de.gtwsp21.handmanserv.domain.Benutzer;
import de.gtwsp21.handmanserv.domain.Versicherungsnehmer;
import de.gtwsp21.handmanserv.service.IAuftragService;
import de.gtwsp21.handmanserv.service.IBenutzerService;

@Controller
@RequestMapping(value = "/auftrag")
@PreAuthorize("isAuthenticated()")
public class AuftragController {
	@Autowired
	private IAuftragService auftragService;
	
	@Autowired
	private IBenutzerService benutzerService;
	
	@GetMapping(value = "/list")
	public String listWithStatus(Principal principal,
			@RequestParam(required = false,defaultValue = "") String police,Model model) {
		List<Auftrag> listedAuftraege = listFilteredAuftraege(principal, -1, police);
		model.addAttribute("auftragStatus","Aufträge in allen Status");
		model.addAttribute("auftraege", listedAuftraege);
		return "offeneAuftraege";
	}
	
	@GetMapping(value = "/list/{status}")
	public String listWithStatus(Principal principal, @PathVariable int status,
			@RequestParam(required = false,defaultValue = "") String police,Model model) {
		List<Auftrag> listedAuftraege = listFilteredAuftraege(principal, status, police);
		final Auftragstatus realStatus = Auftragstatus.findByNummer(status);
		model.addAttribute("auftragStatus",String.format("Aufträge im Status: \"%s\"", realStatus.getText()));
		model.addAttribute("auftraege", listedAuftraege);
		return "offeneAuftraege";
	}

	private List<Auftrag> listFilteredAuftraege(Principal principal, int status, String police) {
		List<Auftrag> listAllAuftraege = listAllAuftraege(principal,police);
		if(status != -1) {
			final Auftragstatus realStatus = Auftragstatus.findByNummer(status);
			listAllAuftraege = listAllAuftraege.stream()
						.filter(auftrag -> realStatus.equals(auftrag.getStatus())).collect(Collectors.toList());
		}
		return listAllAuftraege;
	}
	
	private List<Auftrag> listAllAuftraege(Principal principal,String police){
		Benutzer b = benutzerService.findUserByEmail(principal.getName());
		Versicherungsnehmer v = null;
		if(StringUtils.isNotBlank(police) && !(b instanceof Versicherungsnehmer)) {
			v = benutzerService.findVersicherungsnehmerByPolice(police);
		}
		return auftragService.listAuftraege(b, v);
	}
	
	
}
