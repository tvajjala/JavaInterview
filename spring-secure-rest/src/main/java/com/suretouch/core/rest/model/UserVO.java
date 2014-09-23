package com.suretouch.core.rest.model;

import java.io.Serializable;
import java.util.Set;

import org.springframework.security.core.userdetails.UserDetails;

public class UserVO implements UserDetails, Serializable {

	private static final long serialVersionUID = 8825646974241476909L;

	private String userId;

	private String username;

	private String password;

	private String designation;

	private String firstname;

	private String lastname;

	private String middlename;

	private String email;

	private String phone;

	private String gender;

	private String salt;

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public Long lastLoginTime;

	public void setLastLoginTime(Long lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public Long getLastLoginTime() {
		return lastLoginTime;
	}

	public String accessToken;

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public String getSalt() {
		return salt;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	private Set<AuthorityVO> authorities;

	public void setAuthorities(Set<AuthorityVO> authorities) {
		this.authorities = authorities;
	}

	@Override
	public Set<AuthorityVO> getAuthorities() {
		return authorities;
	}

	private Set<ClinicVO> clinics;

	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Set<ClinicVO> getClinics() {
		return clinics;
	}

	public void setClinics(Set<ClinicVO> clinics) {
		this.clinics = clinics;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	private boolean accountNonExpired;

	private boolean credentialsNonExpired;

	private boolean enabled;

	private boolean accountNonLocked;

	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {

		return accountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {

		return credentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {

		return enabled;
	}

}
