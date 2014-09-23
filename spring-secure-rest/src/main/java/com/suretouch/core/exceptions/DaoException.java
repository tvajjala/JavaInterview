package com.suretouch.core.exceptions;

/**
 * 
 * @author kgajjala
 *
 */
public class DaoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1113201531161796871L;
	private String errorCode;
	private String errorMessage;
	
	public DaoException() {
		
	}

	public DaoException(String arg0) {
		super(arg0);
	
	}

	public DaoException(Throwable arg0) {
		super(arg0);
		
	}

	public DaoException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	
	}
	
	public DaoException ( String errorCode , String errorMessage)
	{
		this.errorCode = errorCode;
		this.errorMessage =  errorMessage;
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
