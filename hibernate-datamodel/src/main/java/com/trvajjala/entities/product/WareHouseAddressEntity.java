package com.trvajjala.entities.product;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.trvajjala.entities.constants.Country;
import com.trvajjala.entities.constants.Region;
import com.trvajjala.entities.constants.StateCode;

@Entity
@Table(name = "WAREHOUSEADDRESS")
public class WareHouseAddressEntity implements Serializable {

	private static final long serialVersionUID = -645126012724719474L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer warehouseAddressId;

	@Column(length = 100, nullable = false)
	private String addressLine1;

	@Column(length = 100, nullable = true)
	private String addressLine2;

	@Column(length = 100, nullable = true)
	private String addressLine3;

	@Column(length = 50)
	private String city;

	@Enumerated(EnumType.STRING)
	@Column(length = 10, nullable = true)
	private StateCode stateCode;

	@Enumerated(EnumType.STRING)
	@Column(length = 10, nullable = false)
	private Country country;

	@Column(length = 10)
	private String zip;

	// made it as mandatory which may useful for reports
	@Enumerated(EnumType.STRING)
	@Column(length = 50, nullable = true)
	private Region region;

	@Column(length = 15)
	private String phoneNumber;

	@Column(length = 15)
	private String mobileNumber;

	@Column(length = 15)
	private String faxNumber;

	public Integer getWarehouseAddressId() {
		return warehouseAddressId;
	}

	public void setWarehouseAddressId(Integer warehouseAddressId) {
		this.warehouseAddressId = warehouseAddressId;
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

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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
