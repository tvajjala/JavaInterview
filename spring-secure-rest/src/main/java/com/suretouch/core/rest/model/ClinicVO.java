package com.suretouch.core.rest.model;

import java.io.Serializable;


public class ClinicVO  implements Serializable {

	private static final long serialVersionUID = 3297261925561359734L;

	public ClinicVO() {
	}

	
	private String clinicId;

	private String name;
	
	private boolean active;
	
	public boolean isActive() {
		return active;
	}
	
	public void setActive(boolean active) {
		this.active = active;
	}

	public ClinicVO(String name) {
		this.name = name;
	}

	public String getClinicId() {
		return clinicId;
	}

	public void setClinicId(String clinicId) {
		this.clinicId = clinicId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
		
}
