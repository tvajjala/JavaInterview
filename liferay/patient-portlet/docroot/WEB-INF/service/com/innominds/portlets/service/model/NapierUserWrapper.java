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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link NapierUser}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see NapierUser
 * @generated
 */
public class NapierUserWrapper implements NapierUser, ModelWrapper<NapierUser> {
	public NapierUserWrapper(NapierUser napierUser) {
		_napierUser = napierUser;
	}

	@Override
	public Class<?> getModelClass() {
		return NapierUser.class;
	}

	@Override
	public String getModelClassName() {
		return NapierUser.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("id", getId());
		attributes.put("liferayUserId", getLiferayUserId());
		attributes.put("userType", getUserType());
		attributes.put("mrNumber", getMrNumber());
		attributes.put("tpaId", getTpaId());
		attributes.put("coroporateId", getCoroporateId());
		attributes.put("patientId", getPatientId());
		attributes.put("age", getAge());
		attributes.put("mobile", getMobile());
		attributes.put("gender", getGender());
		attributes.put("address", getAddress());
		attributes.put("specialization", getSpecialization());
		attributes.put("firstname", getFirstname());
		attributes.put("lastname", getLastname());
		attributes.put("username", getUsername());
		attributes.put("password", getPassword());
		attributes.put("email", getEmail());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String liferayUserId = (String)attributes.get("liferayUserId");

		if (liferayUserId != null) {
			setLiferayUserId(liferayUserId);
		}

		String userType = (String)attributes.get("userType");

		if (userType != null) {
			setUserType(userType);
		}

		String mrNumber = (String)attributes.get("mrNumber");

		if (mrNumber != null) {
			setMrNumber(mrNumber);
		}

		String tpaId = (String)attributes.get("tpaId");

		if (tpaId != null) {
			setTpaId(tpaId);
		}

		String coroporateId = (String)attributes.get("coroporateId");

		if (coroporateId != null) {
			setCoroporateId(coroporateId);
		}

		String patientId = (String)attributes.get("patientId");

		if (patientId != null) {
			setPatientId(patientId);
		}

		Integer age = (Integer)attributes.get("age");

		if (age != null) {
			setAge(age);
		}

		String mobile = (String)attributes.get("mobile");

		if (mobile != null) {
			setMobile(mobile);
		}

		String gender = (String)attributes.get("gender");

		if (gender != null) {
			setGender(gender);
		}

		String address = (String)attributes.get("address");

		if (address != null) {
			setAddress(address);
		}

		String specialization = (String)attributes.get("specialization");

		if (specialization != null) {
			setSpecialization(specialization);
		}

		String firstname = (String)attributes.get("firstname");

		if (firstname != null) {
			setFirstname(firstname);
		}

		String lastname = (String)attributes.get("lastname");

		if (lastname != null) {
			setLastname(lastname);
		}

		String username = (String)attributes.get("username");

		if (username != null) {
			setUsername(username);
		}

		String password = (String)attributes.get("password");

		if (password != null) {
			setPassword(password);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}
	}

	/**
	* Returns the primary key of this napier user.
	*
	* @return the primary key of this napier user
	*/
	@Override
	public long getPrimaryKey() {
		return _napierUser.getPrimaryKey();
	}

	/**
	* Sets the primary key of this napier user.
	*
	* @param primaryKey the primary key of this napier user
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_napierUser.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this napier user.
	*
	* @return the uuid of this napier user
	*/
	@Override
	public java.lang.String getUuid() {
		return _napierUser.getUuid();
	}

	/**
	* Sets the uuid of this napier user.
	*
	* @param uuid the uuid of this napier user
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_napierUser.setUuid(uuid);
	}

	/**
	* Returns the ID of this napier user.
	*
	* @return the ID of this napier user
	*/
	@Override
	public long getId() {
		return _napierUser.getId();
	}

	/**
	* Sets the ID of this napier user.
	*
	* @param id the ID of this napier user
	*/
	@Override
	public void setId(long id) {
		_napierUser.setId(id);
	}

