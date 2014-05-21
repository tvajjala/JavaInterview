package com.trvajjala.entities.product;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ACTIVATIONDEVICETYPE")
public class ActivationDeviceTypeEntity implements Serializable {

	private static final long serialVersionUID = -7927634813015457880L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer deviceTypeId;

	@Column(length = 30, nullable = false, unique = true)
	private String deviceTypeName;

	public Integer getDeviceTypeId() {
		return deviceTypeId;
	}

	public void setDeviceTypeId(Integer deviceTypeId) {
		this.deviceTypeId = deviceTypeId;
	}

	public String getDeviceTypeName() {
		return deviceTypeName;
	}

	public void setDeviceTypeName(String deviceTypeName) {
		this.deviceTypeName = deviceTypeName;
	}

}
