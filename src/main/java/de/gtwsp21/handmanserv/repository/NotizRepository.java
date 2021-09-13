package de.gtwsp21.handmanserv.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.gtwsp21.handmanserv.domain.Notiz;

public interface NotizRepository extends JpaRepository<Notiz, Long> {

}
