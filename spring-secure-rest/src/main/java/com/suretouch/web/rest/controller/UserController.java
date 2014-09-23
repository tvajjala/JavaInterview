package com.suretouch.web.rest.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.suretouch.core.exceptions.ServiceException;
import com.suretouch.core.rest.model.UserVO;
import com.suretouch.core.service.ClinicService;
import com.suretouch.core.service.UserService;

@RestController("userController")
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private ClinicService clinicService;

	@Autowired
	AuthenticationManager authenticationManager;

	@RequestMapping(value = "/{username}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody()
	public UserVO getUser(@PathVariable("username") final String username,
			final UriComponentsBuilder uriBuilder,
			final HttpServletResponse response) {
		UserVO profile = null;
		try {
			profile = (UserVO) userService.loadUserByUsername(username);

			profile.setSalt(null);

			profile.setPassword("[PROTECTED]");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return profile;
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody()
	public List<UserVO> getAll() {

		
		try {
			 return userService.getAllUsers();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	


	
	
	
	
	
	
	

}
