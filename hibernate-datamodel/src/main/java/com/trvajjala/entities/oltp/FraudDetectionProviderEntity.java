package com.trvajjala.entities.oltp;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FRAUDDETECTIONPROVIDER")
public class FraudDetectionProviderEntity implements Serializable {

	private static final long serialVersionUID = -2078694241706530544L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer fraudDetectionProviderId;

	@Column(length = 150, unique = true)
	private String providerTitle;

	@Column(length = 150, nullable = true)
	private String URL;

	@Column(length = 30, unique = true, nullable = false)
	private String providerCode;

	@Column(length = 255)
	private String description;

	public Integer getFraudDetectionProviderId() {
		return fraudDetectionProviderId;
	}

	public void setFraudDetectionProviderId(Integer fraudDetectionProviderId) {
		this.fraudDetectionProviderId = fraudDetectionProviderId;
	}

	public String getProviderTitle() {
		return providerTitle;
	}

	public void setProviderTitle(String providerTitle) {
		this.providerTitle = providerTitle;
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}

	public String getProviderCode() {
		return providerCode;
	}

	public void setProviderCode(String providerCode) {
		this.providerCode = providerCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
