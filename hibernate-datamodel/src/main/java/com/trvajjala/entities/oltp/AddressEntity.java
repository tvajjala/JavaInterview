package com.trvajjala.entities.oltp;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.trvajjala.entities.constants.AddressType;
import com.trvajjala.entities.constants.Country;
import com.trvajjala.entities.constants.Region;
import com.trvajjala.entities.constants.StateCode;

@Entity
@Table(name = "ADDRESS")
public class AddressEntity implements Serializable {

	private static final long serialVersionUID = -645126012724719474L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer addressId;

	@Column(length = 100, nullable = false)
	private String firstName;

	@Column(length = 100)
	private String lastName;

	@Column(length = 100)
	private String firstNameKANA;

	@Column(length = 100)
	private String lastNameKANA;

	@Enumerated(EnumType.STRING)
	@Column(length = 10)
	private AddressType addressType;

	@Column(length = 100, nullable = false)
	private String addressLine1;

	@Column(length = 100, nullable = true)
	private String addressLine2;

	@Column(length = 100, nullable = true)
	private String addressLine3;

	@Column(length = 50)
	private String city;

	@Enumerated(EnumType.STRING)
	@Column(length = 4, nullable = true)
	private StateCode stateCode;

	@Enumerated(EnumType.STRING)
	@Column(length = 4, nullable = false)
	private Country country;

	@Column(length = 10)
	private String zip;

	@Column(length = 500)
	private String companyName;

	@Column(length = 50)
	private String apartmentNumber;

	@Column(length = 50)
	private String buildingNumber;

	// made it as mandatory which may useful for reports
	@Enumerated(EnumType.STRING)
	@Column(length = 50, nullable = false)
	private Region region;

	@Column(length = 15)
	private String phoneNumber1;

	@Column(length = 15)
	private String phoneNumber2;

	@Column(length = 15)
	private String mobileNumber;

	@Column(length = 15)
	private String faxNumber;

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
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

	public AddressType getAddressType() {
		return addressType;
	}

	public void setAddressType(AddressType addressType) {
		this.addressType = addressType;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getAddressLine3() {
		return addressLine3;
	}

	public void setAddressLine3(String addressLine3) {
		this.addressLine3 = addressLine3;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public StateCode getStateCode() {
		return stateCode;
	}

	public void setStateCode(StateCode stateCode) {
		this.stateCode = stateCode;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getApartmentNumber() {
		return apartmentNumber;
	}

	public void setApartmentNumber(String apartmentNumber) {
		this.apartmentNumber = apartmentNumber;
	}

	public String getBuildingNumber() {
		return buildingNumber;
	}

	public void setBuildingNumber(String buildingNumber) {
		this.buildingNumber = buildingNumber;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public String getPhoneNumber1() {
		return phoneNumber1;
	}

	public void setPhoneNumber1(String phoneNumber1) {
		this.phoneNumber1 = phoneNumber1;
	}

	public String getPhoneNumber2() {
		return phoneNumber2;
	}

	public void setPhoneNumber2(String phoneNumber2) {
		this.phoneNumber2 = phoneNumber2;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getFaxNumber() {
		return faxNumber;
	}

	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
	}

}
