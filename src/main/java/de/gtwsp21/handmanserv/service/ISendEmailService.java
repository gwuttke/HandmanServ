package de.gtwsp21.handmanserv.service;

import de.gtwsp21.handmanserv.domain.PasswortToken;

public interface ISendEmailService {

	void sendResetTokenEmail(final PasswortToken token);
	
	void sendInitialTokenEmail(PasswortToken token);
	
}
