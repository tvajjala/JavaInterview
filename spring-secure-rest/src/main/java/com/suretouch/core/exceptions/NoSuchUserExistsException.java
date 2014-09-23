package com.suretouch.core.exceptions;

public class NoSuchUserExistsException extends IndexOutOfBoundsException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5473065031570675944L;

	public NoSuchUserExistsException() {

	}

	public NoSuchUserExistsException(String message) {
		super(message);

	}

}
