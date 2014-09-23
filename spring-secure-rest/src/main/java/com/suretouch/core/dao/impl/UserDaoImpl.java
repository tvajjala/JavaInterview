package com.suretouch.core.dao.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.suretouch.core.dao.UserDao;
import com.suretouch.core.domain.model.Authority;
import com.suretouch.core.domain.model.Clinic;
import com.suretouch.core.domain.model.User;
import com.suretouch.core.exceptions.DaoException;

/**
 * 
 * @author kgajjala
 * 
 * @param <T>
 * @param <PK>
 */
@Repository("userDao")
@SuppressWarnings("all")
public class UserDaoImpl<T, PK> extends GenericDaoImpl<T, PK> implements
		UserDao {

	Logger logger = LoggerFactory.getLogger(getClass());

	public User createUser(User userEntity) throws DaoException {
		logger.debug("Entered UserDAO create method");
		try {
			userEntity = (User) super.create(userEntity);
		} catch (Exception e) {
			logger.error("Exception while creating user");
			throw new DaoException(e);
		}
		logger.debug("Completed user create operation ");
		return userEntity;
	}

	public Authority createAuthority(Authority Authority) throws DaoException {
		try {
			return (Authority) super.create(Authority);
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	public User updateUser(User userEntity) throws DaoException {
		try {
			userEntity = (User) super.update(userEntity);
		} catch (Exception e) {
			throw new DaoException(e);
		}
		return userEntity;
	}

	public User getUserById(String userId) throws DaoException {
		User user;
		try {
			user = (User) super.get(User.class, userId);
		} catch (Exception e) {
			throw new DaoException(e);
		}
		return user;
	}

	public void deleteUser(String userId) throws DaoException {
		try {
			User user = this.getUserById(userId);
			user.setEnabled(false);
			this.update(user);
		} catch (Exception e) {
			throw new DaoException(e);
		}

	}

	public List<User> getAllUsers() throws DaoException {
		try {
			return (List<User>) super.searchObjects(User.class, null, null);
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	public List<Authority> getAuthorities() throws DaoException {
		try {
			return (List<Authority>) super.searchObjects(Authority.class, null,
					null);
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	public void deleteAuthority(String AuthorityId) throws DaoException {
		try {
			super.delete(Authority.class, AuthorityId);
		} catch (Exception e) {
			throw new DaoException(e);
		}

	}

	public Authority updateAuthority(Authority Authority) throws DaoException {
		try {
			return (Authority) super.update(Authority);
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	public User getUserByEmail(String email) throws DaoException {
		try {
			List<User> userList = (List<User>) super.searchObjects(User.class,
					"email=?", new Object[] { email });
			if (userList != null && !userList.isEmpty()) {
				return userList.get(0);
			} else {
				throw new DaoException("No user found with email " + email);
			}
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	public User getUserByUserName(String username) throws DaoException {
		try {
			List<User> userList = (List<User>) super.searchObjects(User.class,
					"username=?", new Object[] { username });
			if (userList != null && !userList.isEmpty()) {
				return userList.get(0);
			} else {
				throw new DaoException("No user found with username "
						+ username);
			}
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	@Override
	public User getByToken(String token) throws DaoException {
		try {
			List<User> userList = (List<User>) super.searchObjects(User.class,
					"accessToken=?", new Object[] { token });
			if (userList != null && !userList.isEmpty()) {
				return userList.get(0);
			} else {
				throw new DaoException("No user found with token " + token);
			}
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

}
