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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;

import com.trvajjala.entities.constants.MeasurementUnit;

@Entity
@Table(name = "SHIPPINGSERVICECOST")
public class ShippingServiceCostEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer shippingServiceCostId;

	@ManyToOne
	@JoinColumn(name = "shippingCompanyServiceId")
	@ForeignKey(name = "FK_ShippingServiceCost_ShippingCompanyService")
	private ShippingCompanyServiceEntity shippingCompanyService;

	@Column(precision = 19, scale = 4)
	private Double price;

	@Column(precision = 18, scale = 2)
	private Double weight;

	@Enumerated(EnumType.STRING)
	@Column(length = 10)
	private MeasurementUnit measurementUnit;

	public Integer getShippingServiceCostId() {
		return shippingServiceCostId;
	}

	public void setShippingServiceCostId(Integer shippingServiceCostId) {
		this.shippingServiceCostId = shippingServiceCostId;
	}

	public ShippingCompanyServiceEntity getShippingCompanyService() {
		return shippingCompanyService;
	}

	public void setShippingCompanyService(
			ShippingCompanyServiceEntity shippingCompanyService) {
		this.shippingCompanyService = shippingCompanyService;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public MeasurementUnit getMeasurementUnit() {
		return measurementUnit;
	}

	public void setMeasurementUnit(MeasurementUnit measurementUnit) {
		this.measurementUnit = measurementUnit;
	}

}
