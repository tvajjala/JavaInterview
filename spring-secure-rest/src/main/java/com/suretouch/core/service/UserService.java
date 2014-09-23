package com.suretouch.core.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.suretouch.core.exceptions.ServiceException;
import com.suretouch.core.rest.model.AuthorityVO;
import com.suretouch.core.rest.model.UserVO;

public interface UserService extends UserDetailsService {

	public UserVO saveUser(UserVO user, boolean isPasswordAlreadyEncryped)
			throws ServiceException;

	public AuthorityVO saveAuthority(AuthorityVO authority) throws ServiceException;

	public UserVO saveUser(UserVO user) throws ServiceException;

	public List<UserVO> getAllUsers() throws ServiceException;

	public List<AuthorityVO> getAuthorities() throws ServiceException;

	public UserVO updateUser(UserVO user) throws ServiceException;

	public UserVO getUserByMail(String email) throws ServiceException;

	public UserVO getUserById(String userId) throws ServiceException;

	

	public void encryptPassword(UserVO user);
	
	public UserVO getByToken(String token) throws ServiceException;
}
