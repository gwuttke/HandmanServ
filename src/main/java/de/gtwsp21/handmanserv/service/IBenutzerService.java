package de.gtwsp21.handmanserv.service;

import java.util.Optional;

import de.gtwsp21.handmanserv.command.BenutzerCommand;
import de.gtwsp21.handmanserv.domain.Benutzer;
import de.gtwsp21.handmanserv.domain.PasswortToken;
import de.gtwsp21.handmanserv.exception.BenutzerExistiertSchonException;
import de.gtwsp21.handmanserv.model.RegistrierenModel;

public interface IBenutzerService {

	PasswortToken createVerificationTokenForUser(Benutzer user, String token);

    PasswortToken getVerificationToken(String VerificationToken);

	PasswortToken generateNewPasswortToken(String token);
        
    Benutzer findUserByEmail(String email);
    
    void changeBenutzerPassword(Benutzer user, String password);

    boolean checkIfValidOldPassword(Benutzer user, String password);

    Optional<Benutzer> getUserByPasswordToken(String token);

    Optional<Benutzer> getUserByID(long id);

	void saveRegisteredUser(Benutzer user);

	String validatePasswortToken(String token);

	Benutzer registerNewUserAccount(BenutzerCommand accountDto) throws BenutzerExistiertSchonException;

	PasswortToken createVerificationTokenForUser(Benutzer user);

	RegistrierenModel loadRegistration();


}
