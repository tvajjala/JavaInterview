package com.suretouch.core.service;

import java.util.List;

import com.suretouch.core.exceptions.ServiceException;
import com.suretouch.core.rest.model.ClinicVO;

public interface ClinicService {

	public ClinicVO saveClinic(ClinicVO ClinicVO) throws ServiceException;

	public ClinicVO updateClinic(ClinicVO ClinicVO) throws ServiceException;

	public List<ClinicVO> getAllClinics() throws ServiceException;

	public ClinicVO getClincById(String userId) throws ServiceException;

	public ClinicVO getClinicByName(String name) throws ServiceException;
	
	public ClinicVO deleteClinic(String clinicId) throws ServiceException;

}
