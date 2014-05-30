package com.designpatterns.prototype;

public class NoBikeAvailableException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2856982286455630791L;

	public NoBikeAvailableException() {
		super();
	}

	NoBikeAvailableException(String s) {
		super(s);
	}
}
