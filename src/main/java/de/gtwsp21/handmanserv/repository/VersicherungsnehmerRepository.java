package de.gtwsp21.handmanserv.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.gtwsp21.handmanserv.domain.Versicherungsnehmer;

public interface VersicherungsnehmerRepository extends JpaRepository<Versicherungsnehmer, Long> {
	
	Versicherungsnehmer findByPolicennummer(String policennummer);

}
