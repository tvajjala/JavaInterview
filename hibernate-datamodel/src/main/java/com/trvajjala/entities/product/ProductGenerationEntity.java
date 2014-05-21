package com.trvajjala.entities.product;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCTGENERATION")
public class ProductGenerationEntity implements Serializable {

	private static final long serialVersionUID = -3651627809330406746L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productGenerationId;

	@Column(length = 30, nullable = false, unique = true)
	private String productGenerationCode;

	@Column(length = 100, nullable = false)
	private String productGenerationTitle;

	@Column(length = 255)
	private String description;

	public Integer getProductGenerationId() {
		return productGenerationId;
	}

	public void setProductGenerationId(Integer productGenerationId) {
		this.productGenerationId = productGenerationId;
	}

	public String getProductGenerationCode() {
		return productGenerationCode;
	}

	public void setProductGenerationCode(String productGenerationCode) {
		this.productGenerationCode = productGenerationCode;
	}

	public String getProductGenerationTitle() {
		return productGenerationTitle;
	}

	public void setProductGenerationTitle(String productGenerationTitle) {
		this.productGenerationTitle = productGenerationTitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
