package com.innominds.liferay.portlet.util;

/*
 * various user types available in the patient portal
 */
public enum UserType {

	PATIENT("Patient"), DOCTOR("Doctor"), CORPORATE("Corporate"), TPA("TPA");

	private String title;

	UserType(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

}
