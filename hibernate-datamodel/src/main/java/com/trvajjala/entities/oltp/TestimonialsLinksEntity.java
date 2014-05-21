package com.trvajjala.entities.oltp;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TESTIMONIALSLINKS")
public class TestimonialsLinksEntity implements Serializable {

	private static final long serialVersionUID = 8225701862845166685L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer testimonialsLinkId;

	@Column(length = 30, nullable = false, unique = true)
	private String testimonialsLinkCode;

	@Column(length = 100, nullable = false)
	private String testimonialsLinkTitle;

	@Column(length = 255)
	private String description;

	@Column(nullable=false)
	private Integer deviceTypeId;

	public Integer getDeviceTypeId() {
		return deviceTypeId;
	}

	public void setDeviceTypeId(Integer deviceTypeId) {
		this.deviceTypeId = deviceTypeId;
	}

	public Integer getTestimonialsLinkId() {
		return testimonialsLinkId;
	}

	public void setTestimonialsLinkId(Integer testimonialsLinkId) {
		this.testimonialsLinkId = testimonialsLinkId;
	}

	public String getTestimonialsLinkCode() {
		return testimonialsLinkCode;
	}

	public void setTestimonialsLinkCode(String testimonialsLinkCode) {
		this.testimonialsLinkCode = testimonialsLinkCode;
	}

	public String getTestimonialsLinkTitle() {
		return testimonialsLinkTitle;
	}

	public void setTestimonialsLinkTitle(String testimonialsLinkTitle) {
		this.testimonialsLinkTitle = testimonialsLinkTitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
