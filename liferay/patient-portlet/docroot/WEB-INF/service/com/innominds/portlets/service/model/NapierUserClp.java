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

import com.innominds.portlets.service.service.ClpSerializer;
import com.innominds.portlets.service.service.NapierUserLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class NapierUserClp extends BaseModelImpl<NapierUser>
	implements NapierUser {
	public NapierUserClp() {
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
	public long getPrimaryKey() {
		return _id;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _id;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_napierUserRemoteModel != null) {
			try {
				Class<?> clazz = _napierUserRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_napierUserRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getId() {
		return _id;
	}

	@Override
	public void setId(long id) {
		_id = id;

		if (_napierUserRemoteModel != null) {
			try {
				Class<?> clazz = _napierUserRemoteModel.getClass();

				Method method = clazz.getMethod("setId", long.class);

				method.invoke(_napierUserRemoteModel, id);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLiferayUserId() {
		return _liferayUserId;
	}

	@Override
	public void setLiferayUserId(String liferayUserId) {
		_liferayUserId = liferayUserId;

		if (_napierUserRemoteModel != null) {
			try {
				Class<?> clazz = _napierUserRemoteModel.getClass();

				Method method = clazz.getMethod("setLiferayUserId", String.class);

				method.invoke(_napierUserRemoteModel, liferayUserId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserType() {
		return _userType;
	}

	@Override
	public void setUserType(String userType) {
		_userType = userType;

		if (_napierUserRemoteModel != null) {
			try {
				Class<?> clazz = _napierUserRemoteModel.getClass();

				Method method = clazz.getMethod("setUserType", String.class);

				method.invoke(_napierUserRemoteModel, userType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMrNumber() {
		return _mrNumber;
	}

	@Override
	public void setMrNumber(String mrNumber) {
		_mrNumber = mrNumber;

		if (_napierUserRemoteModel != null) {
			try {
				Class<?> clazz = _napierUserRemoteModel.getClass();

				Method method = clazz.getMethod("setMrNumber", String.class);

				method.invoke(_napierUserRemoteModel, mrNumber);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTpaId() {
		return _tpaId;
	}

	@Override
	public void setTpaId(String tpaId) {
		_tpaId = tpaId;

		if (_napierUserRemoteModel != null) {
			try {
				Class<?> clazz = _napierUserRemoteModel.getClass();

				Method method = clazz.getMethod("setTpaId", String.class);

				method.invoke(_napierUserRemoteModel, tpaId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCoroporateId() {
		return _coroporateId;
	}

	@Override
	public void setCoroporateId(String coroporateId) {
		_coroporateId = coroporateId;

		if (_napierUserRemoteModel != null) {
			try {
				Class<?> clazz = _napierUserRemoteModel.getClass();

				Method method = clazz.getMethod("setCoroporateId", String.class);

				method.invoke(_napierUserRemoteModel, coroporateId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPatientId() {
		return _patientId;
	}

	@Override
	public void setPatientId(String patientId) {
		_patientId = patientId;

		if (_napierUserRemoteModel != null) {
			try {
				Class<?> clazz = _napierUserRemoteModel.getClass();

				Method method = clazz.getMethod("setPatientId", String.class);

				method.invoke(_napierUserRemoteModel, patientId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getAge() {
		return _age;
	}

	@Override
	public void setAge(int age) {
		_age = age;

		if (_napierUserRemoteModel != null) {
			try {
				Class<?> clazz = _napierUserRemoteModel.getClass();

				Method method = clazz.getMethod("setAge", int.class);

				method.invoke(_napierUserRemoteModel, age);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMobile() {
		return _mobile;
	}

	@Override
	public void setMobile(String mobile) {
		_mobile = mobile;

		if (_napierUserRemoteModel != null) {
			try {
				Class<?> clazz = _napierUserRemoteModel.getClass();

				Method method = clazz.getMethod("setMobile", String.class);

				method.invoke(_napierUserRemoteModel, mobile);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getGender() {
		return _gender;
	}

	@Override
	public void setGender(String gender) {
		_gender = gender;

		if (_napierUserRemoteModel != null) {
			try {
				Class<?> clazz = _napierUserRemoteModel.getClass();

				Method method = clazz.getMethod("setGender", String.class);

				method.invoke(_napierUserRemoteModel, gender);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAddress() {
		return _address;
	}

	@Override
	public void setAddress(String address) {
		_address = address;

		if (_napierUserRemoteModel != null) {
			try {
				Class<?> clazz = _napierUserRemoteModel.getClass();

				Method method = clazz.getMethod("setAddress", String.class);

				method.invoke(_napierUserRemoteModel, address);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSpecialization() {
		return _specialization;
	}

	@Override
	public void setSpecialization(String specialization) {
		_specialization = specialization;

		if (_napierUserRemoteModel != null) {
			try {
				Class<?> clazz = _napierUserRemoteModel.getClass();

				Method method = clazz.getMethod("setSpecialization",
						String.class);

				method.invoke(_napierUserRemoteModel, specialization);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFirstname() {
		return _firstname;
	}

	@Override
	public void setFirstname(String firstname) {
		_firstname = firstname;

		if (_napierUserRemoteModel != null) {
			try {
				Class<?> clazz = _napierUserRemoteModel.getClass();

				Method method = clazz.getMethod("setFirstname", String.class);

				method.invoke(_napierUserRemoteModel, firstname);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLastname() {
		return _lastname;
	}

	@Override
	public void setLastname(String lastname) {
		_lastname = lastname;

		if (_napierUserRemoteModel != null) {
			try {
				Class<?> clazz = _napierUserRemoteModel.getClass();

				Method method = clazz.getMethod("setLastname", String.class);

				method.invoke(_napierUserRemoteModel, lastname);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUsername() {
		return _username;
	}

	@Override
	public void setUsername(String username) {
		_username = username;

		if (_napierUserRemoteModel != null) {
			try {
				Class<?> clazz = _napierUserRemoteModel.getClass();

				Method method = clazz.getMethod("setUsername", String.class);

				method.invoke(_napierUserRemoteModel, username);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPassword() {
		return _password;
	}

	@Override
	public void setPassword(String password) {
		_password = password;

		if (_napierUserRemoteModel != null) {
			try {
				Class<?> clazz = _napierUserRemoteModel.getClass();

				Method method = clazz.getMethod("setPassword", String.class);

				method.invoke(_napierUserRemoteModel, password);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEmail() {
		return _email;
	}

	@Override
	public void setEmail(String email) {
		_email = email;

		if (_napierUserRemoteModel != null) {
			try {
				Class<?> clazz = _napierUserRemoteModel.getClass();

				Method method = clazz.getMethod("setEmail", String.class);

				method.invoke(_napierUserRemoteModel, email);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getNapierUserRemoteModel() {
		return _napierUserRemoteModel;
	}

	public void setNapierUserRemoteModel(BaseModel<?> napierUserRemoteModel) {
		_napierUserRemoteModel = napierUserRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _napierUserRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_napierUserRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			NapierUserLocalServiceUtil.addNapierUser(this);
		}
		else {
			NapierUserLocalServiceUtil.updateNapierUser(this);
		}
	}

	@Override
	public NapierUser toEscapedModel() {
		return (NapierUser)ProxyUtil.newProxyInstance(NapierUser.class.getClassLoader(),
			new Class[] { NapierUser.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		NapierUserClp clone = new NapierUserClp();

		clone.setUuid(getUuid());
		clone.setId(getId());
		clone.setLiferayUserId(getLiferayUserId());
		clone.setUserType(getUserType());
		clone.setMrNumber(getMrNumber());
		clone.setTpaId(getTpaId());
		clone.setCoroporateId(getCoroporateId());
		clone.setPatientId(getPatientId());
		clone.setAge(getAge());
		clone.setMobile(getMobile());
		clone.setGender(getGender());
		clone.setAddress(getAddress());
		clone.setSpecialization(getSpecialization());
		clone.setFirstname(getFirstname());
		clone.setLastname(getLastname());
		clone.setUsername(getUsername());
		clone.setPassword(getPassword());
		clone.setEmail(getEmail());

		return clone;
	}

	@Override
	public int compareTo(NapierUser napierUser) {
		int value = 0;

		value = getMrNumber().compareTo(napierUser.getMrNumber());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof NapierUserClp)) {
			return false;
		}

		NapierUserClp napierUser = (NapierUserClp)obj;

		long primaryKey = napierUser.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", id=");
		sb.append(getId());
		sb.append(", liferayUserId=");
		sb.append(getLiferayUserId());
		sb.append(", userType=");
		sb.append(getUserType());
		sb.append(", mrNumber=");
		sb.append(getMrNumber());
		sb.append(", tpaId=");
		sb.append(getTpaId());
		sb.append(", coroporateId=");
		sb.append(getCoroporateId());
		sb.append(", patientId=");
		sb.append(getPatientId());
		sb.append(", age=");
		sb.append(getAge());
		sb.append(", mobile=");
		sb.append(getMobile());
		sb.append(", gender=");
		sb.append(getGender());
		sb.append(", address=");
		sb.append(getAddress());
		sb.append(", specialization=");
		sb.append(getSpecialization());
		sb.append(", firstname=");
		sb.append(getFirstname());
		sb.append(", lastname=");
		sb.append(getLastname());
		sb.append(", username=");
		sb.append(getUsername());
		sb.append(", password=");
		sb.append(getPassword());
		sb.append(", email=");
		sb.append(getEmail());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(58);

		sb.append("<model><model-name>");
		sb.append("com.innominds.portlets.service.model.NapierUser");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>liferayUserId</column-name><column-value><![CDATA[");
		sb.append(getLiferayUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userType</column-name><column-value><![CDATA[");
		sb.append(getUserType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mrNumber</column-name><column-value><![CDATA[");
		sb.append(getMrNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tpaId</column-name><column-value><![CDATA[");
		sb.append(getTpaId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>coroporateId</column-name><column-value><![CDATA[");
		sb.append(getCoroporateId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>patientId</column-name><column-value><![CDATA[");
		sb.append(getPatientId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>age</column-name><column-value><![CDATA[");
		sb.append(getAge());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mobile</column-name><column-value><![CDATA[");
		sb.append(getMobile());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>gender</column-name><column-value><![CDATA[");
		sb.append(getGender());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>address</column-name><column-value><![CDATA[");
		sb.append(getAddress());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>specialization</column-name><column-value><![CDATA[");
		sb.append(getSpecialization());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>firstname</column-name><column-value><![CDATA[");
		sb.append(getFirstname());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastname</column-name><column-value><![CDATA[");
		sb.append(getLastname());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>username</column-name><column-value><![CDATA[");
		sb.append(getUsername());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>password</column-name><column-value><![CDATA[");
		sb.append(getPassword());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>email</column-name><column-value><![CDATA[");
		sb.append(getEmail());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
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
	private BaseModel<?> _napierUserRemoteModel;
}