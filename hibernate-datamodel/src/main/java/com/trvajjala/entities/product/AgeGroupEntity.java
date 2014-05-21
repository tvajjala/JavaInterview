package com.trvajjala.entities.product;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AGEGROUP")
public class AgeGroupEntity implements Serializable {

	private static final long serialVersionUID = -645126012724719474L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ageGroupId;

	@Column(length = 30, nullable = true)
	private String ageGroupValue;

	public Integer getAgeGroupId() {
		return ageGroupId;
	}

	public void setAgeGroupId(Integer ageGroupId) {
		this.ageGroupId = ageGroupId;
	}

	public String getAgeGroupValue() {
		return ageGroupValue;
	}

	public void setAgeGroupValue(String ageGroupValue) {
		this.ageGroupValue = ageGroupValue;
	}
	
	

}
