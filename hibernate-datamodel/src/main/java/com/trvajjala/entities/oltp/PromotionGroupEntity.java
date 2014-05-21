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
@Table(name="PROMOTION_GROUP")
public class PromotionGroupEntity implements Serializable {

	private static final long serialVersionUID = 4414151032193273462L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long promotionGroupId;
	
	private String groupName;
	
	
	private String description;
	
	@ManyToOne
	@JoinColumn(name="promotionId")
	@ForeignKey(name = "FK_PromotionGroup_Promotion")
	private PromotionEntity promotion;
	
	@ManyToOne
	@JoinColumn(name="promotionCodeId")
	@ForeignKey(name = "FK_PromotionGroup_PromotionCode")
	private PromotionCodeEntity promotionCode;
	
	@Column(nullable = false,name="isActive")
	private Boolean active;

	public Long getPromotionGroupId() {
		return promotionGroupId;
	}

	public void setPromotionGroupId(Long promotionGroupId) {
		this.promotionGroupId = promotionGroupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public PromotionEntity getPromotion() {
		return promotion;
	}

	public void setPromotion(PromotionEntity promotion) {
		this.promotion = promotion;
	}

	public PromotionCodeEntity getPromotionCode() {
		return promotionCode;
	}

	public void setPromotionCode(PromotionCodeEntity promotionCode) {
		this.promotionCode = promotionCode;
	}

	public Boolean isActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
	
	
	
	
	
}
