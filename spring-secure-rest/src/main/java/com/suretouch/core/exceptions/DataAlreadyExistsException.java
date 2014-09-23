package com.suretouch.core.exceptions;

import java.sql.SQLException;

import org.hibernate.exception.ConstraintViolationException;

public class DataAlreadyExistsException extends
		ConstraintViolationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8622425696546363486L;

	public DataAlreadyExistsException(String message, SQLException root,
			String constraintName) {
		super(message, root, constraintName);

	}

}
