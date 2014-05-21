package com.trvajjala.entities.oltp;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name = "PROMOTIONSUBTYPES")
public class PromotionSubTypeEntity implements Serializable {

	private static final long serialVersionUID = 4414151032193273462L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer promotionSubTypeId;

	@Column(length = 100)
	private String promotionSubTypeTitle;

	@Column(length = 30, nullable = false, unique = true)
	private String promotionSubTypeCode;

	@Column(length = 255)
	private String description;

	@ManyToOne
	@JoinColumn(name = "promotionTypeId")
	@ForeignKey(name = "FK_PromotionSubType_PromotionType")
	private PromotionTypeEntity promotionType;

	public Integer getPromotionSubTypeId() {
		return promotionSubTypeId;
	}

	public void setPromotionSubTypeId(Integer promotionSubTypeId) {
		this.promotionSubTypeId = promotionSubTypeId;
	}

	public String getPromotionSubTypeTitle() {
		return promotionSubTypeTitle;
	}

	public void setPromotionSubTypeTitle(String promotionSubTypeTitle) {
		this.promotionSubTypeTitle = promotionSubTypeTitle;
	}

	public String getPromotionSubTypeCode() {
		return promotionSubTypeCode;
	}

	public void setPromotionSubTypeCode(String promotionSubTypeCode) {
		this.promotionSubTypeCode = promotionSubTypeCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public PromotionTypeEntity getPromotionType() {
		return promotionType;
	}

	public void setPromotionType(PromotionTypeEntity promotionType) {
		this.promotionType = promotionType;
	}

}
