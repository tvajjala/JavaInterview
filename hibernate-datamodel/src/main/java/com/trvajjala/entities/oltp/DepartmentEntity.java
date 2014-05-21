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
import com.trvajjala.entities.constants.Region;

@Entity
@Table(name = "DEPARTMENTS")
public class DepartmentEntity implements Serializable {

	private static final long serialVersionUID = 8225701862845166685L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer departmentId;

	@Column(length = 30, unique = true, nullable = false)
	private String departmentCode;

	@Column(length = 150)
	private String departmentName;

	@Column(length = 255, nullable = false)
	private String email;

	@Column(length = 255)
	private String description;

	@Column(length = 50)
	private String territory;

	@Enumerated(EnumType.STRING)
	@Column(length = 10)
	private Region region;

	@Enumerated(EnumType.STRING)
	@Column(length = 4)
	private Country country;

	@Column(nullable = true,name="isActive")
	private Boolean active;

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTerritory() {
		return territory;
	}

	public void setTerritory(String territory) {
		this.territory = territory;
	}

	public Boolean isActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

}
