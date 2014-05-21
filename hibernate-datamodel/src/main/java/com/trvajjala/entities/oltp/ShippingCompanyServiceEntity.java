package com.trvajjala.entities.oltp;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;

import com.trvajjala.entities.constants.Country;

@Entity
@Table(name = "SHIPPINGCOMPANYSERVICE")
public class ShippingCompanyServiceEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer shippingServiceId;

	@ManyToOne
	@JoinColumn(name = "shippingCompanyId")
	@ForeignKey(name = "FK_ShippingCompanyService_ShippingCompany")
	private ShippingCompanyEntity shippingCompany;

	@Lob
	private String serviceDescription;

	@Enumerated(EnumType.STRING)
	@Column(length = 10)
	private Country country;

	private String channel;

	public Integer getShippingServiceId() {
		return shippingServiceId;
	}

	public void setShippingServiceId(Integer shippingServiceId) {
		this.shippingServiceId = shippingServiceId;
	}

	public ShippingCompanyEntity getShippingCompany() {
		return shippingCompany;
	}

	public void setShippingCompany(ShippingCompanyEntity shippingCompany) {
		this.shippingCompany = shippingCompany;
	}

	public String getServiceDescription() {
		return serviceDescription;
	}

	public void setServiceDescription(String serviceDescription) {
		this.serviceDescription = serviceDescription;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

}
