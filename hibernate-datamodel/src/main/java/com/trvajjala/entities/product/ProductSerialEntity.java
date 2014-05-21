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

@Entity
@Table(name = "PRODUCTSERIAL")
public class ProductSerialEntity implements Serializable {

	private static final long serialVersionUID = 4477157813403802583L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productSerialId;

	@Column(length = 100, nullable = false)
	private String productSerialNumber;

	@JoinColumn(name = "skuId")
	@ForeignKey(name = "FK__ProductSerial_SKU")
	private SKUEntity sku;

	@Column(length = 100, nullable = false)
	private String deviceType;

	@Enumerated(EnumType.STRING)
	@Column(length = 10)
	private Country country;

	@ManyToOne
	@JoinColumn(name = "partId")
	@ForeignKey(name = "FK__ProductSerial_Part")
	private PartEntity part;

	private Boolean registeredForWarrenty;

	private Boolean registeredForActivation;

	@Column(length = 100)
	private String productActivationCode;

	private Date productShipDate;

	public Integer getProductSerialId() {
		return productSerialId;
	}

	public void setProductSerialId(Integer productSerialId) {
		this.productSerialId = productSerialId;
	}

	public String getProductSerialNumber() {
		return productSerialNumber;
	}

	public void setProductSerialNumber(String productSerialNumber) {
		this.productSerialNumber = productSerialNumber;
	}

	public SKUEntity getSku() {
		return sku;
	}

	public void setSku(SKUEntity sku) {
		this.sku = sku;
	}

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public PartEntity getPart() {
		return part;
	}

	public void setPart(PartEntity part) {
		this.part = part;
	}

	public Boolean isRegisteredForWarrenty() {
		return registeredForWarrenty;
	}

	public void setRegisteredForWarrenty(Boolean registeredForWarrenty) {
		this.registeredForWarrenty = registeredForWarrenty;
	}

	public Boolean isRegisteredForActivation() {
		return registeredForActivation;
	}

	public void setRegisteredForActivation(Boolean registeredForActivation) {
		this.registeredForActivation = registeredForActivation;
	}

	public String getProductActivationCode() {
		return productActivationCode;
	}

	public void setProductActivationCode(String productActivationCode) {
		this.productActivationCode = productActivationCode;
	}

	public Date getProductShipDate() {
		return productShipDate;
	}

	public void setProductShipDate(Date productShipDate) {
		this.productShipDate = productShipDate;
	}

}
