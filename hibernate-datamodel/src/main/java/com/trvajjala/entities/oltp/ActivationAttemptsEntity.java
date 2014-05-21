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
@Table(name = "ACTIVATIONATTEMPTS")
public class ActivationAttemptsEntity implements Serializable {

	private static final long serialVersionUID = 8225701862845166685L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer activationAttemptsId;

	@Column(length = 30)
	private String activationAttemptStatus;

	private Integer activationAttemptNumber;

	@ManyToOne
	@JoinColumn(name = "bodyLocationId")
	@ForeignKey(name = "FK_ActivationAttempts_BodyLocation")
	private BodyLocationEntity bodyLocation;

	@Column(length = 50)
	private String firstSkinTone;

	@Column(length = 50)
	private String secondSkinTone;

	public Integer getActivationAttemptsId() {
		return activationAttemptsId;
	}

	public void setActivationAttemptsId(Integer activationAttemptsId) {
		this.activationAttemptsId = activationAttemptsId;
	}

	public String getActivationAttemptStatus() {
		return activationAttemptStatus;
	}

	public void setActivationAttemptStatus(String activationAttemptStatus) {
		this.activationAttemptStatus = activationAttemptStatus;
	}

	public Integer getActivationAttemptNumber() {
		return activationAttemptNumber;
	}

	public void setActivationAttemptNumber(Integer activationAttemptNumber) {
		this.activationAttemptNumber = activationAttemptNumber;
	}

	public BodyLocationEntity getBodyLocation() {
		return bodyLocation;
	}

	public void setBodyLocation(BodyLocationEntity bodyLocation) {
		this.bodyLocation = bodyLocation;
	}

	public String getFirstSkinTone() {
		return firstSkinTone;
	}

	public void setFirstSkinTone(String firstSkinTone) {
		this.firstSkinTone = firstSkinTone;
	}

	public String getSecondSkinTone() {
		return secondSkinTone;
	}

	public void setSecondSkinTone(String secondSkinTone) {
		this.secondSkinTone = secondSkinTone;
	}

}
