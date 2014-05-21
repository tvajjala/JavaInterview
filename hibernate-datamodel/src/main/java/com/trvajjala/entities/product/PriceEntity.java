package com.trvajjala.entities.product;

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
@Table(name = "PRICES")
public class PriceEntity implements Serializable {

	private static final long serialVersionUID = -9134543896343358837L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer priceId;

	@ManyToOne
	@JoinColumn(name = "currencyId", nullable = false)
	@ForeignKey(name = "FK_Price_Currency")
	private CurrencyEntity currency;

	@ManyToOne
	@JoinColumn(name = "productId", nullable = false)
	@ForeignKey(name = "FK_Price_Product")
	private ProductEntity product;

	@Column(precision = 19, scale = 4)
	private Double displayPrice;

	@Column(precision = 19, scale = 4)
	private Double originalPrice;

	@Column(precision = 19, scale = 4)
	private Double discountPrice;

	@Column(precision = 19, scale = 4)
	private Double seasonalPrice;

	@Column(precision = 19, scale = 4)
	private Double specialPrice;

	@Column(precision = 19, scale = 4)
	private Double downPayment;

	@Column(precision = 19, scale = 4)
	private Double installmentValue;

	private Integer installments;

	private Boolean active;

	public Integer getPriceId() {
		return priceId;
	}

	public void setPriceId(Integer priceId) {
		this.priceId = priceId;
	}

	public CurrencyEntity getCurrency() {
		return currency;
	}

	public void setCurrency(CurrencyEntity currency) {
		this.currency = currency;
	}

	public ProductEntity getProduct() {
		return product;
	}

	public void setProduct(ProductEntity product) {
		this.product = product;
	}

	public Double getDisplayPrice() {
		return displayPrice;
	}

	public void setDisplayPrice(Double displayPrice) {
		this.displayPrice = displayPrice;
	}

	public Double getOriginalPrice() {
		return originalPrice;
	}

	public void setOriginalPrice(Double originalPrice) {
		this.originalPrice = originalPrice;
	}

	public Double getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(Double discountPrice) {
		this.discountPrice = discountPrice;
	}

	public Double getSeasonalPrice() {
		return seasonalPrice;
	}

	public void setSeasonalPrice(Double seasonalPrice) {
		this.seasonalPrice = seasonalPrice;
	}

	public Double getSpecialPrice() {
		return specialPrice;
	}

	public void setSpecialPrice(Double specialPrice) {
		this.specialPrice = specialPrice;
	}

	public Double getDownPayment() {
		return downPayment;
	}

	public void setDownPayment(Double downPayment) {
		this.downPayment = downPayment;
	}

	public Double getInstallmentValue() {
		return installmentValue;
	}

	public void setInstallmentValue(Double installmentValue) {
		this.installmentValue = installmentValue;
	}

	public Integer getInstallments() {
		return installments;
	}

	public void setInstallments(Integer installments) {
		this.installments = installments;
	}

	public Boolean isActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

}
