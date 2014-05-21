package com.trvajjala.entities.product;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VARIANTTYPE")
public class VariantTypeEntity implements Serializable {

	private static final long serialVersionUID = -2078694241706530544L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer variantId;

	@Column(length = 30, unique = true, nullable = false)
	private String variantCode;

	@Column(length = 100, nullable = false)
	private String variantTitle;

	@Column(length = 255)
	private String description;

	public Integer getVariantId() {
		return variantId;
	}

	public void setVariantId(Integer variantId) {
		this.variantId = variantId;
	}

	public String getVariantCode() {
		return variantCode;
	}

	public void setVariantCode(String variantCode) {
		this.variantCode = variantCode;
	}

	public String getVariantTitle() {
		return variantTitle;
	}

	public void setVariantTitle(String variantTitle) {
		this.variantTitle = variantTitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
