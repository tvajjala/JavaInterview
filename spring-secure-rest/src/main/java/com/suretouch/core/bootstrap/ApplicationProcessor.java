package com.suretouch.core.bootstrap;

import java.util.HashSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.suretouch.core.exceptions.ServiceException;
import com.suretouch.core.rest.model.AuthorityVO;
import com.suretouch.core.rest.model.ClinicVO;
import com.suretouch.core.rest.model.UserVO;
import com.suretouch.core.service.ClinicService;
import com.suretouch.core.service.UserService;

/**
 * 
 * @author tvajjala
 * 
 */

@Repository("applicationProcessor")
public class ApplicationProcessor {

	Logger logger = LoggerFactory.getLogger("SURETOUCH-CORE");

	@Autowired
	UserService userService;

	@Autowired
	ClinicService clinicService;

	public void init() {

		try {
			if (userService.getAllUsers().isEmpty()) {
				initializeUsers();
			}
		} catch (ServiceException e) {
			logger.error(e.getMessage());
		}
		logger.info("##########################################");
		logger.info("  SURETOUCH  REST SERVICES READY TO USE   ");
		logger.info("##########################################");
	}

	private void initializeUsers() {

		try {
			logger.info("######  INITILIZING DEFAULT DATA ##########");

			AuthorityVO authority = new AuthorityVO("ROLE_ADMIN",
					"ADMINSTRATOR");
			authority = userService.saveAuthority(authority);

			userService
					.saveAuthority(new AuthorityVO("ROLE_PATIENT", "PATIENT"));
			userService.saveAuthority(new AuthorityVO("ROLE_EXAMINER",
					"EXAMINER"));
			userService.saveAuthority(new AuthorityVO("ROLE_DOCTOR", "DOCTOR"));
			userService.saveAuthority(new AuthorityVO("ROLE_SCHEDULER",
					"SCHEDULER"));
			logger.info("ROLES CREATED");

			ClinicVO clinic = new ClinicVO("SURETOUCH");
			clinic.setActive(true);
			clinic = clinicService.saveClinic(clinic);

			logger.info("CLINICS CREATED");

			UserVO details = new UserVO();
			details.setUsername("admin");
			details.setPassword("1234");

			details.setAccountNonExpired(true);
			details.setAccountNonLocked(true);
			details.setCredentialsNonExpired(true);

			details.setEnabled(true);
			details.setFirstname("ThirupathiReddy");
			details.setLastname("Vajjala");
			details.setPhone("9xxx2xxx024");
			details.setEmail("tvajjala@innominds.com");
			details.setDesignation("SureTouch Administrator");

			details.setAuthorities(new HashSet<AuthorityVO>());
			details.getAuthorities().add(authority);

			details.setClinics(new HashSet<ClinicVO>());
			details.getClinics().add(clinic);

			userService.saveUser(details, false);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
