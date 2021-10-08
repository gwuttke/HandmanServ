package de.gtwsp21.handmanserv.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.gtwsp21.handmanserv.domain.Rolle;
import de.gtwsp21.handmanserv.domain.compositid.RollenId;

public interface RollenRepository extends JpaRepository<Rolle, RollenId>{

}
