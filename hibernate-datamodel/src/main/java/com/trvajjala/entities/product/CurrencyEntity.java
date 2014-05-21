package com.trvajjala.entities.product;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.trvajjala.entities.constants.Country;

@Entity
@Table(name = "CURRENCY")
public class CurrencyEntity implements Serializable {

	private static final long serialVersionUID = -9134543896343358837L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer currencyId;

	@Column(length = 30, nullable = false)
	private String currencyISOCode;

	@Column(length = 5, nullable = false)
	private String currencySymbol;

	@Enumerated(EnumType.STRING)
	@Column(length = 10, nullable = false)
	private Country country;

	public Integer getCurrencyId() {
		return currencyId;
	}

	public void setCurrencyId(Integer currencyId) {
		this.currencyId = currencyId;
	}

	public String getCurrencyISOCode() {
		return currencyISOCode;
	}

	public void setCurrencyISOCode(String currencyISOCode) {
		this.currencyISOCode = currencyISOCode;
	}

	public String getCurrencySymbol() {
		return currencySymbol;
	}

	public void setCurrencySymbol(String currencySymbol) {
		this.currencySymbol = currencySymbol;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

}
