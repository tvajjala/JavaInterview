package com.trvajjala.entities.product;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "STORES")
public class StoreEntity implements Serializable {

	private static final long serialVersionUID = 4659410358669814151L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer storeId;

	@Column(length = 30, nullable = false, unique = true)
	private String storeCode;

	@Column(length = 100, nullable = false)
	private String storeTitle;

	@Column(length = 255)
	private String description;

	@Column(length = 255)
	private String email;

	@Column(length = 15)
	private String phoneNumber;

	@Column(length = 100)
	private String URL;

	@Column(name = "isActive", nullable = false)
	private Boolean active;

	@Column(name = "isNewStore")
	private Boolean newStore;

	@Column(name = "isLHRAvailable")
	private Boolean LHRAvailable;

	@Column(name = "isBLAAvailable")
	private Boolean BLAAvailable;

	private Date storeOpeningDate;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "STORE_SKUS", joinColumns = { @JoinColumn(name = "storeId") }, inverseJoinColumns = { @JoinColumn(name = "skuId") })
	private Set<SKUEntity> SKUnits = new HashSet<SKUEntity>();

	public Integer getStoreId() {
		return storeId;
	}

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}

	public String getStoreCode() {
		return storeCode;
	}

	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}

	public String getStoreTitle() {
		return storeTitle;
	}

	public void setStoreTitle(String storeTitle) {
		this.storeTitle = storeTitle;
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

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}

	public Boolean isActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Boolean isNewStore() {
		return newStore;
	}

	public void setNewStore(Boolean newStore) {
		this.newStore = newStore;
	}

	public Boolean isLHRAvailable() {
		return LHRAvailable;
	}

	public void setLHRAvailable(Boolean lHRAvailable) {
		LHRAvailable = lHRAvailable;
	}

	public Boolean isBLAAvailable() {
		return BLAAvailable;
	}

	public void setBLAAvailable(Boolean bLAAvailable) {
		BLAAvailable = bLAAvailable;
	}

	public Date getStoreOpeningDate() {
		return storeOpeningDate;
	}

	public void setStoreOpeningDate(Date storeOpeningDate) {
		this.storeOpeningDate = storeOpeningDate;
	}

	public Set<SKUEntity> getSKUnits() {
		return SKUnits;
	}

	public void setSKUnits(Set<SKUEntity> sKUnits) {
		SKUnits = sKUnits;
	}

}
