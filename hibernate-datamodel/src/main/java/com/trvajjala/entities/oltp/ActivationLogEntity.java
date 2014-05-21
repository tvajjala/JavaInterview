package com.trvajjala.entities.oltp;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name = "ACTIVATIONLOG")
public class ActivationLogEntity implements Serializable {

	private static final long serialVersionUID = 8225701862845166685L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer activationLogId;

	private String activationStatus;

	@ManyToOne
	@JoinColumn(name = "customerId")
	@ForeignKey(name = "FK_ActivationLog_User")
	private UserEntity customer;

	private Integer noOfAttempts;

	private Integer productSerialId;

	@ManyToOne
	@JoinColumn(name = "activationAttemptsId")
	@ForeignKey(name = "FK_ActivationLog_ActivationAttempts")
	private ActivationAttemptsEntity activationAttempts;

	public Integer getActivationLogId() {
		return activationLogId;
	}

	public void setActivationLogId(Integer activationLogId) {
		this.activationLogId = activationLogId;
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

	public Integer getNoOfAttempts() {
		return noOfAttempts;
	}

	public void setNoOfAttempts(Integer noOfAttempts) {
		this.noOfAttempts = noOfAttempts;
	}

	public Integer getProductSerialId() {
		return productSerialId;
	}

	public void setProductSerialId(Integer productSerialId) {
		this.productSerialId = productSerialId;
	}

	public ActivationAttemptsEntity getActivationAttempts() {
		return activationAttempts;
	}

	public void setActivationAttempts(
			ActivationAttemptsEntity activationAttempts) {
		this.activationAttempts = activationAttempts;
	}

}
