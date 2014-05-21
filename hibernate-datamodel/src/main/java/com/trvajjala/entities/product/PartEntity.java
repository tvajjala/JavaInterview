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
@Table(name = "PART")
public class PartEntity implements Serializable {

	private static final long serialVersionUID = -7109903251457709369L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer partId;

	@Column(length = 30, nullable = false, unique = true)
	private String partCode;

	@Column(length = 100, nullable = false)
	private String partTitle;

	@Column(length = 255)
	private String description;

	@Column(length = 100)
	private String manufacturerName;

	@ManyToOne
	@JoinColumn(name = "productLineId", nullable = true)
	@ForeignKey(name = "FK_PART_productLine")
	private ProductLineEntity productLine;

	public Integer getPartId() {
		return partId;
	}

	public void setPartId(Integer partId) {
		this.partId = partId;
	}

	public String getPartCode() {
		return partCode;
	}

	public void setPartCode(String partCode) {
		this.partCode = partCode;
	}

	public String getPartTitle() {
		return partTitle;
	}

	public void setPartTitle(String partTitle) {
		this.partTitle = partTitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getManufacturerName() {
		return manufacturerName;
	}

	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}

	public ProductLineEntity getProductLine() {
		return productLine;
	}

	public void setProductLine(ProductLineEntity productLine) {
		this.productLine = productLine;
	}

}
