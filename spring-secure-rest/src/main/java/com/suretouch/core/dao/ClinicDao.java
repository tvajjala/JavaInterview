package com.suretouch.core.dao;

import java.util.List;

import com.suretouch.core.domain.model.Clinic;
import com.suretouch.core.exceptions.DaoException;

public interface ClinicDao {

	public Clinic createClinic(Clinic clinic) throws DaoException;

	public Clinic updateClinic(Clinic clinic) throws DaoException;

	public Clinic deleteClinic(String clinicId) throws DaoException;

	public Clinic getClinicById(String clinicId) throws DaoException;

	public List<Clinic> getAllClinics() throws DaoException;

	public Clinic getClinicByName(String name) throws DaoException;
}
