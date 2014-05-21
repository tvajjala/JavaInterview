package com.trvajjala.entities.oltp;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DELIVERYSTATUS")
public class DeliveryStatusEntity implements Serializable {

	private static final long serialVersionUID = -8019437378757040989L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer deliveryStatusId;

	@Column(length = 30, unique = true, nullable = false)
	private String deliveryStatusCode;

	@Column(length = 100)
	private String deliveryStatusTitle;

	@Column(length = 255)
	private String description;

	public Integer getDeliveryStatusId() {
		return deliveryStatusId;
	}

	public void setDeliveryStatusId(Integer deliveryStatusId) {
		this.deliveryStatusId = deliveryStatusId;
	}

	public String getDeliveryStatusCode() {
		return deliveryStatusCode;
	}

	public void setDeliveryStatusCode(String deliveryStatusCode) {
		this.deliveryStatusCode = deliveryStatusCode;
	}

	public String getDeliveryStatusTitle() {
		return deliveryStatusTitle;
	}

	public void setDeliveryStatusTitle(String deliveryStatusTitle) {
		this.deliveryStatusTitle = deliveryStatusTitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
