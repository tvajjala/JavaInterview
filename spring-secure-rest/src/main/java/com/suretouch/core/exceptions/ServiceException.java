package com.suretouch.core.exceptions;

/**
 * 
 * @author kgajjala
 * 
 */
public class ServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -104684575336074015L;
	private String errorCode;
	private String errorMessage;

	public ServiceException() {

	}

	public ServiceException(String message) {
		super(message);

	}

	public ServiceException(Throwable cause) {
		super(cause);

	}

	public ServiceException(String message, Throwable cause) {
		super(message, cause);

	}

	public ServiceException(String errorCode, String errorMessage) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
