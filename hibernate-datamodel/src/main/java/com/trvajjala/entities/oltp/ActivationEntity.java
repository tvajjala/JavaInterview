package com.trvajjala.entities.oltp;

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
@Table(name = "ACTIVATION")
public class ActivationEntity implements Serializable {

	private static final long serialVersionUID = -5164985606004511409L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer activationId;

	@ManyToOne
	@JoinColumn(name = "customerId")
	@ForeignKey(name = "FK_Activation_User")
	private UserEntity customer;

	private Integer productSerialId;

	@ManyToOne
	@JoinColumn(name = "addressId")
	@ForeignKey(name = "FK_Activation_Address")
	private AddressEntity address;

	private Integer noOfAttempts;

	private Boolean questionnaireResponse;

	@Column(length = 30)
	private String activationStatus;

	public Integer getActivationId() {
		return activationId;
	}

	public void setActivationId(Integer activationId) {
		this.activationId = activationId;
	}

	public Integer getProductSerialId() {
		return productSerialId;
	}

	public void setProductSerialId(Integer productSerialId) {
		this.productSerialId = productSerialId;
	}

	public Integer getNoOfAttempts() {
		return noOfAttempts;
	}

	public void setNoOfAttempts(Integer noOfAttempts) {
		this.noOfAttempts = noOfAttempts;
	}

	public Boolean isQuestionnaireResponse() {
		return questionnaireResponse;
	}

	public void setQuestionnaireResponse(Boolean questionnaireResponse) {
		this.questionnaireResponse = questionnaireResponse;
	}

	public String getActivationStatus() {
		return activationStatus;
	}

	public void setActivationStatus(String activationStatus) {
		this.activationStatus = activationStatus;
	}

	public UserEntity getCustomer() {
		return customer;
	}

	public void setCustomer(UserEntity customer) {
		this.customer = customer;
	}

	public AddressEntity getAddress() {
		return address;
	}

	public void setAddress(AddressEntity address) {
		this.address = address;
	}

}
