package com.suretouch.core.domain.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;

/**
 * 
 * @author tvajjala
 *
 */
@Entity
public class Authority extends BaseEntity implements Serializable, GrantedAuthority {

	private static final long serialVersionUID = 418847605346388857L;

	
	public Authority(){
		// must have one default constructor 
	}
	
	@Id
	@Column(name = "AUTHORITY", unique = true, nullable = false, insertable = true, updatable = true, length = 36)
	private String authority;

	@Column(name = "ROLE_NAME",nullable=false,unique=true)
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
	
	public Authority(String authority,String roleName){
		this.authority=authority;
		this.roleName=roleName;
	}
	
	
	

}
