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

package com.innominds.portlets.service.service.persistence;

import com.innominds.portlets.service.model.NapierUser;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the napier user service. This utility wraps {@link NapierUserPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see NapierUserPersistence
 * @see NapierUserPersistenceImpl
 * @generated
 */
public class NapierUserUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(NapierUser napierUser) {
		getPersistence().clearCache(napierUser);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<NapierUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<NapierUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<NapierUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static NapierUser update(NapierUser napierUser)
		throws SystemException {
		return getPersistence().update(napierUser);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static NapierUser update(NapierUser napierUser,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(napierUser, serviceContext);
	}

	/**
	* Returns all the napier users where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching napier users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.innominds.portlets.service.model.NapierUser> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the napier users where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.innominds.portlets.service.model.impl.NapierUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of napier users
	* @param end the upper bound of the range of napier users (not inclusive)
	* @return the range of matching napier users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.innominds.portlets.service.model.NapierUser> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the napier users where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.innominds.portlets.service.model.impl.NapierUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of napier users
	* @param end the upper bound of the range of napier users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching napier users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.innominds.portlets.service.model.NapierUser> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns the first napier user in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching napier user
	* @throws com.innominds.portlets.service.NoSuchNapierUserException if a matching napier user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.innominds.portlets.service.model.NapierUser findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.innominds.portlets.service.NoSuchNapierUserException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first napier user in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching napier user, or <code>null</code> if a matching napier user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.innominds.portlets.service.model.NapierUser fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last napier user in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching napier user
	* @throws com.innominds.portlets.service.NoSuchNapierUserException if a matching napier user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.innominds.portlets.service.model.NapierUser findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.innominds.portlets.service.NoSuchNapierUserException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last napier user in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching napier user, or <code>null</code> if a matching napier user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.innominds.portlets.service.model.NapierUser fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the napier users before and after the current napier user in the ordered set where uuid = &#63;.
	*
	* @param id the primary key of the current napier user
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next napier user
	* @throws com.innominds.portlets.service.NoSuchNapierUserException if a napier user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.innominds.portlets.service.model.NapierUser[] findByUuid_PrevAndNext(
		long id, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.innominds.portlets.service.NoSuchNapierUserException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_PrevAndNext(id, uuid, orderByComparator);
	}

	/**
	* Removes all the napier users where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of napier users where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching napier users
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the napier user where liferayUserId = &#63; or throws a {@link com.innominds.portlets.service.NoSuchNapierUserException} if it could not be found.
	*
	* @param liferayUserId the liferay user ID
	* @return the matching napier user
	* @throws com.innominds.portlets.service.NoSuchNapierUserException if a matching napier user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.innominds.portlets.service.model.NapierUser findByliferayUserId(
		java.lang.String liferayUserId)
		throws com.innominds.portlets.service.NoSuchNapierUserException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByliferayUserId(liferayUserId);
	}

	/**
	* Returns the napier user where liferayUserId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param liferayUserId the liferay user ID
	* @return the matching napier user, or <code>null</code> if a matching napier user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.innominds.portlets.service.model.NapierUser fetchByliferayUserId(
		java.lang.String liferayUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByliferayUserId(liferayUserId);
	}

	/**
	* Returns the napier user where liferayUserId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param liferayUserId the liferay user ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching napier user, or <code>null</code> if a matching napier user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.innominds.portlets.service.model.NapierUser fetchByliferayUserId(
		java.lang.String liferayUserId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByliferayUserId(liferayUserId, retrieveFromCache);
	}

	/**
	* Removes the napier user where liferayUserId = &#63; from the database.
	*
	* @param liferayUserId the liferay user ID
	* @return the napier user that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.innominds.portlets.service.model.NapierUser removeByliferayUserId(
		java.lang.String liferayUserId)
		throws com.innominds.portlets.service.NoSuchNapierUserException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByliferayUserId(liferayUserId);
	}

	/**
	* Returns the number of napier users where liferayUserId = &#63;.
	*
	* @param liferayUserId the liferay user ID
	* @return the number of matching napier users
	* @throws SystemException if a system exception occurred
	*/
	public static int countByliferayUserId(java.lang.String liferayUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByliferayUserId(liferayUserId);
	}

	/**
	* Returns the napier user where tpaId = &#63; or throws a {@link com.innominds.portlets.service.NoSuchNapierUserException} if it could not be found.
	*
	* @param tpaId the tpa ID
	* @return the matching napier user
	* @throws com.innominds.portlets.service.NoSuchNapierUserException if a matching napier user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.innominds.portlets.service.model.NapierUser findByTPA(
		java.lang.String tpaId)
		throws com.innominds.portlets.service.NoSuchNapierUserException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTPA(tpaId);
	}

	/**
	* Returns the napier user where tpaId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param tpaId the tpa ID
	* @return the matching napier user, or <code>null</code> if a matching napier user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.innominds.portlets.service.model.NapierUser fetchByTPA(
		java.lang.String tpaId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByTPA(tpaId);
	}

	/**
	* Returns the napier user where tpaId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param tpaId the tpa ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching napier user, or <code>null</code> if a matching napier user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.innominds.portlets.service.model.NapierUser fetchByTPA(
		java.lang.String tpaId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByTPA(tpaId, retrieveFromCache);
	}

	/**
	* Removes the napier user where tpaId = &#63; from the database.
	*
	* @param tpaId the tpa ID
	* @return the napier user that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.innominds.portlets.service.model.NapierUser removeByTPA(
		java.lang.String tpaId)
		throws com.innominds.portlets.service.NoSuchNapierUserException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByTPA(tpaId);
	}

	/**
	* Returns the number of napier users where tpaId = &#63;.
	*
	* @param tpaId the tpa ID
	* @return the number of matching napier users
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTPA(java.lang.String tpaId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTPA(tpaId);
	}

	/**
	* Returns the napier user where patientId = &#63; or throws a {@link com.innominds.portlets.service.NoSuchNapierUserException} if it could not be found.
	*
	* @param patientId the patient ID
	* @return the matching napier user
	* @throws com.innominds.portlets.service.NoSuchNapierUserException if a matching napier user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.innominds.portlets.service.model.NapierUser findByPID(
		java.lang.String patientId)
		throws com.innominds.portlets.service.NoSuchNapierUserException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPID(patientId);
	}

	/**
	* Returns the napier user where patientId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param patientId the patient ID
	* @return the matching napier user, or <code>null</code> if a matching napier user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.innominds.portlets.service.model.NapierUser fetchByPID(
		java.lang.String patientId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPID(patientId);
	}

	/**
	* Returns the napier user where patientId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param patientId the patient ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching napier user, or <code>null</code> if a matching napier user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.innominds.portlets.service.model.NapierUser fetchByPID(
		java.lang.String patientId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPID(patientId, retrieveFromCache);
	}

	/**
	* Removes the napier user where patientId = &#63; from the database.
	*
	* @param patientId the patient ID
	* @return the napier user that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.innominds.portlets.service.model.NapierUser removeByPID(
		java.lang.String patientId)
		throws com.innominds.portlets.service.NoSuchNapierUserException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByPID(patientId);
	}

	/**
	* Returns the number of napier users where patientId = &#63;.
	*
	* @param patientId the patient ID
	* @return the number of matching napier users
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPID(java.lang.String patientId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByPID(patientId);
	}

	/**
	* Returns the napier user where mrNumber = &#63; or throws a {@link com.innominds.portlets.service.NoSuchNapierUserException} if it could not be found.
	*
	* @param mrNumber the mr number
	* @return the matching napier user
	* @throws com.innominds.portlets.service.NoSuchNapierUserException if a matching napier user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.innominds.portlets.service.model.NapierUser findByMR(
		java.lang.String mrNumber)
		throws com.innominds.portlets.service.NoSuchNapierUserException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMR(mrNumber);
	}

	/**
	* Returns the napier user where mrNumber = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param mrNumber the mr number
	* @return the matching napier user, or <code>null</code> if a matching napier user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.innominds.portlets.service.model.NapierUser fetchByMR(
		java.lang.String mrNumber)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByMR(mrNumber);
	}

	/**
	* Returns the napier user where mrNumber = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param mrNumber the mr number
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching napier user, or <code>null</code> if a matching napier user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.innominds.portlets.service.model.NapierUser fetchByMR(
		java.lang.String mrNumber, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByMR(mrNumber, retrieveFromCache);
	}

	/**
	* Removes the napier user where mrNumber = &#63; from the database.
	*
	* @param mrNumber the mr number
	* @return the napier user that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.innominds.portlets.service.model.NapierUser removeByMR(
		java.lang.String mrNumber)
		throws com.innominds.portlets.service.NoSuchNapierUserException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByMR(mrNumber);
	}

	/**
	* Returns the number of napier users where mrNumber = &#63;.
	*
	* @param mrNumber the mr number
	* @return the number of matching napier users
	* @throws SystemException if a system exception occurred
	*/
	public static int countByMR(java.lang.String mrNumber)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByMR(mrNumber);
	}

	/**
	* Returns the napier user where username = &#63; and password = &#63; or throws a {@link com.innominds.portlets.service.NoSuchNapierUserException} if it could not be found.
	*
	* @param username the username
	* @param password the password
	* @return the matching napier user
	* @throws com.innominds.portlets.service.NoSuchNapierUserException if a matching napier user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.innominds.portlets.service.model.NapierUser findByCredentials(
		java.lang.String username, java.lang.String password)
		throws com.innominds.portlets.service.NoSuchNapierUserException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCredentials(username, password);
	}

	/**
	* Returns the napier user where username = &#63; and password = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param username the username
	* @param password the password
	* @return the matching napier user, or <code>null</code> if a matching napier user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.innominds.portlets.service.model.NapierUser fetchByCredentials(
		java.lang.String username, java.lang.String password)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCredentials(username, password);
	}

	/**
	* Returns the napier user where username = &#63; and password = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param username the username
	* @param password the password
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching napier user, or <code>null</code> if a matching napier user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.innominds.portlets.service.model.NapierUser fetchByCredentials(
		java.lang.String username, java.lang.String password,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCredentials(username, password, retrieveFromCache);
	}

	/**
	* Removes the napier user where username = &#63; and password = &#63; from the database.
	*
	* @param username the username
	* @param password the password
	* @return the napier user that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.innominds.portlets.service.model.NapierUser removeByCredentials(
		java.lang.String username, java.lang.String password)
		throws com.innominds.portlets.service.NoSuchNapierUserException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByCredentials(username, password);
	}

	/**
	* Returns the number of napier users where username = &#63; and password = &#63;.
	*
	* @param username the username
	* @param password the password
	* @return the number of matching napier users
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCredentials(java.lang.String username,
		java.lang.String password)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCredentials(username, password);
	}

	/**
	* Caches the napier user in the entity cache if it is enabled.
	*
	* @param napierUser the napier user
	*/
	public static void cacheResult(
		com.innominds.portlets.service.model.NapierUser napierUser) {
		getPersistence().cacheResult(napierUser);
	}

	/**
	* Caches the napier users in the entity cache if it is enabled.
	*
	* @param napierUsers the napier users
	*/
	public static void cacheResult(
		java.util.List<com.innominds.portlets.service.model.NapierUser> napierUsers) {
		getPersistence().cacheResult(napierUsers);
	}

	/**
	* Creates a new napier user with the primary key. Does not add the napier user to the database.
	*
	* @param id the primary key for the new napier user
	* @return the new napier user
	*/
	public static com.innominds.portlets.service.model.NapierUser create(
		long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the napier user with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the napier user
	* @return the napier user that was removed
	* @throws com.innominds.portlets.service.NoSuchNapierUserException if a napier user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.innominds.portlets.service.model.NapierUser remove(
		long id)
		throws com.innominds.portlets.service.NoSuchNapierUserException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(id);
	}

	public static com.innominds.portlets.service.model.NapierUser updateImpl(
		com.innominds.portlets.service.model.NapierUser napierUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(napierUser);
	}

	/**
	* Returns the napier user with the primary key or throws a {@link com.innominds.portlets.service.NoSuchNapierUserException} if it could not be found.
	*
	* @param id the primary key of the napier user
	* @return the napier user
	* @throws com.innominds.portlets.service.NoSuchNapierUserException if a napier user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.innominds.portlets.service.model.NapierUser findByPrimaryKey(
		long id)
		throws com.innominds.portlets.service.NoSuchNapierUserException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the napier user with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the napier user
	* @return the napier user, or <code>null</code> if a napier user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.innominds.portlets.service.model.NapierUser fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the napier users.
	*
	* @return the napier users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.innominds.portlets.service.model.NapierUser> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.innominds.portlets.service.model.NapierUser> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the napier users.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.innominds.portlets.service.model.impl.NapierUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of napier users
	* @param end the upper bound of the range of napier users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of napier users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.innominds.portlets.service.model.NapierUser> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the napier users from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of napier users.
	*
	* @return the number of napier users
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static NapierUserPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (NapierUserPersistence)PortletBeanLocatorUtil.locate(com.innominds.portlets.service.service.ClpSerializer.getServletContextName(),
					NapierUserPersistence.class.getName());

			ReferenceRegistry.registerReference(NapierUserUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(NapierUserPersistence persistence) {
	}

	private static NapierUserPersistence _persistence;
}