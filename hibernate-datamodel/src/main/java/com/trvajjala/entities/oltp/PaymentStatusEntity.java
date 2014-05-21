package com.trvajjala.entities.oltp;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PAYMENTSTATUS")
public class PaymentStatusEntity implements Serializable {

	private static final long serialVersionUID = 2611398088325920675L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer paymentStatusId;

	@Column(length = 30, unique = true, nullable = false)
	private String paymentStatusCode;

	@Column(length = 100, nullable = false)
	private String paymentStatusTitle;

	@Column(length = 255)
	private String description;

	public Integer getPaymentStatusId() {
		return paymentStatusId;
	}

	public void setPaymentStatusId(Integer paymentStatusId) {
		this.paymentStatusId = paymentStatusId;
	}

	public String getPaymentStatusCode() {
		return paymentStatusCode;
	}

	public void setPaymentStatusCode(String paymentStatusCode) {
		this.paymentStatusCode = paymentStatusCode;
	}

	public String getPaymentStatusTitle() {
		return paymentStatusTitle;
	}

	public void setPaymentStatusTitle(String paymentStatusTitle) {
		this.paymentStatusTitle = paymentStatusTitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
