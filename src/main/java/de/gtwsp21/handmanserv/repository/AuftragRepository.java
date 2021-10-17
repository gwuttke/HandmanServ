package de.gtwsp21.handmanserv.repository;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.gtwsp21.handmanserv.domain.Adresse;
import de.gtwsp21.handmanserv.domain.Auftrag;
import de.gtwsp21.handmanserv.domain.Auftragstatus;
import de.gtwsp21.handmanserv.domain.Bauherr;
import de.gtwsp21.handmanserv.domain.Benutzer;
import de.gtwsp21.handmanserv.domain.Gebiet;
import de.gtwsp21.handmanserv.domain.Versicherungsnehmer;

@Repository
public interface AuftragRepository extends JpaRepository<Auftrag, Long> {

	List<Auftrag> findByStatus(Auftragstatus status);
	
	List<Auftrag> findByVersicherungsnehmer(Versicherungsnehmer versicherungsnehmer);
	
	List<Auftrag> findByNummer(String nummer);
	
	List<Auftrag> findByAngelegtVon(Benutzer benutzer);
	
	List<Auftrag> findByAdresse(Adresse adresse);
	
	List<Auftrag> findByBauherr(Bauherr bauherr);
	
	List<Auftrag> findByAdresseGebietInAndBauherr(Collection<Gebiet> gebiet,Bauherr bauherr);
	
	long countByErstellungsdatumBetween(LocalDateTime beginn, LocalDateTime end);
	
	
}
