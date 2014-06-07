/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.innominds.portlets.service.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.innominds.portlets.service.service.http.NapierUserServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.innominds.portlets.service.service.http.NapierUserServiceSoap
 * @generated
 */
public class NapierUserSoap implements Serializable {
	public static NapierUserSoap toSoapModel(NapierUser model) {
		NapierUserSoap soapModel = new NapierUserSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setId(model.getId());
		soapModel.setLiferayUserId(model.getLiferayUserId());
		soapModel.setUserType(model.getUserType());
		soapModel.setMrNumber(model.getMrNumber());
		soapModel.setTpaId(model.getTpaId());
		soapModel.setCoroporateId(model.getCoroporateId());
		soapModel.setPatientId(model.getPatientId());
		soapModel.setAge(model.getAge());
		soapModel.setMobile(model.getMobile());
		soapModel.setGender(model.getGender());
		soapModel.setAddress(model.getAddress());
		soapModel.setSpecialization(model.getSpecialization());
		soapModel.setFirstname(model.getFirstname());
		soapModel.setLastname(model.getLastname());
		soapModel.setUsername(model.getUsername());
		soapModel.setPassword(model.getPassword());
		soapModel.setEmail(model.getEmail());

		return soapModel;
	}

	public static NapierUserSoap[] toSoapModels(NapierUser[] models) {
		NapierUserSoap[] soapModels = new NapierUserSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static NapierUserSoap[][] toSoapModels(NapierUser[][] models) {
		NapierUserSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new NapierUserSoap[models.length][models[0].length];
		}
		else {
			soapModels = new NapierUserSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static NapierUserSoap[] toSoapModels(List<NapierUser> models) {
		List<NapierUserSoap> soapModels = new ArrayList<NapierUserSoap>(models.size());

		for (NapierUser model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new NapierUserSoap[soapModels.size()]);
	}

	public NapierUserSoap() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public String getLiferayUserId() {
		return _liferayUserId;
	}

	public void setLiferayUserId(String liferayUserId) {
		_liferayUserId = liferayUserId;
	}

	public String getUserType() {
		return _userType;
	}

	public void setUserType(String userType) {
		_userType = userType;
	}

	public String getMrNumber() {
		return _mrNumber;
	}

	public void setMrNumber(String mrNumber) {
		_mrNumber = mrNumber;
	}

	public String getTpaId() {
		return _tpaId;
	}

	public void setTpaId(String tpaId) {
		_tpaId = tpaId;
	}

	public String getCoroporateId() {
		return _coroporateId;
	}

	public void setCoroporateId(String coroporateId) {
		_coroporateId = coroporateId;
	}

	public String getPatientId() {
		return _patientId;
	}

	public void setPatientId(String patientId) {
		_patientId = patientId;
	}

	public int getAge() {
		return _age;
	}

	public void setAge(int age) {
		_age = age;
	}

	public String getMobile() {
		return _mobile;
	}

	public void setMobile(String mobile) {
		_mobile = mobile;
	}

	public String getGender() {
		return _gender;
	}

	public void setGender(String gender) {
		_gender = gender;
	}

	public String getAddress() {
		return _address;
	}

	public void setAddress(String address) {
		_address = address;
	}

	public String getSpecialization() {
		return _specialization;
	}

	public void setSpecialization(String specialization) {
		_specialization = specialization;
	}

	public String getFirstname() {
		return _firstname;
	}

	public void setFirstname(String firstname) {
		_firstname = firstname;
	}

	public String getLastname() {
		return _lastname;
	}

	public void setLastname(String lastname) {
		_lastname = lastname;
	}

	public String getUsername() {
		return _username;
	}

	public void setUsername(String username) {
		_username = username;
	}

	public String getPassword() {
		return _password;
	}

	public void setPassword(String password) {
		_password = password;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	private String _uuid;
	private long _id;
	private String _liferayUserId;
	private String _userType;
	private String _mrNumber;
	private String _tpaId;
	private String _coroporateId;
	private String _patientId;
	private int _age;
	private String _mobile;
	private String _gender;
	private String _address;
	private String _specialization;
	private String _firstname;
	private String _lastname;
	private String _username;
	private String _password;
	private String _email;
}