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

package com.innominds.portlets.service.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link NapierUserService}.
 *
 * @author Brian Wing Shun Chan
 * @see NapierUserService
 * @generated
 */
public class NapierUserServiceWrapper implements NapierUserService,
	ServiceWrapper<NapierUserService> {
	public NapierUserServiceWrapper(NapierUserService napierUserService) {
		_napierUserService = napierUserService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _napierUserService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_napierUserService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _napierUserService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public NapierUserService getWrappedNapierUserService() {
		return _napierUserService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedNapierUserService(NapierUserService napierUserService) {
		_napierUserService = napierUserService;
	}

	@Override
	public NapierUserService getWrappedService() {
		return _napierUserService;
	}

	@Override
	public void setWrappedService(NapierUserService napierUserService) {
		_napierUserService = napierUserService;
	}

	private NapierUserService _napierUserService;
}