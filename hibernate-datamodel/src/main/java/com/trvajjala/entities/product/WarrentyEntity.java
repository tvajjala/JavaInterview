package com.trvajjala.entities.product;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;

import com.trvajjala.entities.constants.Country;
import com.trvajjala.entities.constants.Gender;
import com.trvajjala.entities.constants.Region;
import com.trvajjala.entities.constants.StateCode;

@Entity
@Table(name = "WARRENTY")
public class WarrentyEntity implements Serializable {

	private static final long serialVersionUID = -7799459627654465599L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer warrentyId;

	@Column(length = 100)
	private String productSerialNumber;

	@Column(length = 60, nullable = false)
	private String firstName;

	@Column(length = 60)
	private String lastName;

	@Column(length = 255)
	private String emailAddress;

	@Enumerated(EnumType.STRING)
	@Column(length = 10)
	private Country country;

	@Column(length = 100)
	private String addressLine1;

	@Column(length = 100)
	private String addressLine2;

	@Enumerated(EnumType.STRING)
	@Column(length = 30)
	private StateCode state;

	@Column(length = 30)
	private String city;

	@Enumerated(EnumType.STRING)
	@Column(length = 30)
	private Region region;

	@Column(length = 10)
	private String zipCode;

	@Column(length = 15)
	private String phoneNumber;

	@ManyToOne
	@JoinColumn(name = "deviceTypeId", nullable = false)
	@ForeignKey(name="FK_Warrenty_ActivationDeviceType")
	private ActivationDeviceTypeEntity deviceType;

	@ManyToOne
	@JoinColumn(name = "ageGroupId")
	@ForeignKey(name= "FK_Warrenty_AgeGroup")
	private AgeGroupEntity ageGroup;

	@Enumerated(EnumType.STRING)
	@Column(length = 10)
	private Gender gender;

	private Date purchaseDate;

	private Date warrentyRegistrationDate;

	@ManyToOne
	@JoinColumn(name = "hearAboutId")
	@ForeignKey(name= "FK_Warrenty_HearAbout")
	private HearAboutEntity hearAbout;

	@Column(length = 100)
	private String shopName;

	@ManyToOne
	@JoinColumn(name = "newAgeGroupId")
	@ForeignKey(name= "FK_Warrenty_newAgeGroup")
	private AgeGroupEntity newAgeGroup;

	public Integer getWarrentyId() {
		return warrentyId;
	}

	public void setWarrentyId(Integer warrentyId) {
		this.warrentyId = warrentyId;
	}

	public String getProductSerialNumber() {
		return productSerialNumber;
	}

	public void setProductSerialNumber(String productSerialNumber) {
		this.productSerialNumber = productSerialNumber;
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

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
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

	public StateCode getState() {
		return state;
	}

	public void setState(StateCode state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public ActivationDeviceTypeEntity getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(ActivationDeviceTypeEntity deviceType) {
		this.deviceType = deviceType;
	}

	public AgeGroupEntity getAgeGroup() {
		return ageGroup;
	}

	public void setAgeGroup(AgeGroupEntity ageGroup) {
		this.ageGroup = ageGroup;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public Date getWarrentyRegistrationDate() {
		return warrentyRegistrationDate;
	}

	public void setWarrentyRegistrationDate(Date warrentyRegistrationDate) {
		this.warrentyRegistrationDate = warrentyRegistrationDate;
	}

	public HearAboutEntity getHearAbout() {
		return hearAbout;
	}

	public void setHearAbout(HearAboutEntity hearAbout) {
		this.hearAbout = hearAbout;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public AgeGroupEntity getNewAgeGroup() {
		return newAgeGroup;
	}

	public void setNewAgeGroup(AgeGroupEntity newAgeGroup) {
		this.newAgeGroup = newAgeGroup;
	}

}
