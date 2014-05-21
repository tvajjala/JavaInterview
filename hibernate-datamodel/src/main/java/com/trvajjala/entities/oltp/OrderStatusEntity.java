package com.trvajjala.entities.oltp;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ORDERSTATUS")
public class OrderStatusEntity implements Serializable {

	private static final long serialVersionUID = -8019437378757040989L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderStatusId;

	@Column(length = 30, nullable = false, unique = true)
	private String orderStatusCode;

	@Column(length = 100, nullable = false)
	private String orderStatusTitle;

	@Column(length = 255)
	private String description;

	public Integer getOrderStatusId() {
		return orderStatusId;
	}

	public void setOrderStatusId(Integer orderStatusId) {
		this.orderStatusId = orderStatusId;
	}

	public String getOrderStatusCode() {
		return orderStatusCode;
	}

	public void setOrderStatusCode(String orderStatusCode) {
		this.orderStatusCode = orderStatusCode;
	}

	public String getOrderStatusTitle() {
		return orderStatusTitle;
	}

	public void setOrderStatusTitle(String orderStatusTitle) {
		this.orderStatusTitle = orderStatusTitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
