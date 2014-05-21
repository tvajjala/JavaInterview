package com.trvajjala.entities.product;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name = "WAREHOUSE")
public class WareHouseEntity implements Serializable {

	private static final long serialVersionUID = 1755535314175651884L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer warehouseId;

	@Column(length = 30, unique = true, nullable = false)
	private String warehouseCode;

	@Column(length = 100, nullable = false)
	private String warehouseTitle;

	@Column(length = 255)
	private String description;

	@Column(length = 255)
	private String email;

	@Column(length = 15)
	private String phoneNumber;

	@Column(name = "isActive", nullable = false)
	private Boolean active;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "locationId", nullable = false)
	@ForeignKey(name="FK_WareHouse_Location")
	private LocationEntity location;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "WAREHOUSE_SKUS", joinColumns = { @JoinColumn(name = "warehouseId") }, inverseJoinColumns = { @JoinColumn(name = "skuId") })
	private Set<SKUEntity> SKUnits = new HashSet<SKUEntity>();

	public Integer getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(Integer warehouseId) {
		this.warehouseId = warehouseId;
	}

	public String getWarehouseCode() {
		return warehouseCode;
	}

	public void setWarehouseCode(String warehouseCode) {
		this.warehouseCode = warehouseCode;
	}

	public String getWarehouseTitle() {
		return warehouseTitle;
	}

	public void setWarehouseTitle(String warehouseTitle) {
		this.warehouseTitle = warehouseTitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public Boolean isActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public LocationEntity getLocation() {
		return location;
	}

	public void setLocation(LocationEntity location) {
		this.location = location;
	}

	public Set<SKUEntity> getSKUnits() {
		return SKUnits;
	}

	public void setSKUnits(Set<SKUEntity> sKUnits) {
		SKUnits = sKUnits;
	}

}
