package com.suretouch.core.rest.model;

import java.io.Serializable;

import org.springframework.security.core.GrantedAuthority;

/**
 * 
 * @author tvajjala
 *
 */

public class AuthorityVO implements Serializable, GrantedAuthority {

	private static final long serialVersionUID = 418847605346388857L;

	public AuthorityVO() {
		// must have one default constructor
	}

	private String authority;

	private String roleName;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public AuthorityVO(String authority, String roleName) {
		this.authority = authority;
		this.roleName = roleName;
	}

}
	