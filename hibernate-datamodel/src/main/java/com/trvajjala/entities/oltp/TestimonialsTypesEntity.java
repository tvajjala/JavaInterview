package com.trvajjala.entities.oltp;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TESTIMONIALSTYPES")
public class TestimonialsTypesEntity implements Serializable {

	private static final long serialVersionUID = 8225701862845166685L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer testimonialsTypeId;

	@Column(length = 30, nullable = false, unique = true)
	private String testimonialsTypeCode;

	@Column(length = 100, nullable = false)
	private String testimonialsTypeTitle;

	@Column(length = 255)
	private String description;

	@Column(nullable = false)
	private Integer deviceTypeId;

	public Integer getTestimonialsTypeId() {
		return testimonialsTypeId;
	}

	public void setTestimonialsTypeId(Integer testimonialsTypeId) {
		this.testimonialsTypeId = testimonialsTypeId;
	}

	public String getTestimonialsTypeCode() {
		return testimonialsTypeCode;
	}

	public void setTestimonialsTypeCode(String testimonialsTypeCode) {
		this.testimonialsTypeCode = testimonialsTypeCode;
	}

	public String getTestimonialsTypeTitle() {
		return testimonialsTypeTitle;
	}

	public void setTestimonialsTypeTitle(String testimonialsTypeTitle) {
		this.testimonialsTypeTitle = testimonialsTypeTitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getDeviceTypeId() {
		return deviceTypeId;
	}

	public void setDeviceTypeId(Integer deviceTypeId) {
		this.deviceTypeId = deviceTypeId;
	}

}
