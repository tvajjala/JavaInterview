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
@Table(name = "PRODUCTLINE")
public class ProductLineEntity implements Serializable {

	private static final long serialVersionUID = -3651627809330406746L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productLineId;

	@Column(length = 30, nullable = false, unique = true)
	private String productLineCode;

	@Column(length = 100, nullable = false)
	private String productLineTitle;

	@Column(length = 255)
	private String description;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "productFamilyId", nullable = false)
	@ForeignKey(name = "FK__productLine_productFamilty")
	private ProductFamilyEntity productFamily;

	public Integer getProductLineId() {
		return productLineId;
	}

	public void setProductLineId(Integer productLineId) {
		this.productLineId = productLineId;
	}

	public String getProductLineCode() {
		return productLineCode;
	}

	public void setProductLineCode(String productLineCode) {
		this.productLineCode = productLineCode;
	}

	public String getProductLineTitle() {
		return productLineTitle;
	}

	public void setProductLineTitle(String productLineTitle) {
		this.productLineTitle = productLineTitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ProductFamilyEntity getProductFamily() {
		return productFamily;
	}

	public void setProductFamily(ProductFamilyEntity productFamily) {
		this.productFamily = productFamily;
	}

}
