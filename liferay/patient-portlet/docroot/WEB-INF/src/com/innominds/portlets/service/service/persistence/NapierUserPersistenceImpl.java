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

import com.innominds.portlets.service.NoSuchNapierUserException;
import com.innominds.portlets.service.model.NapierUser;
import com.innominds.portlets.service.model.impl.NapierUserImpl;
import com.innominds.portlets.service.model.impl.NapierUserModelImpl;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the napier user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see NapierUserPersistence
 * @see NapierUserUtil
 * @generated
 */
public class NapierUserPersistenceImpl extends BasePersistenceImpl<NapierUser>
	implements NapierUserPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link NapierUserUtil} to access the napier user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = NapierUserImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(NapierUserModelImpl.ENTITY_CACHE_ENABLED,
			NapierUserModelImpl.FINDER_CACHE_ENABLED, NapierUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(NapierUserModelImpl.ENTITY_CACHE_ENABLED,
			NapierUserModelImpl.FINDER_CACHE_ENABLED, NapierUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(NapierUserModelImpl.ENTITY_CACHE_ENABLED,
			NapierUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(NapierUserModelImpl.ENTITY_CACHE_ENABLED,
			NapierUserModelImpl.FINDER_CACHE_ENABLED, NapierUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(NapierUserModelImpl.ENTITY_CACHE_ENABLED,
			NapierUserModelImpl.FINDER_CACHE_ENABLED, NapierUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			NapierUserModelImpl.UUID_COLUMN_BITMASK |
			NapierUserModelImpl.MRNUMBER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(NapierUserModelImpl.ENTITY_CACHE_ENABLED,
			NapierUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the napier users where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching napier users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<NapierUser> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<NapierUser> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<NapierUser> findByUuid(String uuid, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid, start, end, orderByComparator };
		}

		List<NapierUser> list = (List<NapierUser>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (NapierUser napierUser : list) {
				if (!Validator.equals(uuid, napierUser.getUuid())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_NAPIERUSER_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(NapierUserModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				if (!pagination) {
					list = (List<NapierUser>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<NapierUser>(list);
				}
				else {
					list = (List<NapierUser>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public NapierUser findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchNapierUserException, SystemException {
		NapierUser napierUser = fetchByUuid_First(uuid, orderByComparator);

		if (napierUser != null) {
			return napierUser;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchNapierUserException(msg.toString());
	}

	/**
	 * Returns the first napier user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching napier user, or <code>null</code> if a matching napier user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NapierUser fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<NapierUser> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public NapierUser findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchNapierUserException, SystemException {
		NapierUser napierUser = fetchByUuid_Last(uuid, orderByComparator);

		if (napierUser != null) {
			return napierUser;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchNapierUserException(msg.toString());
	}

	/**
	 * Returns the last napier user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching napier user, or <code>null</code> if a matching napier user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NapierUser fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<NapierUser> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public NapierUser[] findByUuid_PrevAndNext(long id, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchNapierUserException, SystemException {
		NapierUser napierUser = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			NapierUser[] array = new NapierUserImpl[3];

			array[0] = getByUuid_PrevAndNext(session, napierUser, uuid,
					orderByComparator, true);

			array[1] = napierUser;

			array[2] = getByUuid_PrevAndNext(session, napierUser, uuid,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected NapierUser getByUuid_PrevAndNext(Session session,
		NapierUser napierUser, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_NAPIERUSER_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(NapierUserModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(napierUser);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<NapierUser> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the napier users where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (NapierUser napierUser : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(napierUser);
		}
	}

	/**
	 * Returns the number of napier users where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching napier users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUuid(String uuid) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_NAPIERUSER_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "napierUser.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "napierUser.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(napierUser.uuid IS NULL OR napierUser.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_LIFERAYUSERID = new FinderPath(NapierUserModelImpl.ENTITY_CACHE_ENABLED,
			NapierUserModelImpl.FINDER_CACHE_ENABLED, NapierUserImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByliferayUserId",
			new String[] { String.class.getName() },
			NapierUserModelImpl.LIFERAYUSERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LIFERAYUSERID = new FinderPath(NapierUserModelImpl.ENTITY_CACHE_ENABLED,
			NapierUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByliferayUserId",
			new String[] { String.class.getName() });

	/**
	 * Returns the napier user where liferayUserId = &#63; or throws a {@link com.innominds.portlets.service.NoSuchNapierUserException} if it could not be found.
	 *
	 * @param liferayUserId the liferay user ID
	 * @return the matching napier user
	 * @throws com.innominds.portlets.service.NoSuchNapierUserException if a matching napier user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NapierUser findByliferayUserId(String liferayUserId)
		throws NoSuchNapierUserException, SystemException {
		NapierUser napierUser = fetchByliferayUserId(liferayUserId);

		if (napierUser == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("liferayUserId=");
			msg.append(liferayUserId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchNapierUserException(msg.toString());
		}

		return napierUser;
	}

	/**
	 * Returns the napier user where liferayUserId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param liferayUserId the liferay user ID
	 * @return the matching napier user, or <code>null</code> if a matching napier user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NapierUser fetchByliferayUserId(String liferayUserId)
		throws SystemException {
		return fetchByliferayUserId(liferayUserId, true);
	}

	/**
	 * Returns the napier user where liferayUserId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param liferayUserId the liferay user ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching napier user, or <code>null</code> if a matching napier user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NapierUser fetchByliferayUserId(String liferayUserId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { liferayUserId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_LIFERAYUSERID,
					finderArgs, this);
		}

		if (result instanceof NapierUser) {
			NapierUser napierUser = (NapierUser)result;

			if (!Validator.equals(liferayUserId, napierUser.getLiferayUserId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_NAPIERUSER_WHERE);

			boolean bindLiferayUserId = false;

			if (liferayUserId == null) {
				query.append(_FINDER_COLUMN_LIFERAYUSERID_LIFERAYUSERID_1);
			}
			else if (liferayUserId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_LIFERAYUSERID_LIFERAYUSERID_3);
			}
			else {
				bindLiferayUserId = true;

				query.append(_FINDER_COLUMN_LIFERAYUSERID_LIFERAYUSERID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindLiferayUserId) {
					qPos.add(liferayUserId);
				}

				List<NapierUser> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LIFERAYUSERID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"NapierUserPersistenceImpl.fetchByliferayUserId(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					NapierUser napierUser = list.get(0);

					result = napierUser;

					cacheResult(napierUser);

					if ((napierUser.getLiferayUserId() == null) ||
							!napierUser.getLiferayUserId().equals(liferayUserId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LIFERAYUSERID,
							finderArgs, napierUser);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_LIFERAYUSERID,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (NapierUser)result;
		}
	}

	/**
	 * Removes the napier user where liferayUserId = &#63; from the database.
	 *
	 * @param liferayUserId the liferay user ID
	 * @return the napier user that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NapierUser removeByliferayUserId(String liferayUserId)
		throws NoSuchNapierUserException, SystemException {
		NapierUser napierUser = findByliferayUserId(liferayUserId);

		return remove(napierUser);
	}

	/**
	 * Returns the number of napier users where liferayUserId = &#63;.
	 *
	 * @param liferayUserId the liferay user ID
	 * @return the number of matching napier users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByliferayUserId(String liferayUserId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_LIFERAYUSERID;

		Object[] finderArgs = new Object[] { liferayUserId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_NAPIERUSER_WHERE);

			boolean bindLiferayUserId = false;

			if (liferayUserId == null) {
				query.append(_FINDER_COLUMN_LIFERAYUSERID_LIFERAYUSERID_1);
			}
			else if (liferayUserId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_LIFERAYUSERID_LIFERAYUSERID_3);
			}
			else {
				bindLiferayUserId = true;

				query.append(_FINDER_COLUMN_LIFERAYUSERID_LIFERAYUSERID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindLiferayUserId) {
					qPos.add(liferayUserId);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_LIFERAYUSERID_LIFERAYUSERID_1 = "napierUser.liferayUserId IS NULL";
	private static final String _FINDER_COLUMN_LIFERAYUSERID_LIFERAYUSERID_2 = "napierUser.liferayUserId = ?";
	private static final String _FINDER_COLUMN_LIFERAYUSERID_LIFERAYUSERID_3 = "(napierUser.liferayUserId IS NULL OR napierUser.liferayUserId = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_TPA = new FinderPath(NapierUserModelImpl.ENTITY_CACHE_ENABLED,
			NapierUserModelImpl.FINDER_CACHE_ENABLED, NapierUserImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByTPA",
			new String[] { String.class.getName() },
			NapierUserModelImpl.TPAID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TPA = new FinderPath(NapierUserModelImpl.ENTITY_CACHE_ENABLED,
			NapierUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTPA",
			new String[] { String.class.getName() });

	/**
	 * Returns the napier user where tpaId = &#63; or throws a {@link com.innominds.portlets.service.NoSuchNapierUserException} if it could not be found.
	 *
	 * @param tpaId the tpa ID
	 * @return the matching napier user
	 * @throws com.innominds.portlets.service.NoSuchNapierUserException if a matching napier user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NapierUser findByTPA(String tpaId)
		throws NoSuchNapierUserException, SystemException {
		NapierUser napierUser = fetchByTPA(tpaId);

		if (napierUser == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("tpaId=");
			msg.append(tpaId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchNapierUserException(msg.toString());
		}

		return napierUser;
	}

	/**
	 * Returns the napier user where tpaId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param tpaId the tpa ID
	 * @return the matching napier user, or <code>null</code> if a matching napier user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NapierUser fetchByTPA(String tpaId) throws SystemException {
		return fetchByTPA(tpaId, true);
	}

	/**
	 * Returns the napier user where tpaId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param tpaId the tpa ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching napier user, or <code>null</code> if a matching napier user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NapierUser fetchByTPA(String tpaId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { tpaId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_TPA,
					finderArgs, this);
		}

		if (result instanceof NapierUser) {
			NapierUser napierUser = (NapierUser)result;

			if (!Validator.equals(tpaId, napierUser.getTpaId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_NAPIERUSER_WHERE);

			boolean bindTpaId = false;

			if (tpaId == null) {
				query.append(_FINDER_COLUMN_TPA_TPAID_1);
			}
			else if (tpaId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TPA_TPAID_3);
			}
			else {
				bindTpaId = true;

				query.append(_FINDER_COLUMN_TPA_TPAID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTpaId) {
					qPos.add(tpaId);
				}

				List<NapierUser> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TPA,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"NapierUserPersistenceImpl.fetchByTPA(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					NapierUser napierUser = list.get(0);

					result = napierUser;

					cacheResult(napierUser);

					if ((napierUser.getTpaId() == null) ||
							!napierUser.getTpaId().equals(tpaId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TPA,
							finderArgs, napierUser);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TPA,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (NapierUser)result;
		}
	}

	/**
	 * Removes the napier user where tpaId = &#63; from the database.
	 *
	 * @param tpaId the tpa ID
	 * @return the napier user that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NapierUser removeByTPA(String tpaId)
		throws NoSuchNapierUserException, SystemException {
		NapierUser napierUser = findByTPA(tpaId);

		return remove(napierUser);
	}

	/**
	 * Returns the number of napier users where tpaId = &#63;.
	 *
	 * @param tpaId the tpa ID
	 * @return the number of matching napier users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByTPA(String tpaId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TPA;

		Object[] finderArgs = new Object[] { tpaId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_NAPIERUSER_WHERE);

			boolean bindTpaId = false;

			if (tpaId == null) {
				query.append(_FINDER_COLUMN_TPA_TPAID_1);
			}
			else if (tpaId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TPA_TPAID_3);
			}
			else {
				bindTpaId = true;

				query.append(_FINDER_COLUMN_TPA_TPAID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTpaId) {
					qPos.add(tpaId);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_TPA_TPAID_1 = "napierUser.tpaId IS NULL";
	private static final String _FINDER_COLUMN_TPA_TPAID_2 = "napierUser.tpaId = ?";
	private static final String _FINDER_COLUMN_TPA_TPAID_3 = "(napierUser.tpaId IS NULL OR napierUser.tpaId = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_PID = new FinderPath(NapierUserModelImpl.ENTITY_CACHE_ENABLED,
			NapierUserModelImpl.FINDER_CACHE_ENABLED, NapierUserImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByPID",
			new String[] { String.class.getName() },
			NapierUserModelImpl.PATIENTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PID = new FinderPath(NapierUserModelImpl.ENTITY_CACHE_ENABLED,
			NapierUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPID",
			new String[] { String.class.getName() });

	/**
	 * Returns the napier user where patientId = &#63; or throws a {@link com.innominds.portlets.service.NoSuchNapierUserException} if it could not be found.
	 *
	 * @param patientId the patient ID
	 * @return the matching napier user
	 * @throws com.innominds.portlets.service.NoSuchNapierUserException if a matching napier user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NapierUser findByPID(String patientId)
		throws NoSuchNapierUserException, SystemException {
		NapierUser napierUser = fetchByPID(patientId);

		if (napierUser == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("patientId=");
			msg.append(patientId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchNapierUserException(msg.toString());
		}

		return napierUser;
	}

	/**
	 * Returns the napier user where patientId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param patientId the patient ID
	 * @return the matching napier user, or <code>null</code> if a matching napier user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NapierUser fetchByPID(String patientId) throws SystemException {
		return fetchByPID(patientId, true);
	}

	/**
	 * Returns the napier user where patientId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param patientId the patient ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching napier user, or <code>null</code> if a matching napier user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NapierUser fetchByPID(String patientId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { patientId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_PID,
					finderArgs, this);
		}

		if (result instanceof NapierUser) {
			NapierUser napierUser = (NapierUser)result;

			if (!Validator.equals(patientId, napierUser.getPatientId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_NAPIERUSER_WHERE);

			boolean bindPatientId = false;

			if (patientId == null) {
				query.append(_FINDER_COLUMN_PID_PATIENTID_1);
			}
			else if (patientId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PID_PATIENTID_3);
			}
			else {
				bindPatientId = true;

				query.append(_FINDER_COLUMN_PID_PATIENTID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindPatientId) {
					qPos.add(patientId);
				}

				List<NapierUser> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"NapierUserPersistenceImpl.fetchByPID(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					NapierUser napierUser = list.get(0);

					result = napierUser;

					cacheResult(napierUser);

					if ((napierUser.getPatientId() == null) ||
							!napierUser.getPatientId().equals(patientId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PID,
							finderArgs, napierUser);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PID,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (NapierUser)result;
		}
	}

	/**
	 * Removes the napier user where patientId = &#63; from the database.
	 *
	 * @param patientId the patient ID
	 * @return the napier user that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NapierUser removeByPID(String patientId)
		throws NoSuchNapierUserException, SystemException {
		NapierUser napierUser = findByPID(patientId);

		return remove(napierUser);
	}

	/**
	 * Returns the number of napier users where patientId = &#63;.
	 *
	 * @param patientId the patient ID
	 * @return the number of matching napier users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByPID(String patientId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PID;

		Object[] finderArgs = new Object[] { patientId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_NAPIERUSER_WHERE);

			boolean bindPatientId = false;

			if (patientId == null) {
				query.append(_FINDER_COLUMN_PID_PATIENTID_1);
			}
			else if (patientId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PID_PATIENTID_3);
			}
			else {
				bindPatientId = true;

				query.append(_FINDER_COLUMN_PID_PATIENTID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindPatientId) {
					qPos.add(patientId);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_PID_PATIENTID_1 = "napierUser.patientId IS NULL";
	private static final String _FINDER_COLUMN_PID_PATIENTID_2 = "napierUser.patientId = ?";
	private static final String _FINDER_COLUMN_PID_PATIENTID_3 = "(napierUser.patientId IS NULL OR napierUser.patientId = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_MR = new FinderPath(NapierUserModelImpl.ENTITY_CACHE_ENABLED,
			NapierUserModelImpl.FINDER_CACHE_ENABLED, NapierUserImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByMR",
			new String[] { String.class.getName() },
			NapierUserModelImpl.MRNUMBER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MR = new FinderPath(NapierUserModelImpl.ENTITY_CACHE_ENABLED,
			NapierUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByMR",
			new String[] { String.class.getName() });

	/**
	 * Returns the napier user where mrNumber = &#63; or throws a {@link com.innominds.portlets.service.NoSuchNapierUserException} if it could not be found.
	 *
	 * @param mrNumber the mr number
	 * @return the matching napier user
	 * @throws com.innominds.portlets.service.NoSuchNapierUserException if a matching napier user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NapierUser findByMR(String mrNumber)
		throws NoSuchNapierUserException, SystemException {
		NapierUser napierUser = fetchByMR(mrNumber);

		if (napierUser == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("mrNumber=");
			msg.append(mrNumber);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchNapierUserException(msg.toString());
		}

		return napierUser;
	}

	/**
	 * Returns the napier user where mrNumber = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param mrNumber the mr number
	 * @return the matching napier user, or <code>null</code> if a matching napier user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NapierUser fetchByMR(String mrNumber) throws SystemException {
		return fetchByMR(mrNumber, true);
	}

	/**
	 * Returns the napier user where mrNumber = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param mrNumber the mr number
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching napier user, or <code>null</code> if a matching napier user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NapierUser fetchByMR(String mrNumber, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { mrNumber };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_MR,
					finderArgs, this);
		}

		if (result instanceof NapierUser) {
			NapierUser napierUser = (NapierUser)result;

			if (!Validator.equals(mrNumber, napierUser.getMrNumber())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_NAPIERUSER_WHERE);

			boolean bindMrNumber = false;

			if (mrNumber == null) {
				query.append(_FINDER_COLUMN_MR_MRNUMBER_1);
			}
			else if (mrNumber.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_MR_MRNUMBER_3);
			}
			else {
				bindMrNumber = true;

				query.append(_FINDER_COLUMN_MR_MRNUMBER_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindMrNumber) {
					qPos.add(mrNumber);
				}

				List<NapierUser> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MR,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"NapierUserPersistenceImpl.fetchByMR(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					NapierUser napierUser = list.get(0);

					result = napierUser;

					cacheResult(napierUser);

					if ((napierUser.getMrNumber() == null) ||
							!napierUser.getMrNumber().equals(mrNumber)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MR,
							finderArgs, napierUser);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_MR, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (NapierUser)result;
		}
	}

	/**
	 * Removes the napier user where mrNumber = &#63; from the database.
	 *
	 * @param mrNumber the mr number
	 * @return the napier user that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NapierUser removeByMR(String mrNumber)
		throws NoSuchNapierUserException, SystemException {
		NapierUser napierUser = findByMR(mrNumber);

		return remove(napierUser);
	}

	/**
	 * Returns the number of napier users where mrNumber = &#63;.
	 *
	 * @param mrNumber the mr number
	 * @return the number of matching napier users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByMR(String mrNumber) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MR;

		Object[] finderArgs = new Object[] { mrNumber };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_NAPIERUSER_WHERE);

			boolean bindMrNumber = false;

			if (mrNumber == null) {
				query.append(_FINDER_COLUMN_MR_MRNUMBER_1);
			}
			else if (mrNumber.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_MR_MRNUMBER_3);
			}
			else {
				bindMrNumber = true;

				query.append(_FINDER_COLUMN_MR_MRNUMBER_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindMrNumber) {
					qPos.add(mrNumber);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_MR_MRNUMBER_1 = "napierUser.mrNumber IS NULL";
	private static final String _FINDER_COLUMN_MR_MRNUMBER_2 = "napierUser.mrNumber = ?";
	private static final String _FINDER_COLUMN_MR_MRNUMBER_3 = "(napierUser.mrNumber IS NULL OR napierUser.mrNumber = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_CREDENTIALS = new FinderPath(NapierUserModelImpl.ENTITY_CACHE_ENABLED,
			NapierUserModelImpl.FINDER_CACHE_ENABLED, NapierUserImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByCredentials",
			new String[] { String.class.getName(), String.class.getName() },
			NapierUserModelImpl.USERNAME_COLUMN_BITMASK |
			NapierUserModelImpl.PASSWORD_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CREDENTIALS = new FinderPath(NapierUserModelImpl.ENTITY_CACHE_ENABLED,
			NapierUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCredentials",
			new String[] { String.class.getName(), String.class.getName() });

	/**
	 * Returns the napier user where username = &#63; and password = &#63; or throws a {@link com.innominds.portlets.service.NoSuchNapierUserException} if it could not be found.
	 *
	 * @param username the username
	 * @param password the password
	 * @return the matching napier user
	 * @throws com.innominds.portlets.service.NoSuchNapierUserException if a matching napier user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NapierUser findByCredentials(String username, String password)
		throws NoSuchNapierUserException, SystemException {
		NapierUser napierUser = fetchByCredentials(username, password);

		if (napierUser == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("username=");
			msg.append(username);

			msg.append(", password=");
			msg.append(password);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchNapierUserException(msg.toString());
		}

		return napierUser;
	}

	/**
	 * Returns the napier user where username = &#63; and password = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param username the username
	 * @param password the password
	 * @return the matching napier user, or <code>null</code> if a matching napier user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NapierUser fetchByCredentials(String username, String password)
		throws SystemException {
		return fetchByCredentials(username, password, true);
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
	@Override
	public NapierUser fetchByCredentials(String username, String password,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { username, password };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_CREDENTIALS,
					finderArgs, this);
		}

		if (result instanceof NapierUser) {
			NapierUser napierUser = (NapierUser)result;

			if (!Validator.equals(username, napierUser.getUsername()) ||
					!Validator.equals(password, napierUser.getPassword())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_NAPIERUSER_WHERE);

			boolean bindUsername = false;

			if (username == null) {
				query.append(_FINDER_COLUMN_CREDENTIALS_USERNAME_1);
			}
			else if (username.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CREDENTIALS_USERNAME_3);
			}
			else {
				bindUsername = true;

				query.append(_FINDER_COLUMN_CREDENTIALS_USERNAME_2);
			}

			boolean bindPassword = false;

			if (password == null) {
				query.append(_FINDER_COLUMN_CREDENTIALS_PASSWORD_1);
			}
			else if (password.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CREDENTIALS_PASSWORD_3);
			}
			else {
				bindPassword = true;

				query.append(_FINDER_COLUMN_CREDENTIALS_PASSWORD_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUsername) {
					qPos.add(username);
				}

				if (bindPassword) {
					qPos.add(password);
				}

				List<NapierUser> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CREDENTIALS,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"NapierUserPersistenceImpl.fetchByCredentials(String, String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					NapierUser napierUser = list.get(0);

					result = napierUser;

					cacheResult(napierUser);

					if ((napierUser.getUsername() == null) ||
							!napierUser.getUsername().equals(username) ||
							(napierUser.getPassword() == null) ||
							!napierUser.getPassword().equals(password)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CREDENTIALS,
							finderArgs, napierUser);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CREDENTIALS,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (NapierUser)result;
		}
	}

	/**
	 * Removes the napier user where username = &#63; and password = &#63; from the database.
	 *
	 * @param username the username
	 * @param password the password
	 * @return the napier user that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NapierUser removeByCredentials(String username, String password)
		throws NoSuchNapierUserException, SystemException {
		NapierUser napierUser = findByCredentials(username, password);

		return remove(napierUser);
	}

	/**
	 * Returns the number of napier users where username = &#63; and password = &#63;.
	 *
	 * @param username the username
	 * @param password the password
	 * @return the number of matching napier users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCredentials(String username, String password)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CREDENTIALS;

		Object[] finderArgs = new Object[] { username, password };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_NAPIERUSER_WHERE);

			boolean bindUsername = false;

			if (username == null) {
				query.append(_FINDER_COLUMN_CREDENTIALS_USERNAME_1);
			}
			else if (username.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CREDENTIALS_USERNAME_3);
			}
			else {
				bindUsername = true;

				query.append(_FINDER_COLUMN_CREDENTIALS_USERNAME_2);
			}

			boolean bindPassword = false;

			if (password == null) {
				query.append(_FINDER_COLUMN_CREDENTIALS_PASSWORD_1);
			}
			else if (password.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CREDENTIALS_PASSWORD_3);
			}
			else {
				bindPassword = true;

				query.append(_FINDER_COLUMN_CREDENTIALS_PASSWORD_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUsername) {
					qPos.add(username);
				}

				if (bindPassword) {
					qPos.add(password);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_CREDENTIALS_USERNAME_1 = "napierUser.username IS NULL AND ";
	private static final String _FINDER_COLUMN_CREDENTIALS_USERNAME_2 = "napierUser.username = ? AND ";
	private static final String _FINDER_COLUMN_CREDENTIALS_USERNAME_3 = "(napierUser.username IS NULL OR napierUser.username = '') AND ";
	private static final String _FINDER_COLUMN_CREDENTIALS_PASSWORD_1 = "napierUser.password IS NULL";
	private static final String _FINDER_COLUMN_CREDENTIALS_PASSWORD_2 = "napierUser.password = ?";
	private static final String _FINDER_COLUMN_CREDENTIALS_PASSWORD_3 = "(napierUser.password IS NULL OR napierUser.password = '')";

	public NapierUserPersistenceImpl() {
		setModelClass(NapierUser.class);
	}

	/**
	 * Caches the napier user in the entity cache if it is enabled.
	 *
	 * @param napierUser the napier user
	 */
	@Override
	public void cacheResult(NapierUser napierUser) {
		EntityCacheUtil.putResult(NapierUserModelImpl.ENTITY_CACHE_ENABLED,
			NapierUserImpl.class, napierUser.getPrimaryKey(), napierUser);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LIFERAYUSERID,
			new Object[] { napierUser.getLiferayUserId() }, napierUser);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TPA,
			new Object[] { napierUser.getTpaId() }, napierUser);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PID,
			new Object[] { napierUser.getPatientId() }, napierUser);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MR,
			new Object[] { napierUser.getMrNumber() }, napierUser);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CREDENTIALS,
			new Object[] { napierUser.getUsername(), napierUser.getPassword() },
			napierUser);

		napierUser.resetOriginalValues();
	}

	/**
	 * Caches the napier users in the entity cache if it is enabled.
	 *
	 * @param napierUsers the napier users
	 */
	@Override
	public void cacheResult(List<NapierUser> napierUsers) {
		for (NapierUser napierUser : napierUsers) {
			if (EntityCacheUtil.getResult(
						NapierUserModelImpl.ENTITY_CACHE_ENABLED,
						NapierUserImpl.class, napierUser.getPrimaryKey()) == null) {
				cacheResult(napierUser);
			}
			else {
				napierUser.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all napier users.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(NapierUserImpl.class.getName());
		}

		EntityCacheUtil.clearCache(NapierUserImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the napier user.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(NapierUser napierUser) {
		EntityCacheUtil.removeResult(NapierUserModelImpl.ENTITY_CACHE_ENABLED,
			NapierUserImpl.class, napierUser.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(napierUser);
	}

	@Override
	public void clearCache(List<NapierUser> napierUsers) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (NapierUser napierUser : napierUsers) {
			EntityCacheUtil.removeResult(NapierUserModelImpl.ENTITY_CACHE_ENABLED,
				NapierUserImpl.class, napierUser.getPrimaryKey());

			clearUniqueFindersCache(napierUser);
		}
	}

	protected void cacheUniqueFindersCache(NapierUser napierUser) {
		if (napierUser.isNew()) {
			Object[] args = new Object[] { napierUser.getLiferayUserId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_LIFERAYUSERID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LIFERAYUSERID, args,
				napierUser);

			args = new Object[] { napierUser.getTpaId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TPA, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TPA, args, napierUser);

			args = new Object[] { napierUser.getPatientId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PID, args, napierUser);

			args = new Object[] { napierUser.getMrNumber() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_MR, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MR, args, napierUser);

			args = new Object[] {
					napierUser.getUsername(), napierUser.getPassword()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CREDENTIALS, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CREDENTIALS, args,
				napierUser);
		}
		else {
			NapierUserModelImpl napierUserModelImpl = (NapierUserModelImpl)napierUser;

			if ((napierUserModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_LIFERAYUSERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { napierUser.getLiferayUserId() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_LIFERAYUSERID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LIFERAYUSERID,
					args, napierUser);
			}

			if ((napierUserModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_TPA.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { napierUser.getTpaId() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TPA, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TPA, args,
					napierUser);
			}

			if ((napierUserModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_PID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { napierUser.getPatientId() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PID, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PID, args,
					napierUser);
			}

			if ((napierUserModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_MR.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { napierUser.getMrNumber() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_MR, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MR, args,
					napierUser);
			}

			if ((napierUserModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_CREDENTIALS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						napierUser.getUsername(), napierUser.getPassword()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CREDENTIALS,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CREDENTIALS,
					args, napierUser);
			}
		}
	}

	protected void clearUniqueFindersCache(NapierUser napierUser) {
		NapierUserModelImpl napierUserModelImpl = (NapierUserModelImpl)napierUser;

		Object[] args = new Object[] { napierUser.getLiferayUserId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LIFERAYUSERID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_LIFERAYUSERID, args);

		if ((napierUserModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_LIFERAYUSERID.getColumnBitmask()) != 0) {
			args = new Object[] { napierUserModelImpl.getOriginalLiferayUserId() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LIFERAYUSERID,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_LIFERAYUSERID,
				args);
		}

		args = new Object[] { napierUser.getTpaId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TPA, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TPA, args);

		if ((napierUserModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_TPA.getColumnBitmask()) != 0) {
			args = new Object[] { napierUserModelImpl.getOriginalTpaId() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TPA, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TPA, args);
		}

		args = new Object[] { napierUser.getPatientId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PID, args);

		if ((napierUserModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_PID.getColumnBitmask()) != 0) {
			args = new Object[] { napierUserModelImpl.getOriginalPatientId() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PID, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PID, args);
		}

		args = new Object[] { napierUser.getMrNumber() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MR, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_MR, args);

		if ((napierUserModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_MR.getColumnBitmask()) != 0) {
			args = new Object[] { napierUserModelImpl.getOriginalMrNumber() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MR, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_MR, args);
		}

		args = new Object[] { napierUser.getUsername(), napierUser.getPassword() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CREDENTIALS, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CREDENTIALS, args);

		if ((napierUserModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_CREDENTIALS.getColumnBitmask()) != 0) {
			args = new Object[] {
					napierUserModelImpl.getOriginalUsername(),
					napierUserModelImpl.getOriginalPassword()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CREDENTIALS, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CREDENTIALS, args);
		}
	}

	/**
	 * Creates a new napier user with the primary key. Does not add the napier user to the database.
	 *
	 * @param id the primary key for the new napier user
	 * @return the new napier user
	 */
	@Override
	public NapierUser create(long id) {
		NapierUser napierUser = new NapierUserImpl();

		napierUser.setNew(true);
		napierUser.setPrimaryKey(id);

		String uuid = PortalUUIDUtil.generate();

		napierUser.setUuid(uuid);

		return napierUser;
	}

	/**
	 * Removes the napier user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the napier user
	 * @return the napier user that was removed
	 * @throws com.innominds.portlets.service.NoSuchNapierUserException if a napier user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NapierUser remove(long id)
		throws NoSuchNapierUserException, SystemException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the napier user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the napier user
	 * @return the napier user that was removed
	 * @throws com.innominds.portlets.service.NoSuchNapierUserException if a napier user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NapierUser remove(Serializable primaryKey)
		throws NoSuchNapierUserException, SystemException {
		Session session = null;

		try {
			session = openSession();

			NapierUser napierUser = (NapierUser)session.get(NapierUserImpl.class,
					primaryKey);

			if (napierUser == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchNapierUserException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(napierUser);
		}
		catch (NoSuchNapierUserException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected NapierUser removeImpl(NapierUser napierUser)
		throws SystemException {
		napierUser = toUnwrappedModel(napierUser);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(napierUser)) {
				napierUser = (NapierUser)session.get(NapierUserImpl.class,
						napierUser.getPrimaryKeyObj());
			}

			if (napierUser != null) {
				session.delete(napierUser);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (napierUser != null) {
			clearCache(napierUser);
		}

		return napierUser;
	}

	@Override
	public NapierUser updateImpl(
		com.innominds.portlets.service.model.NapierUser napierUser)
		throws SystemException {
		napierUser = toUnwrappedModel(napierUser);

		boolean isNew = napierUser.isNew();

		NapierUserModelImpl napierUserModelImpl = (NapierUserModelImpl)napierUser;

		if (Validator.isNull(napierUser.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			napierUser.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (napierUser.isNew()) {
				session.save(napierUser);

				napierUser.setNew(false);
			}
			else {
				session.merge(napierUser);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !NapierUserModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((napierUserModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						napierUserModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { napierUserModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}
		}

		EntityCacheUtil.putResult(NapierUserModelImpl.ENTITY_CACHE_ENABLED,
			NapierUserImpl.class, napierUser.getPrimaryKey(), napierUser);

		clearUniqueFindersCache(napierUser);
		cacheUniqueFindersCache(napierUser);

		return napierUser;
	}

	protected NapierUser toUnwrappedModel(NapierUser napierUser) {
		if (napierUser instanceof NapierUserImpl) {
			return napierUser;
		}

		NapierUserImpl napierUserImpl = new NapierUserImpl();

		napierUserImpl.setNew(napierUser.isNew());
		napierUserImpl.setPrimaryKey(napierUser.getPrimaryKey());

		napierUserImpl.setUuid(napierUser.getUuid());
		napierUserImpl.setId(napierUser.getId());
		napierUserImpl.setLiferayUserId(napierUser.getLiferayUserId());
		napierUserImpl.setUserType(napierUser.getUserType());
		napierUserImpl.setMrNumber(napierUser.getMrNumber());
		napierUserImpl.setTpaId(napierUser.getTpaId());
		napierUserImpl.setCoroporateId(napierUser.getCoroporateId());
		napierUserImpl.setPatientId(napierUser.getPatientId());
		napierUserImpl.setAge(napierUser.getAge());
		napierUserImpl.setMobile(napierUser.getMobile());
		napierUserImpl.setGender(napierUser.getGender());
		napierUserImpl.setAddress(napierUser.getAddress());
		napierUserImpl.setSpecialization(napierUser.getSpecialization());
		napierUserImpl.setFirstname(napierUser.getFirstname());
		napierUserImpl.setLastname(napierUser.getLastname());
		napierUserImpl.setUsername(napierUser.getUsername());
		napierUserImpl.setPassword(napierUser.getPassword());
		napierUserImpl.setEmail(napierUser.getEmail());

		return napierUserImpl;
	}

	/**
	 * Returns the napier user with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the napier user
	 * @return the napier user
	 * @throws com.innominds.portlets.service.NoSuchNapierUserException if a napier user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NapierUser findByPrimaryKey(Serializable primaryKey)
		throws NoSuchNapierUserException, SystemException {
		NapierUser napierUser = fetchByPrimaryKey(primaryKey);

		if (napierUser == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchNapierUserException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return napierUser;
	}

	/**
	 * Returns the napier user with the primary key or throws a {@link com.innominds.portlets.service.NoSuchNapierUserException} if it could not be found.
	 *
	 * @param id the primary key of the napier user
	 * @return the napier user
	 * @throws com.innominds.portlets.service.NoSuchNapierUserException if a napier user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NapierUser findByPrimaryKey(long id)
		throws NoSuchNapierUserException, SystemException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the napier user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the napier user
	 * @return the napier user, or <code>null</code> if a napier user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NapierUser fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		NapierUser napierUser = (NapierUser)EntityCacheUtil.getResult(NapierUserModelImpl.ENTITY_CACHE_ENABLED,
				NapierUserImpl.class, primaryKey);

		if (napierUser == _nullNapierUser) {
			return null;
		}

		if (napierUser == null) {
			Session session = null;

			try {
				session = openSession();

				napierUser = (NapierUser)session.get(NapierUserImpl.class,
						primaryKey);

				if (napierUser != null) {
					cacheResult(napierUser);
				}
				else {
					EntityCacheUtil.putResult(NapierUserModelImpl.ENTITY_CACHE_ENABLED,
						NapierUserImpl.class, primaryKey, _nullNapierUser);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(NapierUserModelImpl.ENTITY_CACHE_ENABLED,
					NapierUserImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return napierUser;
	}

	/**
	 * Returns the napier user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the napier user
	 * @return the napier user, or <code>null</code> if a napier user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NapierUser fetchByPrimaryKey(long id) throws SystemException {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the napier users.
	 *
	 * @return the napier users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<NapierUser> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<NapierUser> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<NapierUser> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<NapierUser> list = (List<NapierUser>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_NAPIERUSER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_NAPIERUSER;

				if (pagination) {
					sql = sql.concat(NapierUserModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<NapierUser>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<NapierUser>(list);
				}
				else {
					list = (List<NapierUser>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the napier users from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (NapierUser napierUser : findAll()) {
			remove(napierUser);
		}
	}

	/**
	 * Returns the number of napier users.
	 *
	 * @return the number of napier users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_NAPIERUSER);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	/**
	 * Initializes the napier user persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.innominds.portlets.service.model.NapierUser")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<NapierUser>> listenersList = new ArrayList<ModelListener<NapierUser>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<NapierUser>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(NapierUserImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_NAPIERUSER = "SELECT napierUser FROM NapierUser napierUser";
	private static final String _SQL_SELECT_NAPIERUSER_WHERE = "SELECT napierUser FROM NapierUser napierUser WHERE ";
	private static final String _SQL_COUNT_NAPIERUSER = "SELECT COUNT(napierUser) FROM NapierUser napierUser";
	private static final String _SQL_COUNT_NAPIERUSER_WHERE = "SELECT COUNT(napierUser) FROM NapierUser napierUser WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "napierUser.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No NapierUser exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No NapierUser exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(NapierUserPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid", "id", "password"
			});
	private static NapierUser _nullNapierUser = new NapierUserImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<NapierUser> toCacheModel() {
				return _nullNapierUserCacheModel;
			}
		};

	private static CacheModel<NapierUser> _nullNapierUserCacheModel = new CacheModel<NapierUser>() {
			@Override
			public NapierUser toEntityModel() {
				return _nullNapierUser;
			}
		};
}