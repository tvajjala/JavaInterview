package com.suretouch.core.dao;

import java.util.List;

import com.suretouch.core.domain.model.Authority;
import com.suretouch.core.domain.model.User;
import com.suretouch.core.exceptions.DaoException;

public interface UserDao {

	public User createUser(User userEntity) throws DaoException;

	public User updateUser(User userEntity) throws DaoException;

	public List<User> getAllUsers() throws DaoException;

	public void deleteUser(String userId) throws DaoException;
	
	

	public Authority createAuthority(Authority Authority) throws DaoException;

	public Authority updateAuthority(Authority Authority) throws DaoException;

	public List<Authority> getAuthorities() throws DaoException;

	
	
	public void deleteAuthority(String AuthorityId) throws DaoException;

	public User getUserById(String userId) throws DaoException;

	public User getUserByEmail(String email) throws DaoException;

	public User getUserByUserName(String username) throws DaoException;
	
	public User getByToken(String token) throws DaoException;

}
