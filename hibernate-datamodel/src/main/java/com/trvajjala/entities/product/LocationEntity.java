package com.trvajjala.entities.product;

import java.io.Serializable;

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
import com.trvajjala.entities.constants.Region;

@Entity
@Table(name = "LOCATION")
public class LocationEntity implements Serializable {

	private static final long serialVersionUID = 2719193883089631408L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer locationId;

	@Column(length=30,nullable=false,unique=true)
	private String locationCode;

	@Column(length=100)
	private String locationTitle;

	@Column(length=255)
	private String description;

	@ManyToOne
	@JoinColumn(name = "addressId", nullable = false)
	@ForeignKey(name = "FK_Location_WareHouseAddress")
	private WareHouseAddressEntity address;

	@Enumerated(EnumType.STRING)
	@Column(length = 10)
	private Country country;

	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private Region region;

	private Double latitude;

	private Double longitude;

	public Integer getLocationId() {
		return locationId;
	}

	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}

	public String getLocationCode() {
		return locationCode;
	}

	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}

	public String getLocationTitle() {
		return locationTitle;
	}

	public void setLocationTitle(String locationTitle) {
		this.locationTitle = locationTitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public WareHouseAddressEntity getAddress() {
		return address;
	}

	public void setAddress(WareHouseAddressEntity address) {
		this.address = address;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

}
