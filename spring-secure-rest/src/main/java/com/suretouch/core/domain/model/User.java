package com.suretouch.core.domain.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;

import org.hibernate.annotations.Type;
import org.springframework.security.core.userdetails.UserDetails;

import com.suretouch.core.domain.SureTouchObjectType;
import com.suretouch.core.domain.UUIDGenerator;

@Entity
public class User extends BaseEntity implements UserDetails, Serializable {

	private static final long serialVersionUID = 8825646974241476909L;

	@Id
	@Column(name = "USER_ID", unique = true, nullable = false, insertable = true, updatable = true, length = 36)
	private String userId;

	@Column(name = "USERNAME", nullable = false, length = 150, unique = true)
	private String username;

	@Column(name = "PASSWORD", nullable = false, length = 150)
	private String password;

	@Column(name = "DESIGNATION", length = 30)
	private String designation;

	@Column(name = "FIRST_NAME", nullable = false, length = 45)
	private String firstname;

	@Column(name = "LAST_NAME", nullable = true, length = 45)
	private String lastname;

	@Column(name = "MIDDLE_NAME", nullable = true, length = 45)
	private String middlename;

	@Column(name = "EMAIL", nullable = true, length = 150, unique = true)
	private String email;

	@Column(name = "PHONE", nullable = true, length = 30)
	private String phone;

	@Column(name = "GENDER", nullable = true, length = 10)
	private String gender;

	@Column(name = "SALT", nullable = true, length = 50)
	private String salt;

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public long lastLoginTime;

	public void setLastLoginTime(long lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public long getLastLoginTime() {
		return lastLoginTime;
	}

	@Column(name = "accessToken", nullable = true, length = 500)
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

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "USER_ROLE", joinColumns = { @JoinColumn(name = "USER_ID") }, inverseJoinColumns = { @JoinColumn(name = "AUTHORITY") })
	private Set<Authority> authorities;

	public void setAuthorities(Set<Authority> authorities) {
		this.authorities = authorities;
	}

	@Override
	public Set<Authority> getAuthorities() {
		return authorities;
	}

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "USER_CLINIC", joinColumns = { @JoinColumn(name = "USER_ID") }, inverseJoinColumns = { @JoinColumn(name = "CLINIC_ID") })
	private Set<Clinic> clinics;

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

	public Set<Clinic> getClinics() {
		return clinics;
	}

	public void setClinics(Set<Clinic> clinics) {
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

	@PrePersist
	public void generateId() {
		System.out.println("@PrePersist    ");

		if (userId == null) {

			System.out.println("@PrePersist    2");
			setUserId(UUIDGenerator.generateUUID(
					SureTouchObjectType.USER.getObjectType(), this.getClass()));
		}
	}

}
