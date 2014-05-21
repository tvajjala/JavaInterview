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
@Table(name = "PROMOTIONPRODUCTRESTRICTIONS")
public class PromotionRestrictionsEntity implements Serializable {

	private static final long serialVersionUID = 4414151032193273462L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer promotionRestrictionId;

	private Integer productFamilyId;

	private Integer productLineId;

	private Integer skuId;

	@ManyToOne
	@JoinColumn(name = "promotionId", nullable = true)
	@ForeignKey(name = "FK_PromotionRestrictions_Promotion")
	private PromotionEntity promotion;

	private Integer qualifyingCount;

	public Integer getPromotionRestrictionId() {
		return promotionRestrictionId;
	}

	public void setPromotionRestrictionId(Integer promotionRestrictionId) {
		this.promotionRestrictionId = promotionRestrictionId;
	}

	public Integer getProductFamilyId() {
		return productFamilyId;
	}

	public void setProductFamilyId(Integer productFamilyId) {
		this.productFamilyId = productFamilyId;
	}

	public Integer getProductLineId() {
		return productLineId;
	}

	public void setProductLineId(Integer productLineId) {
		this.productLineId = productLineId;
	}

	public Integer getSkuId() {
		return skuId;
	}

	public void setSkuId(Integer skuId) {
		this.skuId = skuId;
	}

	public PromotionEntity getPromotion() {
		return promotion;
	}

	public void setPromotion(PromotionEntity promotion) {
		this.promotion = promotion;
	}

	public Integer getQualifyingCount() {
		return qualifyingCount;
	}

	public void setQualifyingCount(Integer qualifyingCount) {
		this.qualifyingCount = qualifyingCount;
	}

}
