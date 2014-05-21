package com.trvajjala.entities.product;

import java.io.Serializable;

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
@Table(name = "PRODUCTFAMILY")
public class ProductFamilyEntity implements Serializable {

	private static final long serialVersionUID = -3651627809330406746L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productFamilyId;

	@Column(length = 30, nullable = false, unique = true)
	private String productFamilyCode;

	@Column(length = 100, nullable = false)
	private String productFamilyTitle;

	@Column(length = 255)
	private String description;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "productGenerationId", nullable = false)
	@ForeignKey(name = "FK_productFamilty_productGeneration")
	private ProductGenerationEntity productGeneration;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ProductGenerationEntity getProductGeneration() {
		return productGeneration;
	}

	public void setProductGeneration(ProductGenerationEntity productGeneration) {
		this.productGeneration = productGeneration;
	}

	public Integer getProductFamilyId() {
		return productFamilyId;
	}

	public void setProductFamilyId(Integer productFamilyId) {
		this.productFamilyId = productFamilyId;
	}

	public String getProductFamilyCode() {
		return productFamilyCode;
	}

	public void setProductFamilyCode(String productFamilyCode) {
		this.productFamilyCode = productFamilyCode;
	}

	public String getProductFamilyTitle() {
		return productFamilyTitle;
	}

	public void setProductFamilyTitle(String productFamilyTitle) {
		this.productFamilyTitle = productFamilyTitle;
	}

}
