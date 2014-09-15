package com.suretouch.hbm;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "USERS")
public class Employee implements UserDetails, Serializable {

	private static final long serialVersionUID = 8825646974241476909L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ID")
	private Long userId;

	@Column(name = "USERNAME", nullable = false, length = 30, unique = true)
	private String username;

	@Column(name = "PASSWORD", nullable = false, length = 30)
	private String password;

	@Column(name = "DESIGNATION", length = 30)
	private String designation;

	@Column(name = "FIRSTNAME", nullable = false, length = 30)
	private String firstname;

	@Column(name = "LASTNAME", nullable = true, length = 30)
	private String lastname;

	@Column(name = "EMAIL", nullable = true, length = 30, unique = true)
	private String email;

	@Column(name = "PHONE", nullable = true, length = 30)
	private String phone;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
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

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "USER_ROLES", joinColumns = { @JoinColumn(name = "USER_ID") }, inverseJoinColumns = { @JoinColumn(name = "AUTHORITY") })
	private Set<Authority> authorities;

	public void setAuthorities(Set<Authority> authorities) {
		this.authorities = authorities;
	}

	@Override
	public Set<Authority> getAuthorities() {
		return authorities;
	}

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "USER_ORGS", joinColumns = { @JoinColumn(name = "USER_ID") }, inverseJoinColumns = { @JoinColumn(name = "ORG_ID") })
	private Set<Organization> organizations;

	public Set<Organization> getOrganizations() {
		return organizations;
	}

	public void setOrganizations(Set<Organization> organizations) {
		this.organizations = organizations;
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

	@Column(name = "accountNonExpired")
	@Type(type = "yes_no")
	private boolean accountNonExpired;

	@Column(name = "credentialsNonExpired")
	@Type(type = "yes_no")
	private boolean credentialsNonExpired;

	@Column(name = "enabled")
	@Type(type = "yes_no")
	private boolean enabled;

	@Column(name = "accountNonLocked")
	@Type(type = "yes_no")
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
