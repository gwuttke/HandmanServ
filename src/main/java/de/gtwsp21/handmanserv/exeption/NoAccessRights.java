package de.gtwsp21.handmanserv.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.FORBIDDEN, reason="Sie haben kein Recht das Dokument zu sehen")  // 403
public class NoAccessRights extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 454069059107235461L;
	
}
