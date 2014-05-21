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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.ForeignKey;

import com.trvajjala.entities.constants.Country;

/**
 * 
 * @author trvajjala this Entity contains Localized Title based on Country
 */
@Entity
@Table(name = "LOCALIZED_SKU")
public class LocalizedSKUEntity implements Serializable {

	private static final long serialVersionUID = -2078694241706530544L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long localizedSKUId;

	@ManyToOne
	@JoinColumn(name = "skuId")
	@ForeignKey(name = "FK_LocalizedSKU_SKU")
	private SKUEntity sku;

	@Enumerated(EnumType.STRING)
	@Column(length=10)
	private Country country;

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@Column(length = 200)
	private String title;

	@Lob
	private String description;

	public Long getLocalizedSKUId() {
		return localizedSKUId;
	}

	public void setLocalizedSKUId(Long localizedSKUId) {
		this.localizedSKUId = localizedSKUId;
	}

	public SKUEntity getSku() {
		return sku;
	}

	public void setSku(SKUEntity sku) {
		this.sku = sku;
	}



	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
