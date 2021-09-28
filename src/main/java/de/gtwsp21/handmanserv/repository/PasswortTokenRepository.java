package de.gtwsp21.handmanserv.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import de.gtwsp21.handmanserv.domain.Benutzer;
import de.gtwsp21.handmanserv.domain.PasswortToken;

public interface PasswortTokenRepository extends JpaRepository<PasswortToken, Long> {
	
	PasswortToken findByToken(String token);

	PasswortToken findByBenutzer(Benutzer user);

	 void deleteByAblaufdatumLessThan(LocalDateTime now);

    @Modifying
    @Query("delete from PasswortToken t where t.ablaufdatum <= ?1")
    void deleteAllAblaufdatumSince(LocalDateTime now);
}