	/**
	* Returns the liferay user ID of this napier user.
	*
	* @return the liferay user ID of this napier user
	*/
	@Override
	public java.lang.String getLiferayUserId() {
		return _napierUser.getLiferayUserId();
	}

	/**
	* Sets the liferay user ID of this napier user.
	*
	* @param liferayUserId the liferay user ID of this napier user
	*/
	@Override
	public void setLiferayUserId(java.lang.String liferayUserId) {
		_napierUser.setLiferayUserId(liferayUserId);
	}

	/**
	* Returns the user type of this napier user.
	*
	* @return the user type of this napier user
	*/
	@Override
	public java.lang.String getUserType() {
		return _napierUser.getUserType();
	}

	/**
	* Sets the user type of this napier user.
	*
	* @param userType the user type of this napier user
	*/
	@Override
	public void setUserType(java.lang.String userType) {
		_napierUser.setUserType(userType);
	}

	/**
	* Returns the mr number of this napier user.
	*
	* @return the mr number of this napier user
	*/
	@Override
	public java.lang.String getMrNumber() {
		return _napierUser.getMrNumber();
	}

	/**
	* Sets the mr number of this napier user.
	*
	* @param mrNumber the mr number of this napier user
	*/
	@Override
	public void setMrNumber(java.lang.String mrNumber) {
		_napierUser.setMrNumber(mrNumber);
	}

	/**
	* Returns the tpa ID of this napier user.
	*
	* @return the tpa ID of this napier user
	*/
	@Override
	public java.lang.String getTpaId() {
		return _napierUser.getTpaId();
	}

	/**
	* Sets the tpa ID of this napier user.
	*
	* @param tpaId the tpa ID of this napier user
	*/
	@Override
	public void setTpaId(java.lang.String tpaId) {
		_napierUser.setTpaId(tpaId);
	}

	/**
	* Returns the coroporate ID of this napier user.
	*
	* @return the coroporate ID of this napier user
	*/
	@Override
	public java.lang.String getCoroporateId() {
		return _napierUser.getCoroporateId();
	}

	/**
	* Sets the coroporate ID of this napier user.
	*
	* @param coroporateId the coroporate ID of this napier user
	*/
	@Override
	public void setCoroporateId(java.lang.String coroporateId) {
		_napierUser.setCoroporateId(coroporateId);
	}

	/**
	* Returns the patient ID of this napier user.
	*
	* @return the patient ID of this napier user
	*/
	@Override
	public java.lang.String getPatientId() {
		return _napierUser.getPatientId();
	}

	/**
	* Sets the patient ID of this napier user.
	*
	* @param patientId the patient ID of this napier user
	*/
	@Override
	public void setPatientId(java.lang.String patientId) {
		_napierUser.setPatientId(patientId);
	}

	/**
	* Returns the age of this napier user.
	*
	* @return the age of this napier user
	*/
	@Override
	public int getAge() {
		return _napierUser.getAge();
	}

	/**
	* Sets the age of this napier user.
	*
	* @param age the age of this napier user
	*/
	@Override
	public void setAge(int age) {
		_napierUser.setAge(age);
	}

	/**
	* Returns the mobile of this napier user.
	*
	* @return the mobile of this napier user
	*/
	@Override
	public java.lang.String getMobile() {
		return _napierUser.getMobile();
	}

	/**
	* Sets the mobile of this napier user.
	*
	* @param mobile the mobile of this napier user
	*/
	@Override
	public void setMobile(java.lang.String mobile) {
		_napierUser.setMobile(mobile);
	}

	/**
	* Returns the gender of this napier user.
	*
	* @return the gender of this napier user
	*/
	@Override
	public java.lang.String getGender() {
		return _napierUser.getGender();
	}

	/**
	* Sets the gender of this napier user.
	*
	* @param gender the gender of this napier user
	*/
	@Override
	public void setGender(java.lang.String gender) {
		_napierUser.setGender(gender);
	}

	/**
	* Returns the address of this napier user.
	*
	* @return the address of this napier user
	*/
	@Override
	public java.lang.String getAddress() {
		return _napierUser.getAddress();
	}

