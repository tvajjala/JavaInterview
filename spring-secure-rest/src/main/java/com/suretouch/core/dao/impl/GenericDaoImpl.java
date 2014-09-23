package com.suretouch.core.dao.impl;

/*
 * Singleton class to create any kind of DAO
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.suretouch.core.dao.GenericDao;
import com.suretouch.core.exceptions.DaoException;

/**
 * The Class GenericDaoImpl.
 * 
 * @author kgajjala
 * @param <T>
 *            the generic type
 * @param <PK>
 *            the generic type
 */
@SuppressWarnings("all")
@Repository("genericDao")
// @Transactional()
public class GenericDaoImpl<T, PK> implements GenericDao {

	Logger logger = LoggerFactory.getLogger(getClass());

	private EntityManager em;

	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Object create(Object newInstance) throws DaoException {
		T rtn = null;
		try {
			rtn = em.merge((T) newInstance);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException(e);
		} finally {
			em.close();
		}
		return rtn;
	}

	public Object get(Class type, Serializable id) throws DaoException {
		Object rtn = null;
		if (em != null) {
			try {
				rtn = em.find(type, id);
				// em.detach(rtn);
			} catch (Exception e) {
				throw new DaoException(e);
			} finally {
				em.close();
			}
		}
		return rtn;
	}

	public Object update(Object transientObject) throws DaoException {
		return create(transientObject);
	}

	public void delete(Class type, Serializable id) throws DaoException {
		if (em != null) {
			synchronized (em) {
				try {
					Object o = em.getReference(type, id);
					em.remove(o);
				} catch (Exception e) {
					throw new DaoException(e);
				} finally {
					em.close();
				}
			}
		}
	}

	public List getObjects(Class type, String queryString) throws DaoException {
		List items = new ArrayList();
		if (em != null) {
			try {
				Query query = em.createQuery("SELECT o FROM "
						+ type.getName()
						+ " o "
						+ (queryString == null || queryString.isEmpty() ? ""
								: " WHERE " + queryString));
				items = query.getResultList();
			} catch (Exception e) {
				e.printStackTrace();
				throw new DaoException(e);
			} finally {
				em.close();
			}
		}
		return items;
	}

	public List searchObjects(Class type, String queryString,
			Object[] queryParams) throws DaoException {
		List items = new ArrayList();

		if (em != null) {
			try {
				Query query = em.createQuery("SELECT o FROM "
						+ type.getName()
						+ " o "
						+ (queryString == null || queryString.isEmpty() ? ""
								: " WHERE " + queryString));
				if (queryString != null && !queryString.isEmpty()) {
					int i = 0;
					for (Object queryParam : queryParams) {
						query.setParameter(++i, queryParam);
					}
				}
				items = query.getResultList();
			} catch (Exception e) {
				e.printStackTrace();
				throw new DaoException(e);
			} finally {
				em.close();
			}
		}
		return items;
	}

	public List<Object> getConfinedObjects(Class type, String queryString,
			int offset, int limit) throws DaoException {
		List items = new ArrayList();
		if (em != null) {
			try {
				Query query = em.createQuery("SELECT o FROM "
						+ type.getName()
						+ " o "
						+ (queryString == null || queryString.isEmpty() ? ""
								: " WHERE " + queryString));
				query.setFirstResult(offset).setMaxResults(limit)
						.getResultList();
				items = query.getResultList();
			} catch (Exception e) {
				e.printStackTrace();
				throw new DaoException(e);
			} finally {
				em.close();
			}
		}
		return items; // return entityManager().createQuery("from Model m",
						// Model.class).setFirstResult(offset).setMaxResults(max).getResultList();
	}

	public List getCustomObjects(Class type, String columns, String queryString)
			throws DaoException {
		List items = new ArrayList();
		if (em != null) {
			try {
				Query query = em.createQuery("SELECT "
						+ columns
						+ " FROM "
						+ type.getName()
						+ (queryString == null || queryString.isEmpty() ? ""
								: " WHERE " + queryString));
				items = query.getResultList();
			} catch (Exception e) {
				e.printStackTrace();
				throw new DaoException(e);
			} finally {
				em.close();
			}
		}
		return items;
	}

	public void removeObjectUsingCompositeKey(Class type, Object compositeId)
			throws DaoException {
		if (em != null) {
			try {
				Object o = em.getReference(type, compositeId);
				em.remove(o);
			} catch (Exception e) {
				throw new DaoException(e);
			} finally {
				em.close();
			}
		}

	}

	public List getEntitiesByNativeQuery(String queryString)
			throws DaoException {
		List items = new ArrayList();
		if (em != null) {
			try {
				Query query = em.createNativeQuery(queryString);
				items = query.getResultList();
			} catch (Exception e) {
				e.printStackTrace();
				throw new DaoException(e);
			} finally {
				em.close();
			}
		}
		return items;
	}

	public void executeNamedQuery(String queryString, Object[] params)
			throws DaoException {
		if (em != null) {
			try {
				Query qry = em.createNamedQuery(queryString);
				int position = 1;
				for (Object object : params) {
					qry.setParameter(position, params[position - 1]);
					position++;
				}
				qry.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
				throw new DaoException(e);
			} finally {
				em.close();
			}
		}
	}

	public void executeNativeQuery(String queryString) throws DaoException {
		if (em != null) {
			try {
				Query qry = em.createNativeQuery(queryString);
				qry.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
				throw new DaoException(e);
			} finally {
				em.close();
			}
		}
	}
}
