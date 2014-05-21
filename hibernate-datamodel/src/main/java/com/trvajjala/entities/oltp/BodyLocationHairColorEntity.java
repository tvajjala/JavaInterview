package com.trvajjala.entities.oltp;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name = "BODYLOCATIONHAIRCOLOR")
public class BodyLocationHairColorEntity implements Serializable {

	private static final long serialVersionUID = -2078694241706530544L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bodyLocationHairColorId;

	@ManyToOne
	@JoinColumn(name = "bodyLocationId")
	@ForeignKey(name="FK_BodyLocationHairColor_BodyLocation")
	private BodyLocationEntity bodyLocation;

	private String description;

	public Integer getBodyLocationHairColorId() {
		return bodyLocationHairColorId;
	}

	public void setBodyLocationHairColorId(Integer bodyLocationHairColorId) {
		this.bodyLocationHairColorId = bodyLocationHairColorId;
	}

	public BodyLocationEntity getBodyLocation() {
		return bodyLocation;
	}

	public void setBodyLocation(BodyLocationEntity bodyLocation) {
		this.bodyLocation = bodyLocation;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
