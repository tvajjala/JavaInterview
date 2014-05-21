package com.trvajjala.entities.product;

import java.io.Serializable;

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
@Table(name = "HIST_CATALOG_SKU")
public class HistCatalogSkuEntity implements Serializable {

	private static final long serialVersionUID = -645126012724719474L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer histCatalogSkuId;

	@ManyToOne
	@JoinColumn(name = "productId", nullable = false)
	@ForeignKey(name = "FK_HistCatalogSKU_CatalogSKU")
	private ProductEntity product;

	@ManyToOne
	@JoinColumn(name = "catalogId", nullable = false)
	@ForeignKey(name = "FK_HistCatalogSKU_Catalog")
	private CatalogEntity catalog;

	@ManyToOne
	@JoinColumn(name = "skuId", nullable = false)
	@ForeignKey(name = "FK_HistCatalogSKU_SKU")
	SKUEntity sku;

	@Column(length = 100)
	private String skuDisplayTitle;

	@Column(length = 255)
	private String skuDescription;

	@Column(precision = 19, scale = 4)
	private Double price;

	private Boolean active;

	private Boolean approved;

	public Integer getHistCatalogSkuId() {
		return histCatalogSkuId;
	}

	public void setHistCatalogSkuId(Integer histCatalogSkuId) {
		this.histCatalogSkuId = histCatalogSkuId;
	}

	public ProductEntity getProduct() {
		return product;
	}

	public void setProduct(ProductEntity product) {
		this.product = product;
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

	public String getSkuDisplayTitle() {
		return skuDisplayTitle;
	}

	public void setSkuDisplayTitle(String skuDisplayTitle) {
		this.skuDisplayTitle = skuDisplayTitle;
	}

	public String getSkuDescription() {
		return skuDescription;
	}

	public void setSkuDescription(String skuDescription) {
		this.skuDescription = skuDescription;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
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
