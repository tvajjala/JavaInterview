package com.suretouch.core.domain;

public enum SureTouchObjectType {
	BASE("BASE"), USER("USER"), DEVICE("WAND"),ROLE("ROLE"),CLINIC("CLNC");

	private String objectType;

	private SureTouchObjectType(String ot) {
		objectType = ot;
	}

	public String getObjectType() {
		return objectType;
	}
}
