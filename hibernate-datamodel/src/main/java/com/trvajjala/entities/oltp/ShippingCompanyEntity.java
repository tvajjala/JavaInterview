package com.trvajjala.entities.oltp;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SHIPPINGCOMPANY")
public class ShippingCompanyEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer shippingCompanyId;

	private String shippingCompanyCode;

	private String shippingCompanyName;

	private String description;

	public Integer getShippingCompanyId() {
		return shippingCompanyId;
	}

	public void setShippingCompanyId(Integer shippingCompanyId) {
		this.shippingCompanyId = shippingCompanyId;
	}

	public String getShippingCompanyCode() {
		return shippingCompanyCode;
	}

	public void setShippingCompanyCode(String shippingCompanyCode) {
		this.shippingCompanyCode = shippingCompanyCode;
	}

	public String getShippingCompanyName() {
		return shippingCompanyName;
	}

	public void setShippingCompanyName(String shippingCompanyName) {
		this.shippingCompanyName = shippingCompanyName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
