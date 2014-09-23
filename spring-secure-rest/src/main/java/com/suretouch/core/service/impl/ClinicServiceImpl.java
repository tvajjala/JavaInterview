package com.suretouch.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.suretouch.core.dao.ClinicDao;
import com.suretouch.core.domain.model.Clinic;
import com.suretouch.core.exceptions.DaoException;
import com.suretouch.core.exceptions.ServiceException;
import com.suretouch.core.rest.model.ClinicVO;
import com.suretouch.core.service.ClinicService;

@Service("clinicService")
@Transactional(isolation = Isolation.READ_COMMITTED)
public class ClinicServiceImpl implements ClinicService {

	@Autowired
	ClinicDao clinicDao;

	@Autowired
	private DozerBeanMapper dozerBeanMapper;

	@Override
	public ClinicVO saveClinic(ClinicVO clinicVO) throws ServiceException {
		try {

			Clinic clinic = new Clinic();
			dozerBeanMapper.map(clinicVO, clinic);
			clinic = clinicDao.createClinic(clinic);
			dozerBeanMapper.map(clinic, clinicVO);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return clinicVO;
	}

	@Override
	public ClinicVO updateClinic(ClinicVO clinicVO) throws ServiceException {

		try {
			Clinic clinic = new Clinic();
			dozerBeanMapper.map(clinicVO, clinic);
			clinicDao.updateClinic(clinic);
			dozerBeanMapper.map(clinic, clinicVO);

		} catch (DaoException e) {
			throw new ServiceException(e.getMessage());
		}
		return clinicVO;
	}

	@Override
	public List<ClinicVO> getAllClinics() throws ServiceException {
		List<ClinicVO> list = new ArrayList<ClinicVO>();
		try {
			dozerBeanMapper.map(clinicDao.getAllClinics(), list);
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage());
		}
		return list;
	}

	@Override
	public ClinicVO getClincById(String clinicId) throws ServiceException {
		ClinicVO clinicVO = new ClinicVO();
		try {
			dozerBeanMapper.map(clinicDao.getClinicById(clinicId), clinicVO);
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage());
		}
		return clinicVO;
	}

	@Override
	public ClinicVO getClinicByName(String name) throws ServiceException {
		ClinicVO clinicVO = new ClinicVO();
		try {
			dozerBeanMapper.map(clinicDao.getClinicByName(name), clinicVO);
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage());
		}

		return clinicVO;
	}

	public ClinicVO deleteClinic(String clinicId) throws ServiceException {
		ClinicVO clinicVO = new ClinicVO();
		
		try {
			dozerBeanMapper.map(clinicDao.deleteClinic(clinicId), clinicVO);
			return clinicVO;
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage());
		}

	}

}
