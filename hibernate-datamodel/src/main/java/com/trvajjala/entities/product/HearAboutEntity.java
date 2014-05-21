package com.trvajjala.entities.product;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "HEARABOUT")
public class HearAboutEntity implements Serializable {

	private static final long serialVersionUID = -645126012724719474L;

	/*
	 * /friends/family news paper website magzine television
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer hearAboutId;

	@Column(length = 50, nullable = false, unique = true)
	private String hearAboutValue;

	public Integer getHearAboutId() {
		return hearAboutId;
	}

	public void setHearAboutId(Integer hearAboutId) {
		this.hearAboutId = hearAboutId;
	}

	public String getHearAboutValue() {
		return hearAboutValue;
	}

	public void setHearAboutValue(String hearAboutValue) {
		this.hearAboutValue = hearAboutValue;
	}

}
