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
import com.trvajjala.entities.constants.Gender;

@Entity
@Table(name = "SWEEPSTAKEENTRIES")
public class SweepStakeEntriesEntity implements Serializable {

	private static final long serialVersionUID = 8225701862845166685L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sweepStakeEntryId;

	@Column(length = 255, nullable = false, unique = true)
	private String email;

	@ManyToOne
	@JoinColumn(name = "addressId")
	@ForeignKey(name = "FK_SweepStakeEntry_Address")
	private AddressEntity address;

	@Column(length = 20)
	private String age;

	@ManyToOne
	@JoinColumn(name = "sweepStakesId")
	@ForeignKey(name = "FK_SweepStakeEntries_SweepStakes")
	private SweepStakesEntity sweepStakes;

	@Enumerated(EnumType.STRING)
	@Column(length = 10)
	private Gender gender;

	private Integer hearAboutId;

	@Lob
	private String hearAboutUS;

	@Column(length = 50)
	private String poll;

	@Column(length = 100)
	private String shopName;

	@Column(length = 50)
	private String newAgeGroup;

	@Enumerated(EnumType.STRING)
	private Country country;

	public Integer getSweepStakeEntryId() {
		return sweepStakeEntryId;
	}

	public void setSweepStakeEntryId(Integer sweepStakeEntryId) {
		this.sweepStakeEntryId = sweepStakeEntryId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public AddressEntity getAddress() {
		return address;
	}

	public void setAddress(AddressEntity address) {
		this.address = address;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public SweepStakesEntity getSweepStakes() {
		return sweepStakes;
	}

	public void setSweepStakes(SweepStakesEntity sweepStakes) {
		this.sweepStakes = sweepStakes;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Integer getHearAboutId() {
		return hearAboutId;
	}

	public void setHearAboutId(Integer hearAboutId) {
		this.hearAboutId = hearAboutId;
	}

	public String getHearAboutUS() {
		return hearAboutUS;
	}

	public void setHearAboutUS(String hearAboutUS) {
		this.hearAboutUS = hearAboutUS;
	}

	public String getPoll() {
		return poll;
	}

	public void setPoll(String poll) {
		this.poll = poll;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getNewAgeGroup() {
		return newAgeGroup;
	}

	public void setNewAgeGroup(String newAgeGroup) {
		this.newAgeGroup = newAgeGroup;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

}
