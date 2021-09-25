package de.gtwsp21.handmanserv.exception;

public final class BenutzerExistiertSchonException extends RuntimeException {

	private static final long serialVersionUID = -1866655991191271949L;

	public BenutzerExistiertSchonException() {
        super();
    }

    public BenutzerExistiertSchonException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public BenutzerExistiertSchonException(final String message) {
        super(message);
    }

    public BenutzerExistiertSchonException(final Throwable cause) {
        super(cause);
    }

}
