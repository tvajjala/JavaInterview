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

package com.innominds.portlets.service.service.impl;

import com.innominds.portlets.service.NoSuchNapierUserException;
import com.innominds.portlets.service.model.NapierUser;
import com.innominds.portlets.service.service.base.NapierUserLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the napier user local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.innominds.portlets.service.service.NapierUserLocalService}
 * interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author Brian Wing Shun Chan
 * @see com.innominds.portlets.service.service.base.NapierUserLocalServiceBaseImpl
 * @see com.innominds.portlets.service.service.NapierUserLocalServiceUtil
 */
public class NapierUserLocalServiceImpl extends NapierUserLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * com.innominds.portlets.service.service.NapierUserLocalServiceUtil} to
	 * access the napier user local service.
	 */

	public NapierUser getUserByMR(String mrNumber) throws NoSuchNapierUserException,
			SystemException {
		return napierUserPersistence.findByMR(mrNumber);
	}

	public NapierUser getUserByCredentials(String username, String password)
			throws NoSuchNapierUserException, SystemException {
		return napierUserPersistence.findByCredentials(username, password);
	}

}