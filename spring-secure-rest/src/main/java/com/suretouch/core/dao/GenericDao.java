package com.suretouch.core.dao;

import java.io.Serializable;
import java.util.List;

import com.suretouch.core.exceptions.DaoException;

/**
 * The Interface GenericDao.
 * 
 * @author kgajjala
 * 
 * @param <T>
 *            the generic type
 * @param <PK>
 *            the generic type
 */
@SuppressWarnings("all")
public interface GenericDao<T, PK extends Serializable> {

	/**
	 * Persist the newInstance object into database.
	 * 
	 * @param newInstance
	 *            the new instance
	 * @return the t
	 */
	public T create(T newInstance) throws DaoException;

	/*
	 * Retrieve an object that was previously persisted to the database using
	 * the indicated id as primary key.
	 * 
	 * @param type the type
	 * 
	 * @param id the id
	 * 
	 * @return the t
	 */
	public T get(Class type, PK id) throws DaoException;

	/**
	 * Save changes made to a persistent object.
	 * 
	 * @param transientObject
	 *            the transient object
	 */
	public T update(T transientObject) throws DaoException;

	/**
	 * Remove an object from persistent storage in the database.
	 * 
	 * @param type
	 *            the type
	 * @param id
	 *            the id
	 */
	public void delete(Class type, PK id) throws DaoException;

	/**
	 * Gets the objects.
	 * 
	 * @param type
	 *            the type
	 * @param query
	 *            the query
	 * @return the objects
	 */
	public List<T> getObjects(Class type, String query) throws DaoException;

	/**
	 * Gets the objects.
	 * 
	 * @param type
	 *            the type
	 * @param query
	 *            the query
	 * @return the objects
	 */
	public List<T> searchObjects(Class type, String queryString,
			Object[] queryParams) throws DaoException;

}