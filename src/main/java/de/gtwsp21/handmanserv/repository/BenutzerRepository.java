package de.gtwsp21.handmanserv.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.gtwsp21.handmanserv.domain.Benutzer;

public interface BenutzerRepository extends JpaRepository<Benutzer, Long> {

}
