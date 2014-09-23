package com.adaequare.testng.adtf.exceptions;

import java.sql.SQLException;

import org.hibernate.exception.ConstraintViolationException;

public class UserDataAlreadyExistsException extends
		ConstraintViolationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8622425696546363486L;

	public UserDataAlreadyExistsException(String message, SQLException root,
			String constraintName) {
		super(message, root, constraintName);

	}

}
