package com.suretouch.web.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.suretouch.core.exceptions.ServiceException;
import com.suretouch.core.rest.model.ClinicVO;
import com.suretouch.core.service.ClinicService;

@RestController("clinicController")
@RequestMapping(value = "/clinic")
public class ClinicController {

	@Autowired
	private ClinicService clinicService;

	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public @ResponseBody
	ClinicVO getClinc(@PathVariable("name") String name) {

		try {
			return clinicService.getClinicByName(name);
		} catch (ServiceException e) {
			e.printStackTrace();
		}

		return null;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public String deleteClinic(@PathVariable("id") String clinicId) {

		try {
			clinicService.deleteClinic(clinicId);
		} catch (ServiceException e) {
			e.printStackTrace();
			return "clinic deleted failed";
		}

		return "clinic delete successfully";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody()
	public Object createEmployee(@RequestBody ClinicVO clinicVO) {
		// logger.info("Start createEmployee.");

		try {
			return clinicService.saveClinic(clinicVO);
		} catch (Exception e) {
			if (e instanceof DataIntegrityViolationException) {
				return "invalid clinic name or clinic already exists";
			} else {
				return e.getMessage();
			}
		}
		// return null;
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody()
	public List<ClinicVO> getAll() {

		try {
			return clinicService.getAllClinics();
		} catch (ServiceException e) {
			e.printStackTrace();
		}

		return null;
	}
}
