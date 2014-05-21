package com.trvajjala.entities.oltp;

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
import com.trvajjala.entities.constants.StateCode;
import com.trvajjala.entities.constants.TaxType;

@Entity
@Table(name = "TRIATAX")
public class TriaTaxEntity implements Serializable {

	private static final long serialVersionUID = 4414151032193273462L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer triaTaxId;

	// enumeration will gives stateName
	@Enumerated(EnumType.STRING)
	@Column(length = 10)
	private StateCode stateCode;

	@Enumerated(EnumType.STRING)
	@Column(length = 10)
	private TaxType taxType;

	@Enumerated(EnumType.STRING)
	@Column(length = 10,nullable=false)
	private Country country;

	@Column(nullable = true,name="isShippingTaxable")
	private Boolean shippingTaxable;

	@Column(precision = 19, scale = 4)
	private Double taxAmount;









}
