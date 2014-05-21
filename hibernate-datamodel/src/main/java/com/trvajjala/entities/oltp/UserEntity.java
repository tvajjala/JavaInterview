package com.trvajjala.entities.oltp;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.trvajjala.entities.constants.Country;
import com.trvajjala.entities.constants.Gender;
import com.trvajjala.entities.constants.Region;
import com.trvajjala.entities.constants.UserType;

@Entity
@Table(name = "USER")
public class UserEntity implements Serializable {

	private static final long serialVersionUID = -5164985606004511409L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;

	@Column(name = "CUSTOMERID", unique = true, length = 6, nullable = false)
	private Integer customerID;

	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private UserType userType;

	@Column(length = 70, nullable = false)
	private String firstName;

	@Column(length = 70, nullable = true)
	private String lastName;

	@Column(length = 255, nullable = false, unique = true)
	private String email;

	@Column(length = 15, nullable = true, unique = true)
	private String phoneNumber;

	@Column(length = 128)
	private String password;

	private Integer passwordFormat;

	@Column(length = 128)
	private String passwordSalt;

	@Column(length = 100)
	private String firstNameKANA;

	@Column(length = 100)
	private String lastNameKANA;

	@Column(length = 256)
	private String passwordQuestion;

	@Column(length = 128)
	private String passwordAnswer;

	private Date lastPasswordChangedDate;

	@ManyToOne
	@JoinColumn(name = "billingAddressId")
	private AddressEntity billingAddress;

	@ManyToOne
	@JoinColumn(name = "shippingAddressId")
	private AddressEntity shippingAddress;

	@Enumerated(EnumType.STRING)
	@Column(length = 10)
	private Gender gender;

	@Column(length = 100)
	private String legacyCustomerNumber;

	@Column(name = "isSubscribedToNewsLetter")
	private Boolean subscribedToNewsLetter;

	private String channelCode;

	@Enumerated(EnumType.STRING)
	@Column(length = 10, nullable = false)
	private Country registeredCountry;

	@Enumerated(EnumType.STRING)
	@Column(length = 10)
	private Country recentlyVisitedCountry;

	@Column(nullable = true, name = "isEnabled", columnDefinition = "TINYINT(1) DEFAULT 1")
	private Boolean enabled;

	@Column(nullable = true, name = "isAccountNonExpired", columnDefinition = "TINYINT(1) DEFAULT 1")
	private Boolean accountNonExpired;

	@Column(nullable = true, name = "isAccountNonLocked", columnDefinition = "TINYINT(1) DEFAULT 1")
	private Boolean accountNonLocked;

	@Column(nullable = true, name = "isCredentialsNonExpired", columnDefinition = "TINYINT(1) DEFAULT 1")
	private Boolean credentialsNonExpired;

	private Date lastLoginTime;

	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private Region region;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "USER_GROUPS", joinColumns = { @JoinColumn(name = "userId") }, inverseJoinColumns = { @JoinColumn(name = "userGroupId") })
	private Set<UserGroupEntity> userGroups = new HashSet<UserGroupEntity>();

	@Column(name = "accountCreationDate", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false)
	private Timestamp accountCreationDate;

	public AddressEntity getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(AddressEntity billingAddress) {
		this.billingAddress = billingAddress;
	}

	public AddressEntity getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(AddressEntity shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public Timestamp getAccountCreationDate() {
		return accountCreationDate;
	}

	public void setAccountCreationDate(Timestamp accountCreationDate) {
		this.accountCreationDate = accountCreationDate;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getCustomerID() {
		return customerID;
	}

	public void setCustomerID(Integer customerID) {
		this.customerID = customerID;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getPasswordFormat() {
		return passwordFormat;
	}

	public void setPasswordFormat(Integer passwordFormat) {
		this.passwordFormat = passwordFormat;
	}

	public String getPasswordSalt() {
		return passwordSalt;
	}

	public void setPasswordSalt(String passwordSalt) {
		this.passwordSalt = passwordSalt;
	}

	public String getFirstNameKANA() {
		return firstNameKANA;
	}

	public void setFirstNameKANA(String firstNameKANA) {
		this.firstNameKANA = firstNameKANA;
	}

	public String getLastNameKANA() {
		return lastNameKANA;
	}

	public void setLastNameKANA(String lastNameKANA) {
		this.lastNameKANA = lastNameKANA;
	}

	public String getPasswordQuestion() {
		return passwordQuestion;
	}

	public void setPasswordQuestion(String passwordQuestion) {
		this.passwordQuestion = passwordQuestion;
	}

	public String getPasswordAnswer() {
		return passwordAnswer;
	}

	public void setPasswordAnswer(String passwordAnswer) {
		this.passwordAnswer = passwordAnswer;
	}

	public Date getLastPasswordChangedDate() {
		return lastPasswordChangedDate;
	}

	public void setLastPasswordChangedDate(Date lastPasswordChangedDate) {
		this.lastPasswordChangedDate = lastPasswordChangedDate;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getLegacyCustomerNumber() {
		return legacyCustomerNumber;
	}

	public void setLegacyCustomerNumber(String legacyCustomerNumber) {
		this.legacyCustomerNumber = legacyCustomerNumber;
	}

	public Boolean isSubscribedToNewsLetter() {
		return subscribedToNewsLetter;
	}

	public void setSubscribedToNewsLetter(Boolean subscribedToNewsLetter) {
		this.subscribedToNewsLetter = subscribedToNewsLetter;
	}

	public String getChannelCode() {
		return channelCode;
	}

	public void setChannelCode(String channelCode) {
		this.channelCode = channelCode;
	}

	public Country getRegisteredCountry() {
		return registeredCountry;
	}

	public void setRegisteredCountry(Country registeredCountry) {
		this.registeredCountry = registeredCountry;
	}

	public Country getRecentlyVisitedCountry() {
		return recentlyVisitedCountry;
	}

	public void setRecentlyVisitedCountry(Country recentlyVisitedCountry) {
		this.recentlyVisitedCountry = recentlyVisitedCountry;
	}

	public Boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	public void setAccountNonExpired(Boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	public Boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	public void setAccountNonLocked(Boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	public Boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	public void setCredentialsNonExpired(Boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public Set<UserGroupEntity> getUserGroups() {
		return userGroups;
	}

	public void setUserGroups(Set<UserGroupEntity> userGroups) {
		this.userGroups = userGroups;
	}

}
