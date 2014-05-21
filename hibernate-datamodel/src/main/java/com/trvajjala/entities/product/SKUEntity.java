package com.trvajjala.entities.product;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;

import com.trvajjala.entities.constants.MeasurementUnit;

@Entity
@Table(name = "SKU")
public class SKUEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer skuId;

	private String skuCode;

	private String skuTitle;

	private String hybrisSKUCode;

	private String description;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "productLineId", nullable = false)
	@ForeignKey(name = "FK_SKU_productLine")
	private ProductLineEntity productLine;

	@Enumerated(EnumType.STRING)
	@Column(length = 10, nullable = false)
	private MeasurementUnit measurementUnit;

	@Lob
	private String additionalText;

	@Column(length = 100)
	private String EAN;

	@Column(length = 50)
	private String manufacturerName;

	@Column(nullable = false)
	private Boolean primaryProduct;

	@Column(nullable = false)
	private Boolean easyPayProduct;

	@ManyToOne
	@JoinColumn(name = "variantTypeId", nullable = false)
	@ForeignKey(name = "FK_SKU_VariantType")
	private VariantTypeEntity variantType;

	@ManyToOne
	@JoinColumn(name = "colorId", nullable = false)
	@ForeignKey(name = "FK_SKU_Color")
	private ColorEntity color;

	@Column(precision = 18, scale = 2)
	private Double weight;

	private Boolean device;

	private Boolean replenishmentProduct;

	private Boolean warrantyRequired;

	private Boolean activationRequired;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "SKU_PARTS", joinColumns = { @JoinColumn(name = "skuId") }, inverseJoinColumns = { @JoinColumn(name = "partId") })
	private Set<PartEntity> parts = new HashSet<PartEntity>();

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "SKU_ASSETS", joinColumns = { @JoinColumn(name = "skuId") }, inverseJoinColumns = { @JoinColumn(name = "assetId") })
	private Set<SKUAssetEntity> assets = new HashSet<SKUAssetEntity>();

	public Integer getSkuId() {
		return skuId;
	}

	public void setSkuId(Integer skuId) {
		this.skuId = skuId;
	}

	public String getSkuCode() {
		return skuCode;
	}

	public void setSkuCode(String skuCode) {
		this.skuCode = skuCode;
	}

	public String getSkuTitle() {
		return skuTitle;
	}

	public void setSkuTitle(String skuTitle) {
		this.skuTitle = skuTitle;
	}

	public String getHybrisSKUCode() {
		return hybrisSKUCode;
	}

	public void setHybrisSKUCode(String hybrisSKUCode) {
		this.hybrisSKUCode = hybrisSKUCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ProductLineEntity getProductLine() {
		return productLine;
	}

	public void setProductLine(ProductLineEntity productLine) {
		this.productLine = productLine;
	}

	public MeasurementUnit getMeasurementUnit() {
		return measurementUnit;
	}

	public void setMeasurementUnit(MeasurementUnit measurementUnit) {
		this.measurementUnit = measurementUnit;
	}

	public String getAdditionalText() {
		return additionalText;
	}

	public void setAdditionalText(String additionalText) {
		this.additionalText = additionalText;
	}

	public String getEAN() {
		return EAN;
	}

	public void setEAN(String eAN) {
		EAN = eAN;
	}

	public String getManufacturerName() {
		return manufacturerName;
	}

	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}

	public Boolean isPrimaryProduct() {
		return primaryProduct;
	}

	public void setPrimaryProduct(Boolean primaryProduct) {
		this.primaryProduct = primaryProduct;
	}

	public Boolean isEasyPayProduct() {
		return easyPayProduct;
	}

	public void setEasyPayProduct(Boolean easyPayProduct) {
		this.easyPayProduct = easyPayProduct;
	}

	public VariantTypeEntity getVariantType() {
		return variantType;
	}

	public void setVariantType(VariantTypeEntity variantType) {
		this.variantType = variantType;
	}

	public ColorEntity getColor() {
		return color;
	}

	public void setColor(ColorEntity color) {
		this.color = color;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Boolean isDevice() {
		return device;
	}

	public void setDevice(Boolean device) {
		this.device = device;
	}

	public Boolean isReplenishmentProduct() {
		return replenishmentProduct;
	}

	public void setReplenishmentProduct(Boolean replenishmentProduct) {
		this.replenishmentProduct = replenishmentProduct;
	}

	public Boolean isWarrantyRequired() {
		return warrantyRequired;
	}

	public void setWarrantyRequired(Boolean warrantyRequired) {
		this.warrantyRequired = warrantyRequired;
	}

	public Boolean isActivationRequired() {
		return activationRequired;
	}

	public void setActivationRequired(Boolean activationRequired) {
		this.activationRequired = activationRequired;
	}

	public Set<PartEntity> getParts() {
		return parts;
	}

	public void setParts(Set<PartEntity> parts) {
		this.parts = parts;
	}

	public Set<SKUAssetEntity> getAssets() {
		return assets;
	}

	public void setAssets(Set<SKUAssetEntity> assets) {
		this.assets = assets;
	}

}
