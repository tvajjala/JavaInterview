package com.suretouch.core.domain.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;

import com.suretouch.core.domain.SureTouchObjectType;
import com.suretouch.core.domain.UUIDGenerator;

@Entity
public class Clinic extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 3297261925561359734L;

	public Clinic() {
	}

	@Id
	@Column(name = "CLINIC_ID", unique = true, nullable = false, insertable = true, updatable = true, length = 36)
	private String clinicId;

	@Column(name = "name", nullable = false, unique = true)
	private String name;
	
	private boolean active;
	
	public boolean isActive() {
		return active;
	}
	
	public void setActive(boolean active) {
		this.active = active;
	}

	public Clinic(String name) {
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
	
	
	
	@PrePersist
	public void generateId() {
		if (clinicId == null) {
			setClinicId(UUIDGenerator.generateUUID(
					SureTouchObjectType.CLINIC.getObjectType(), this.getClass()));
		}
	}

}
