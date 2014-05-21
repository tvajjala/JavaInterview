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
@Table(name = "FRAUDDETECTIONINFO")
public class FraudDetectionInfoEntity implements Serializable {

	private static final long serialVersionUID = -2078694241706530544L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer fraudDetectionInfoId;

	@ManyToOne
	@JoinColumn(name = "orderId")
	@ForeignKey(name="FK_FraudDetectionInfo_Order")
	private OrderEntity order;

	@ManyToOne
	@JoinColumn(name = "fraudDetectionProviderId", nullable = false)
	@ForeignKey(name="FK_FraudDetectionInfo_FraudDetectionProvider")
	private FraudDetectionProviderEntity fraudDetectionProvider;

	@Column(length = 100)
	private String auto;

	@Column(length = 100)
	private String score;

	@Column(length = 100)
	private String response;

	@Column(length = 100)
	private String responseReason;

	@Column(length = 100)
	private String responseStatus;

	public Integer getFraudDetectionInfoId() {
		return fraudDetectionInfoId;
	}

	public void setFraudDetectionInfoId(Integer fraudDetectionInfoId) {
		this.fraudDetectionInfoId = fraudDetectionInfoId;
	}

	public OrderEntity getOrder() {
		return order;
	}

	public void setOrder(OrderEntity order) {
		this.order = order;
	}

	public FraudDetectionProviderEntity getFraudDetectionProvider() {
		return fraudDetectionProvider;
	}

	public void setFraudDetectionProvider(
			FraudDetectionProviderEntity fraudDetectionProvider) {
		this.fraudDetectionProvider = fraudDetectionProvider;
	}

	public String getAuto() {
		return auto;
	}

	public void setAuto(String auto) {
		this.auto = auto;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public String getResponseReason() {
		return responseReason;
	}

	public void setResponseReason(String responseReason) {
		this.responseReason = responseReason;
	}

	public String getResponseStatus() {
		return responseStatus;
	}

	public void setResponseStatus(String responseStatus) {
		this.responseStatus = responseStatus;
	}

}
