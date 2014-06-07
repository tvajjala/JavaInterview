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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the napier user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see NapierUserPersistenceImpl
 * @see NapierUserUtil
 * @generated
 */
public interface NapierUserPersistence extends BasePersistence<NapierUser> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link NapierUserUtil} to access the napier user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the napier users where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching napier users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.innominds.portlets.service.model.NapierUser> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.innominds.portlets.service.model.NapierUser> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.innominds.portlets.service.model.NapierUser> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first napier user in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching napier user
	* @throws com.innominds.portlets.service.NoSuchNapierUserException if a matching napier user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.innominds.portlets.service.model.NapierUser findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.innominds.portlets.service.NoSuchNapierUserException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first napier user in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching napier user, or <code>null</code> if a matching napier user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.innominds.portlets.service.model.NapierUser fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last napier user in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching napier user
	* @throws com.innominds.portlets.service.NoSuchNapierUserException if a matching napier user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.innominds.portlets.service.model.NapierUser findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.innominds.portlets.service.NoSuchNapierUserException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last napier user in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching napier user, or <code>null</code> if a matching napier user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.innominds.portlets.service.model.NapierUser fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.innominds.portlets.service.model.NapierUser[] findByUuid_PrevAndNext(
		long id, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.innominds.portlets.service.NoSuchNapierUserException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the napier users where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of napier users where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching napier users
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the napier user where liferayUserId = &#63; or throws a {@link com.innominds.portlets.service.NoSuchNapierUserException} if it could not be found.
	*
	* @param liferayUserId the liferay user ID
	* @return the matching napier user
	* @throws com.innominds.portlets.service.NoSuchNapierUserException if a matching napier user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.innominds.portlets.service.model.NapierUser findByliferayUserId(
		java.lang.String liferayUserId)
		throws com.innominds.portlets.service.NoSuchNapierUserException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the napier user where liferayUserId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param liferayUserId the liferay user ID
	* @return the matching napier user, or <code>null</code> if a matching napier user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.innominds.portlets.service.model.NapierUser fetchByliferayUserId(
		java.lang.String liferayUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the napier user where liferayUserId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param liferayUserId the liferay user ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching napier user, or <code>null</code> if a matching napier user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.innominds.portlets.service.model.NapierUser fetchByliferayUserId(
		java.lang.String liferayUserId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the napier user where liferayUserId = &#63; from the database.
	*
	* @param liferayUserId the liferay user ID
	* @return the napier user that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.innominds.portlets.service.model.NapierUser removeByliferayUserId(
		java.lang.String liferayUserId)
		throws com.innominds.portlets.service.NoSuchNapierUserException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of napier users where liferayUserId = &#63;.
	*
	* @param liferayUserId the liferay user ID
	* @return the number of matching napier users
	* @throws SystemException if a system exception occurred
	*/
	public int countByliferayUserId(java.lang.String liferayUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the napier user where tpaId = &#63; or throws a {@link com.innominds.portlets.service.NoSuchNapierUserException} if it could not be found.
	*
	* @param tpaId the tpa ID
	* @return the matching napier user
	* @throws com.innominds.portlets.service.NoSuchNapierUserException if a matching napier user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.innominds.portlets.service.model.NapierUser findByTPA(
		java.lang.String tpaId)
		throws com.innominds.portlets.service.NoSuchNapierUserException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the napier user where tpaId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param tpaId the tpa ID
	* @return the matching napier user, or <code>null</code> if a matching napier user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.innominds.portlets.service.model.NapierUser fetchByTPA(
		java.lang.String tpaId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the napier user where tpaId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param tpaId the tpa ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching napier user, or <code>null</code> if a matching napier user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.innominds.portlets.service.model.NapierUser fetchByTPA(
		java.lang.String tpaId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the napier user where tpaId = &#63; from the database.
	*
	* @param tpaId the tpa ID
	* @return the napier user that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.innominds.portlets.service.model.NapierUser removeByTPA(
		java.lang.String tpaId)
		throws com.innominds.portlets.service.NoSuchNapierUserException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of napier users where tpaId = &#63;.
	*
	* @param tpaId the tpa ID
	* @return the number of matching napier users
	* @throws SystemException if a system exception occurred
	*/
	public int countByTPA(java.lang.String tpaId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the napier user where patientId = &#63; or throws a {@link com.innominds.portlets.service.NoSuchNapierUserException} if it could not be found.
	*
	* @param patientId the patient ID
	* @return the matching napier user
	* @throws com.innominds.portlets.service.NoSuchNapierUserException if a matching napier user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.innominds.portlets.service.model.NapierUser findByPID(
		java.lang.String patientId)
		throws com.innominds.portlets.service.NoSuchNapierUserException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the napier user where patientId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param patientId the patient ID
	* @return the matching napier user, or <code>null</code> if a matching napier user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.innominds.portlets.service.model.NapierUser fetchByPID(
		java.lang.String patientId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the napier user where patientId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param patientId the patient ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching napier user, or <code>null</code> if a matching napier user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.innominds.portlets.service.model.NapierUser fetchByPID(
		java.lang.String patientId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the napier user where patientId = &#63; from the database.
	*
	* @param patientId the patient ID
	* @return the napier user that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.innominds.portlets.service.model.NapierUser removeByPID(
		java.lang.String patientId)
		throws com.innominds.portlets.service.NoSuchNapierUserException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of napier users where patientId = &#63;.
	*
	* @param patientId the patient ID
	* @return the number of matching napier users
	* @throws SystemException if a system exception occurred
	*/
	public int countByPID(java.lang.String patientId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the napier user where mrNumber = &#63; or throws a {@link com.innominds.portlets.service.NoSuchNapierUserException} if it could not be found.
	*
	* @param mrNumber the mr number
	* @return the matching napier user
	* @throws com.innominds.portlets.service.NoSuchNapierUserException if a matching napier user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.innominds.portlets.service.model.NapierUser findByMR(
		java.lang.String mrNumber)
		throws com.innominds.portlets.service.NoSuchNapierUserException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the napier user where mrNumber = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param mrNumber the mr number
	* @return the matching napier user, or <code>null</code> if a matching napier user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.innominds.portlets.service.model.NapierUser fetchByMR(
		java.lang.String mrNumber)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the napier user where mrNumber = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param mrNumber the mr number
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching napier user, or <code>null</code> if a matching napier user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.innominds.portlets.service.model.NapierUser fetchByMR(
		java.lang.String mrNumber, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the napier user where mrNumber = &#63; from the database.
	*
	* @param mrNumber the mr number
	* @return the napier user that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.innominds.portlets.service.model.NapierUser removeByMR(
		java.lang.String mrNumber)
		throws com.innominds.portlets.service.NoSuchNapierUserException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of napier users where mrNumber = &#63;.
	*
	* @param mrNumber the mr number
	* @return the number of matching napier users
	* @throws SystemException if a system exception occurred
	*/
	public int countByMR(java.lang.String mrNumber)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the napier user where username = &#63; and password = &#63; or throws a {@link com.innominds.portlets.service.NoSuchNapierUserException} if it could not be found.
	*
	* @param username the username
	* @param password the password
	* @return the matching napier user
	* @throws com.innominds.portlets.service.NoSuchNapierUserException if a matching napier user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.innominds.portlets.service.model.NapierUser findByCredentials(
		java.lang.String username, java.lang.String password)
		throws com.innominds.portlets.service.NoSuchNapierUserException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the napier user where username = &#63; and password = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param username the username
	* @param password the password
	* @return the matching napier user, or <code>null</code> if a matching napier user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.innominds.portlets.service.model.NapierUser fetchByCredentials(
		java.lang.String username, java.lang.String password)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the napier user where username = &#63; and password = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param username the username
	* @param password the password
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching napier user, or <code>null</code> if a matching napier user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.innominds.portlets.service.model.NapierUser fetchByCredentials(
		java.lang.String username, java.lang.String password,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the napier user where username = &#63; and password = &#63; from the database.
	*
	* @param username the username
	* @param password the password
	* @return the napier user that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.innominds.portlets.service.model.NapierUser removeByCredentials(
		java.lang.String username, java.lang.String password)
		throws com.innominds.portlets.service.NoSuchNapierUserException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of napier users where username = &#63; and password = &#63;.
	*
	* @param username the username
	* @param password the password
	* @return the number of matching napier users
	* @throws SystemException if a system exception occurred
	*/
	public int countByCredentials(java.lang.String username,
		java.lang.String password)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the napier user in the entity cache if it is enabled.
	*
	* @param napierUser the napier user
	*/
	public void cacheResult(
		com.innominds.portlets.service.model.NapierUser napierUser);

	/**
	* Caches the napier users in the entity cache if it is enabled.
	*
	* @param napierUsers the napier users
	*/
	public void cacheResult(
		java.util.List<com.innominds.portlets.service.model.NapierUser> napierUsers);

	/**
	* Creates a new napier user with the primary key. Does not add the napier user to the database.
	*
	* @param id the primary key for the new napier user
	* @return the new napier user
	*/
	public com.innominds.portlets.service.model.NapierUser create(long id);

	/**
	* Removes the napier user with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the napier user
	* @return the napier user that was removed
	* @throws com.innominds.portlets.service.NoSuchNapierUserException if a napier user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.innominds.portlets.service.model.NapierUser remove(long id)
		throws com.innominds.portlets.service.NoSuchNapierUserException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.innominds.portlets.service.model.NapierUser updateImpl(
		com.innominds.portlets.service.model.NapierUser napierUser)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the napier user with the primary key or throws a {@link com.innominds.portlets.service.NoSuchNapierUserException} if it could not be found.
	*
	* @param id the primary key of the napier user
	* @return the napier user
	* @throws com.innominds.portlets.service.NoSuchNapierUserException if a napier user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.innominds.portlets.service.model.NapierUser findByPrimaryKey(
		long id)
		throws com.innominds.portlets.service.NoSuchNapierUserException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the napier user with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the napier user
	* @return the napier user, or <code>null</code> if a napier user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.innominds.portlets.service.model.NapierUser fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the napier users.
	*
	* @return the napier users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.innominds.portlets.service.model.NapierUser> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.innominds.portlets.service.model.NapierUser> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.innominds.portlets.service.model.NapierUser> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the napier users from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of napier users.
	*
	* @return the number of napier users
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}