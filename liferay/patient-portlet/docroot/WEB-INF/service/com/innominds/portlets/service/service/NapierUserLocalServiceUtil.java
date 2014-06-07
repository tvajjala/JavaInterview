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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for NapierUser. This utility wraps
 * {@link com.innominds.portlets.service.service.impl.NapierUserLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see NapierUserLocalService
 * @see com.innominds.portlets.service.service.base.NapierUserLocalServiceBaseImpl
 * @see com.innominds.portlets.service.service.impl.NapierUserLocalServiceImpl
 * @generated
 */
public class NapierUserLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.innominds.portlets.service.service.impl.NapierUserLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the napier user to the database. Also notifies the appropriate model listeners.
	*
	* @param napierUser the napier user
	* @return the napier user that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.innominds.portlets.service.model.NapierUser addNapierUser(
		com.innominds.portlets.service.model.NapierUser napierUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addNapierUser(napierUser);
	}

	/**
	* Creates a new napier user with the primary key. Does not add the napier user to the database.
	*
	* @param id the primary key for the new napier user
	* @return the new napier user
	*/
	public static com.innominds.portlets.service.model.NapierUser createNapierUser(
		long id) {
		return getService().createNapierUser(id);
	}

	/**
	* Deletes the napier user with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the napier user
	* @return the napier user that was removed
	* @throws PortalException if a napier user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.innominds.portlets.service.model.NapierUser deleteNapierUser(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteNapierUser(id);
	}

	/**
	* Deletes the napier user from the database. Also notifies the appropriate model listeners.
	*
	* @param napierUser the napier user
	* @return the napier user that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.innominds.portlets.service.model.NapierUser deleteNapierUser(
		com.innominds.portlets.service.model.NapierUser napierUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteNapierUser(napierUser);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.innominds.portlets.service.model.impl.NapierUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.innominds.portlets.service.model.impl.NapierUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.innominds.portlets.service.model.NapierUser fetchNapierUser(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchNapierUser(id);
	}

	/**
	* Returns the napier user with the primary key.
	*
	* @param id the primary key of the napier user
	* @return the napier user
	* @throws PortalException if a napier user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.innominds.portlets.service.model.NapierUser getNapierUser(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getNapierUser(id);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the napier users.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.innominds.portlets.service.model.impl.NapierUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of napier users
	* @param end the upper bound of the range of napier users (not inclusive)
	* @return the range of napier users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.innominds.portlets.service.model.NapierUser> getNapierUsers(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getNapierUsers(start, end);
	}

	/**
	* Returns the number of napier users.
	*
	* @return the number of napier users
	* @throws SystemException if a system exception occurred
	*/
	public static int getNapierUsersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getNapierUsersCount();
	}

	/**
	* Updates the napier user in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param napierUser the napier user
	* @return the napier user that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.innominds.portlets.service.model.NapierUser updateNapierUser(
		com.innominds.portlets.service.model.NapierUser napierUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateNapierUser(napierUser);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static com.innominds.portlets.service.model.NapierUser getUserByMR(
		java.lang.String mrNumber)
		throws com.innominds.portlets.service.NoSuchNapierUserException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserByMR(mrNumber);
	}

	public static com.innominds.portlets.service.model.NapierUser getUserByCredentials(
		java.lang.String username, java.lang.String password)
		throws com.innominds.portlets.service.NoSuchNapierUserException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserByCredentials(username, password);
	}

	public static void clearService() {
		_service = null;
	}

	public static NapierUserLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					NapierUserLocalService.class.getName());

			if (invokableLocalService instanceof NapierUserLocalService) {
				_service = (NapierUserLocalService)invokableLocalService;
			}
			else {
				_service = new NapierUserLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(NapierUserLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(NapierUserLocalService service) {
	}

	private static NapierUserLocalService _service;
}