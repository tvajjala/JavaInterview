package com.trvajjala.entities.product;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name = "CATALOG_SKU")
public class ProductEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productId;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "catalogId", nullable = false)
	@ForeignKey(name = "FK_catalogSKU_Catalog")
	private CatalogEntity catalog;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "skuId", nullable = false)
	@ForeignKey(name = "FK_CatalogSKU_SKU")
	private SKUEntity sku;

	private Date onlineDate;

	private Date offlineDate;

	private Integer minOrderQuantity;

	private Integer maxOrderQuantity;

	private Boolean availableForCanada;

	private Integer stockLevels;

	@Column(length = 100)
	private String productPriorityDisplay;

	private Integer numberOfContentUnits;

	private Boolean active;

	private Boolean approved;

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public CatalogEntity getCatalog() {
		return catalog;
	}

	public void setCatalog(CatalogEntity catalog) {
		this.catalog = catalog;
	}

	public SKUEntity getSku() {
		return sku;
	}

	public void setSku(SKUEntity sku) {
		this.sku = sku;
	}

	public Date getOnlineDate() {
		return onlineDate;
	}

	public void setOnlineDate(Date onlineDate) {
		this.onlineDate = onlineDate;
	}

	public Date getOfflineDate() {
		return offlineDate;
	}

	public void setOfflineDate(Date offlineDate) {
		this.offlineDate = offlineDate;
	}

	public Integer getMinOrderQuantity() {
		return minOrderQuantity;
	}

	public void setMinOrderQuantity(Integer minOrderQuantity) {
		this.minOrderQuantity = minOrderQuantity;
	}

	public Integer getMaxOrderQuantity() {
		return maxOrderQuantity;
	}

	public void setMaxOrderQuantity(Integer maxOrderQuantity) {
		this.maxOrderQuantity = maxOrderQuantity;
	}

	public Boolean isAvailableForCanada() {
		return availableForCanada;
	}

	public void setAvailableForCanada(Boolean availableForCanada) {
		this.availableForCanada = availableForCanada;
	}

	public Integer getStockLevels() {
		return stockLevels;
	}

	public void setStockLevels(Integer stockLevels) {
		this.stockLevels = stockLevels;
	}

	public String getProductPriorityDisplay() {
		return productPriorityDisplay;
	}

	public void setProductPriorityDisplay(String productPriorityDisplay) {
		this.productPriorityDisplay = productPriorityDisplay;
	}

	public Integer getNumberOfContentUnits() {
		return numberOfContentUnits;
	}

	public void setNumberOfContentUnits(Integer numberOfContentUnits) {
		this.numberOfContentUnits = numberOfContentUnits;
	}

	public Boolean isActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Boolean isApproved() {
		return approved;
	}

	public void setApproved(Boolean approved) {
		this.approved = approved;
	}

}
