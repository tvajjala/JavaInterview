package com.trvajjala.entities.oltp;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMERGROUPS")
public class CustomerGroupEntity implements Serializable {

	private static final long serialVersionUID = 760951673564496306L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customerGroupId;

	@Column(length = 30, nullable = false, unique = true)
	private String customerGroupCode;

	@Column(length = 100)
	private String customerGroupTitle;

	@Column(length = 255)
	private String description;

	public Integer getCustomerGroupId() {
		return customerGroupId;
	}

	public void setCustomerGroupId(Integer customerGroupId) {
		this.customerGroupId = customerGroupId;
	}

	public String getCustomerGroupCode() {
		return customerGroupCode;
	}

	public void setCustomerGroupCode(String customerGroupCode) {
		this.customerGroupCode = customerGroupCode;
	}

	public String getCustomerGroupTitle() {
		return customerGroupTitle;
	}

	public void setCustomerGroupTitle(String customerGroupTitle) {
		this.customerGroupTitle = customerGroupTitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
