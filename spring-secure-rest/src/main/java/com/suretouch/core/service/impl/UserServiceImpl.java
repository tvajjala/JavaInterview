package com.suretouch.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.dao.SaltSource;
import org.springframework.security.authentication.encoding.BasePasswordEncoder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.suretouch.core.dao.ClinicDao;
import com.suretouch.core.dao.UserDao;
import com.suretouch.core.domain.model.Authority;
import com.suretouch.core.domain.model.User;
import com.suretouch.core.exceptions.DaoException;
import com.suretouch.core.exceptions.ServiceException;
import com.suretouch.core.rest.model.AuthorityVO;
import com.suretouch.core.rest.model.UserVO;
import com.suretouch.core.service.UserService;

@Service("userService")
@Transactional(isolation = Isolation.READ_COMMITTED)
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	@Autowired
	ClinicDao clinicDao;

	@Autowired
	private SaltSource saltSource;

	@Autowired
	private DozerBeanMapper dozerBeanMapper;

	@Autowired
	private BasePasswordEncoder passwordEncoder;

	Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public UserVO loadUserByUsername(String username)
			throws UsernameNotFoundException {
		UserVO userVO = new UserVO();
		try {

			User user = userDao.getUserByUserName(username);
			user.getAuthorities().size();
			user.getClinics().size();
			dozerBeanMapper.map(user, userVO);

		} catch (DaoException e) {
			throw new UsernameNotFoundException(e.getMessage());
		}

		return userVO;
	}

	@Override
	public UserVO getUserByMail(String email) throws ServiceException {
		UserVO userVO = new UserVO();
		try {
			dozerBeanMapper.map(userDao.getUserByEmail(email), userVO);
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage());
		}
		return userVO;
	}

	@Override
	public UserVO getUserById(String userId) throws ServiceException {
		UserVO userVO = new UserVO();
		try {
			dozerBeanMapper.map(userDao.getUserById(userId), userVO);
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage());
		}
		return userVO;
	}

	@SuppressWarnings("all")
	@Override
	public List<UserVO> getAllUsers() throws ServiceException {

		List<UserVO> list = new ArrayList<UserVO>();
		try {
			dozerBeanMapper.map(userDao.getAllUsers(), list);

			for (User user : userDao.getAllUsers()) {
				UserVO userVO = new UserVO();

				dozerBeanMapper.map(user, userVO);
				userVO.setPassword(null);
				userVO.setSalt(null);
				userVO.setAccessToken(null);
				list.add(userVO);
			}

		} catch (DaoException e) {
			throw new ServiceException(e.getMessage());
		}

		return list;
	}

	@Override
	public UserVO saveUser(UserVO userVO, boolean isPasswordAlreadyEncryped)
			throws ServiceException {

		User user = new User();

		try {
			if (!isPasswordAlreadyEncryped) {
				encryptPassword(userVO);
			}

			dozerBeanMapper.map(userVO, user);

			dozerBeanMapper.map(userDao.createUser(user), userVO);
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage());
		}
		return userVO;
	}

	@Override
	public UserVO saveUser(UserVO user) throws ServiceException {

		return saveUser(user, false);
	}

	@SuppressWarnings("deprecation")
	public void encryptPassword(UserVO user) {

		String password = user.getPassword();
		Object salt = saltSource.getSalt(user);
		logger.info("salt  " + salt);

		user.setPassword(passwordEncoder.encodePassword(password, salt));
	}

	@Override
	public UserVO updateUser(UserVO userVO) throws ServiceException {

		User user = new User();
		try {
			dozerBeanMapper.map(userVO, user);

			User u = userDao.getUserByUserName(user.getUsername());
			user.setAuthorities(u.getAuthorities());
			user.setClinics(u.getClinics());

			user = userDao.updateUser(user);

			dozerBeanMapper.map(user, userVO);
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage());
		}

		return userVO;
	}

	@Override
	public AuthorityVO saveAuthority(AuthorityVO authorityVO)
			throws ServiceException {

		Authority authority = new Authority();
		try {
			dozerBeanMapper.map(authorityVO, authority);
			System.out
					.println("*******************************************************************");
			System.out.println("  authority  " + authority.getAuthority()
					+ authority.getRoleName());
			authority = userDao.createAuthority(authority);
			dozerBeanMapper.map(authority, authorityVO);

		} catch (DaoException e) {
			throw new ServiceException(e.getMessage());
		}
		return authorityVO;
	}

	@SuppressWarnings("all")
	@Override
	public List<AuthorityVO> getAuthorities() throws ServiceException {

		List<AuthorityVO> list = new ArrayList<AuthorityVO>();
		try {
			dozerBeanMapper.map(userDao.getAuthorities(), list);

		} catch (DaoException e) {
			throw new ServiceException(e.getMessage());
		}
		return list;
	}

	@Override
	public UserVO getByToken(String token) throws ServiceException {

		UserVO userVO = new UserVO();
		try {
			User user = userDao.getByToken(token);
			user.getAuthorities().size();
			user.getClinics().size();

			if (user.isEnabled() && user.isAccountNonExpired()
					&& user.isAccountNonLocked()
					&& user.isCredentialsNonExpired()) {

				dozerBeanMapper.map(user, userVO);
				dozerBeanMapper.map(user.getAuthorities(),
						userVO.getAuthorities());
				dozerBeanMapper.map(user.getClinics(), userVO.getClinics());
			} else {
				logger.warn(" account  locked or credentials expired ");
				throw new ServiceException(
						" account  locked  or credentials expired ");
			}

		} catch (DaoException e) {
			throw new ServiceException(e.getMessage());
		}

		return userVO;

	}

}
