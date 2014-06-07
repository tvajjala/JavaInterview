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

package com.innominds.portlets.service.model.impl;

import com.innominds.portlets.service.model.NapierUser;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing NapierUser in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see NapierUser
 * @generated
 */
public class NapierUserCacheModel implements CacheModel<NapierUser>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", id=");
		sb.append(id);
		sb.append(", liferayUserId=");
		sb.append(liferayUserId);
		sb.append(", userType=");
		sb.append(userType);
		sb.append(", mrNumber=");
		sb.append(mrNumber);
		sb.append(", tpaId=");
		sb.append(tpaId);
		sb.append(", coroporateId=");
		sb.append(coroporateId);
		sb.append(", patientId=");
		sb.append(patientId);
		sb.append(", age=");
		sb.append(age);
		sb.append(", mobile=");
		sb.append(mobile);
		sb.append(", gender=");
		sb.append(gender);
		sb.append(", address=");
		sb.append(address);
		sb.append(", specialization=");
		sb.append(specialization);
		sb.append(", firstname=");
		sb.append(firstname);
		sb.append(", lastname=");
		sb.append(lastname);
		sb.append(", username=");
		sb.append(username);
		sb.append(", password=");
		sb.append(password);
		sb.append(", email=");
		sb.append(email);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public NapierUser toEntityModel() {
		NapierUserImpl napierUserImpl = new NapierUserImpl();

		if (uuid == null) {
			napierUserImpl.setUuid(StringPool.BLANK);
		}
		else {
			napierUserImpl.setUuid(uuid);
		}

		napierUserImpl.setId(id);

		if (liferayUserId == null) {
			napierUserImpl.setLiferayUserId(StringPool.BLANK);
		}
		else {
			napierUserImpl.setLiferayUserId(liferayUserId);
		}

		if (userType == null) {
			napierUserImpl.setUserType(StringPool.BLANK);
		}
		else {
			napierUserImpl.setUserType(userType);
		}

		if (mrNumber == null) {
			napierUserImpl.setMrNumber(StringPool.BLANK);
		}
		else {
			napierUserImpl.setMrNumber(mrNumber);
		}

		if (tpaId == null) {
			napierUserImpl.setTpaId(StringPool.BLANK);
		}
		else {
			napierUserImpl.setTpaId(tpaId);
		}

		if (coroporateId == null) {
			napierUserImpl.setCoroporateId(StringPool.BLANK);
		}
		else {
			napierUserImpl.setCoroporateId(coroporateId);
		}

		if (patientId == null) {
			napierUserImpl.setPatientId(StringPool.BLANK);
		}
		else {
			napierUserImpl.setPatientId(patientId);
		}

		napierUserImpl.setAge(age);

		if (mobile == null) {
			napierUserImpl.setMobile(StringPool.BLANK);
		}
		else {
			napierUserImpl.setMobile(mobile);
		}

		if (gender == null) {
			napierUserImpl.setGender(StringPool.BLANK);
		}
		else {
			napierUserImpl.setGender(gender);
		}

		if (address == null) {
			napierUserImpl.setAddress(StringPool.BLANK);
		}
		else {
			napierUserImpl.setAddress(address);
		}

		if (specialization == null) {
			napierUserImpl.setSpecialization(StringPool.BLANK);
		}
		else {
			napierUserImpl.setSpecialization(specialization);
		}

		if (firstname == null) {
			napierUserImpl.setFirstname(StringPool.BLANK);
		}
		else {
			napierUserImpl.setFirstname(firstname);
		}

		if (lastname == null) {
			napierUserImpl.setLastname(StringPool.BLANK);
		}
		else {
			napierUserImpl.setLastname(lastname);
		}

		if (username == null) {
			napierUserImpl.setUsername(StringPool.BLANK);
		}
		else {
			napierUserImpl.setUsername(username);
		}

		if (password == null) {
			napierUserImpl.setPassword(StringPool.BLANK);
		}
		else {
			napierUserImpl.setPassword(password);
		}

		if (email == null) {
			napierUserImpl.setEmail(StringPool.BLANK);
		}
		else {
			napierUserImpl.setEmail(email);
		}

		napierUserImpl.resetOriginalValues();

		return napierUserImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		id = objectInput.readLong();
		liferayUserId = objectInput.readUTF();
		userType = objectInput.readUTF();
		mrNumber = objectInput.readUTF();
		tpaId = objectInput.readUTF();
		coroporateId = objectInput.readUTF();
		patientId = objectInput.readUTF();
		age = objectInput.readInt();
		mobile = objectInput.readUTF();
		gender = objectInput.readUTF();
		address = objectInput.readUTF();
		specialization = objectInput.readUTF();
		firstname = objectInput.readUTF();
		lastname = objectInput.readUTF();
		username = objectInput.readUTF();
		password = objectInput.readUTF();
		email = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(id);

		if (liferayUserId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(liferayUserId);
		}

		if (userType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userType);
		}

		if (mrNumber == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(mrNumber);
		}

		if (tpaId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(tpaId);
		}

		if (coroporateId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(coroporateId);
		}

		if (patientId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(patientId);
		}

		objectOutput.writeInt(age);

		if (mobile == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(mobile);
		}

		if (gender == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(gender);
		}

		if (address == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(address);
		}

		if (specialization == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(specialization);
		}

		if (firstname == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(firstname);
		}

		if (lastname == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(lastname);
		}

		if (username == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(username);
		}

		if (password == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(password);
		}

		if (email == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(email);
		}
	}

	public String uuid;
	public long id;
	public String liferayUserId;
	public String userType;
	public String mrNumber;
	public String tpaId;
	public String coroporateId;
	public String patientId;
	public int age;
	public String mobile;
	public String gender;
	public String address;
	public String specialization;
	public String firstname;
	public String lastname;
	public String username;
	public String password;
	public String email;
}