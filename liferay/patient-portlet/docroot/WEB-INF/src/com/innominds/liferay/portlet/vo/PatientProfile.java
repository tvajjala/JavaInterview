package com.innominds.liferay.portlet.vo;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 
 * @author tvajjala
 * 
 */

public class PatientProfile implements Serializable {

	private static final long serialVersionUID = 1092416193138914488L;

	private String firstname;
	private String lastname;

	private String gender;

	private Timestamp dob;
	private Integer age;

	private String extMR;
	private String intMR;
	private String practiceID;

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Timestamp getDob() {
		return dob;
	}

	public void setDob(Timestamp dob) {
		this.dob = dob;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getExtMR() {
		return extMR;
	}

	public void setExtMR(String extMR) {
		this.extMR = extMR;
	}

	public String getIntMR() {
		return intMR;
	}

	public void setIntMR(String intMR) {
		this.intMR = intMR;
	}

	public String getPracticeID() {
		return practiceID;
	}

	public void setPracticeID(String practiceID) {
		this.practiceID = practiceID;
	}

}
