package com.suretouch.core.dao.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.suretouch.core.dao.ClinicDao;
import com.suretouch.core.domain.model.Clinic;
import com.suretouch.core.exceptions.DaoException;

/**
 * 
 * @author kgajjala
 * 
 * @param <T>
 * @param <PK>
 */
@Repository("clinicDao")
@SuppressWarnings("all")
public class ClinicDaoImpl<T, PK> extends GenericDaoImpl<T, PK> implements
		ClinicDao {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public Clinic createClinic(Clinic clinic) throws DaoException {
		try {
			return (Clinic) super.create(clinic);
		} catch (RuntimeException e) {
			throw new DaoException(e);
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	@Override
	public Clinic updateClinic(Clinic clinic) throws DaoException {
		try {
			return (Clinic) super.update(clinic);
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	@Override
	public Clinic getClinicById(String clinicId) throws DaoException {
		Clinic clinic;
		try {
			clinic = (Clinic) super.get(Clinic.class, clinicId);
		} catch (Exception e) {
			throw new DaoException(e);
		}
		return clinic;
	}

	@Override
	public Clinic deleteClinic(String clinicId) throws DaoException {
		try {
			Clinic clinic = this.getClinicById(clinicId);
			clinic.setActive(false);
			return this.updateClinic(clinic);
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	public List<Clinic> getAllClinics() throws DaoException {
		try {
			return (List<Clinic>) super.searchObjects(Clinic.class, null, null);
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	public Clinic getClinicByName(String name) throws DaoException {
		try {
			List<Clinic> userList = (List<Clinic>) super.searchObjects(
					Clinic.class, "name=?", new Object[] { name });
			if (userList != null && !userList.isEmpty()) {
				return userList.get(0);
			} else {
				throw new DaoException("No clinic found with name : " + name);
			}
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

}