	/**
	* Sets the address of this napier user.
	*
	* @param address the address of this napier user
	*/
	@Override
	public void setAddress(java.lang.String address) {
		_napierUser.setAddress(address);
	}

	/**
	* Returns the specialization of this napier user.
	*
	* @return the specialization of this napier user
	*/
	@Override
	public java.lang.String getSpecialization() {
		return _napierUser.getSpecialization();
	}

	/**
	* Sets the specialization of this napier user.
	*
	* @param specialization the specialization of this napier user
	*/
	@Override
	public void setSpecialization(java.lang.String specialization) {
		_napierUser.setSpecialization(specialization);
	}

	/**
	* Returns the firstname of this napier user.
	*
	* @return the firstname of this napier user
	*/
	@Override
	public java.lang.String getFirstname() {
		return _napierUser.getFirstname();
	}

	/**
	* Sets the firstname of this napier user.
	*
	* @param firstname the firstname of this napier user
	*/
	@Override
	public void setFirstname(java.lang.String firstname) {
		_napierUser.setFirstname(firstname);
	}

	/**
	* Returns the lastname of this napier user.
	*
	* @return the lastname of this napier user
	*/
	@Override
	public java.lang.String getLastname() {
		return _napierUser.getLastname();
	}

	/**
	* Sets the lastname of this napier user.
	*
	* @param lastname the lastname of this napier user
	*/
	@Override
	public void setLastname(java.lang.String lastname) {
		_napierUser.setLastname(lastname);
	}

	/**
	* Returns the username of this napier user.
	*
	* @return the username of this napier user
	*/
	@Override
	public java.lang.String getUsername() {
		return _napierUser.getUsername();
	}

	/**
	* Sets the username of this napier user.
	*
	* @param username the username of this napier user
	*/
	@Override
	public void setUsername(java.lang.String username) {
		_napierUser.setUsername(username);
	}

	/**
	* Returns the password of this napier user.
	*
	* @return the password of this napier user
	*/
	@Override
	public java.lang.String getPassword() {
		return _napierUser.getPassword();
	}

	/**
	* Sets the password of this napier user.
	*
	* @param password the password of this napier user
	*/
	@Override
	public void setPassword(java.lang.String password) {
		_napierUser.setPassword(password);
	}

	/**
	* Returns the email of this napier user.
	*
	* @return the email of this napier user
	*/
	@Override
	public java.lang.String getEmail() {
		return _napierUser.getEmail();
	}

	/**
	* Sets the email of this napier user.
	*
	* @param email the email of this napier user
	*/
	@Override
	public void setEmail(java.lang.String email) {
		_napierUser.setEmail(email);
	}

	@Override
	public boolean isNew() {
		return _napierUser.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_napierUser.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _napierUser.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_napierUser.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _napierUser.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _napierUser.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_napierUser.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _napierUser.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_napierUser.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_napierUser.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_napierUser.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new NapierUserWrapper((NapierUser)_napierUser.clone());
	}

	@Override
	public int compareTo(
		com.innominds.portlets.service.model.NapierUser napierUser) {
		return _napierUser.compareTo(napierUser);
	}

	@Override
	public int hashCode() {
		return _napierUser.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.innominds.portlets.service.model.NapierUser> toCacheModel() {
		return _napierUser.toCacheModel();
	}

	@Override
	public com.innominds.portlets.service.model.NapierUser toEscapedModel() {
		return new NapierUserWrapper(_napierUser.toEscapedModel());
	}

	@Override
	public com.innominds.portlets.service.model.NapierUser toUnescapedModel() {
		return new NapierUserWrapper(_napierUser.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _napierUser.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _napierUser.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_napierUser.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof NapierUserWrapper)) {
			return false;
		}

		NapierUserWrapper napierUserWrapper = (NapierUserWrapper)obj;

		if (Validator.equals(_napierUser, napierUserWrapper._napierUser)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public NapierUser getWrappedNapierUser() {
		return _napierUser;
	}

	@Override
	public NapierUser getWrappedModel() {
		return _napierUser;
	}

	@Override
	public void resetOriginalValues() {
		_napierUser.resetOriginalValues();
	}

	private NapierUser _napierUser;
}