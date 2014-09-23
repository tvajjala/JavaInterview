package com.suretouch.core.rest.model;

import java.io.Serializable;

/**
 * 
 * @author tvajjala
 *
 */
public class LoginRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6246413259482259931L;
	private String st_username;
	private String st_password;

	public String getSt_username() {
		return st_username;
	}

	public void setSt_username(String st_username) {
		this.st_username = st_username;
	}

	public String getSt_password() {
		return st_password;
	}

	public void setSt_password(String st_password) {
		this.st_password = st_password;
	}

}
