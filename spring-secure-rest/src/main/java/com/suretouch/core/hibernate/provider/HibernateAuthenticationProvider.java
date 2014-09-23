package com.suretouch.core.hibernate.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.authentication.dao.SaltSource;
import org.springframework.security.authentication.encoding.BasePasswordEncoder;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.Assert;

import com.suretouch.core.service.UserService;

/**
 * 
 * @author tvajjala
 * 
 */

public class HibernateAuthenticationProvider extends
		AbstractUserDetailsAuthenticationProvider {

	@Autowired
	private BasePasswordEncoder passwordEncoder;

	@Autowired
	private SaltSource saltSource;

	@Autowired
	private UserService userService;

	private boolean includeDetailsObject = true;

	@SuppressWarnings("all")
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {

		Object salt = null;

		if (this.saltSource != null) {
			salt = this.saltSource.getSalt(userDetails);
		}

		logger.info("authentication check with salt " + salt);

		if (authentication.getCredentials() == null) {
			throw new BadCredentialsException("Enter Username and Password ");
		}

		String presentedPassword = authentication.getCredentials().toString();

		logger.info("presentedPassword  " + presentedPassword);

		logger.info("userDetails.getPassword()  " + userDetails.getPassword());
		
		if (!passwordEncoder.isPasswordValid(userDetails.getPassword(),
				presentedPassword, salt)) {
			throw new BadCredentialsException(" Invalid Username or Password ");
		}
	}

	protected void doAfterPropertiesSet() throws Exception {
		Assert.notNull(this.userService,
				"A UserDetailsService must be set");
	}

	protected UserDetails retrieveUser(String username,
			UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {
		UserDetails loadedUser;

		if ((username == null) || (username.trim().length() < 1)) {
			throw new AuthenticationServiceException(
					" Enter Valid Username and Passowrd ");
		}

		try {
			loadedUser = userService
					.loadUserByUsername(username);
		} catch (DataAccessException repositoryProblem) {
			throw new AuthenticationServiceException(
					"Enter Valid Username or Password");
		}

		if (loadedUser == null) {
			throw new AuthenticationServiceException(
					"Invalid Username or Password ");
		}
		return loadedUser;
	}

	public void setPasswordEncoder(BasePasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	protected BasePasswordEncoder getPasswordEncoder() {
		return passwordEncoder;
	}

	public void setSaltSource(SaltSource saltSource) {
		this.saltSource = saltSource;
	}

	protected SaltSource getSaltSource() {
		return saltSource;
	}

	

	protected boolean isIncludeDetailsObject() {
		return includeDetailsObject;
	}

	public void setIncludeDetailsObject(boolean includeDetailsObject) {
		this.includeDetailsObject = includeDetailsObject;
	}

}
