package com.trvajjala.entities.oltp;

import java.io.Serializable;
import java.util.Date;

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
@Table(name = "SWEEPSTAKES")
public class SweepStakesEntity implements Serializable {

	private static final long serialVersionUID = 8225701862845166685L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sweepStakesId;

	private Date sweepStakeStartDate;

	private Date sweepStakeEndDate;

	@Enumerated(EnumType.STRING)
	@Column(length = 10)
	private Country country;

	@Column(length = 60)
	private String sweepStakeName;

	public Integer getSweepStakesId() {
		return sweepStakesId;
	}

	public void setSweepStakesId(Integer sweepStakesId) {
		this.sweepStakesId = sweepStakesId;
	}

	public Date getSweepStakeStartDate() {
		return sweepStakeStartDate;
	}

	public void setSweepStakeStartDate(Date sweepStakeStartDate) {
		this.sweepStakeStartDate = sweepStakeStartDate;
	}

	public Date getSweepStakeEndDate() {
		return sweepStakeEndDate;
	}

	public void setSweepStakeEndDate(Date sweepStakeEndDate) {
		this.sweepStakeEndDate = sweepStakeEndDate;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public String getSweepStakeName() {
		return sweepStakeName;
	}

	public void setSweepStakeName(String sweepStakeName) {
		this.sweepStakeName = sweepStakeName;
	}

	
	
	
	
	
	
}
