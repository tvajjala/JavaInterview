package com.suretouch.core.audit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;

public class JpaAuditorAware implements AuditorAware<String> {

	Logger logger = LoggerFactory.getLogger(JpaAuditorAware.class);

	@Override
	public String getCurrentAuditor() {
		logger.info("      getCurrentAuditor          ");
		return SecurityContextHolder.getContext().getAuthentication().getName();

	}

}
