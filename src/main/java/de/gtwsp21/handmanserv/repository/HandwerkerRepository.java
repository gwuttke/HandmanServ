package de.gtwsp21.handmanserv.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.gtwsp21.handmanserv.domain.Handwerker;

public interface HandwerkerRepository extends JpaRepository<Handwerker, Long> {

}
