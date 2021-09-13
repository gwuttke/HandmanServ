package de.gtwsp21.handmanserv.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.gtwsp21.handmanserv.domain.Auftrag;

public interface AuftragRepository extends JpaRepository<Auftrag, Long> {

}
