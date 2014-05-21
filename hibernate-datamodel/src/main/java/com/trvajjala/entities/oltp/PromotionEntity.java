package com.trvajjala.entities.oltp;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name = "PROMOTION")
public class PromotionEntity implements Serializable {

	private static final long serialVersionUID = 4414151032193273462L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer promotionId;

	@Column(length = 100, nullable = false)
	private String promotionTitle;

	@Column(length = 30, nullable = false, unique = true)
	private String promotionCode;

	@Column(length = 255)
	private String description;

	@ManyToOne
	@JoinColumn(name = "promotionSubTypeId", nullable = false)
	@ForeignKey(name = "FK_Promotion_PromotionSubType")
	private PromotionSubTypeEntity promotionSubType;

	@Column(precision = 19, scale = 4)
	private Double promotionValue;

	@Column(precision = 19, scale = 4)
	private Double discountValue;

	private Integer shippingServiceCostId;

	private Integer targetProductSKUId;

	@Column(precision = 19, scale = 4)
	private Double orderCostThreshold;

	private Integer freeCount;

	@OneToMany
	@JoinTable(name = "PROMOTION_GROUP", joinColumns = { @JoinColumn(name = "promotionId") }, inverseJoinColumns = { @JoinColumn(name = "promotionCodeId") })
	private Set<PromotionCodeEntity> promotionCodes = new HashSet<PromotionCodeEntity>();

	public Set<PromotionCodeEntity> getPromotionCodes() {
		return promotionCodes;
	}

	public void setPromotionCodes(Set<PromotionCodeEntity> promotionCodes) {
		this.promotionCodes = promotionCodes;
	}

	public Integer getPromotionId() {
		return promotionId;
	}

	public void setPromotionId(Integer promotionId) {
		this.promotionId = promotionId;
	}

	public String getPromotionTitle() {
		return promotionTitle;
	}

	public void setPromotionTitle(String promotionTitle) {
		this.promotionTitle = promotionTitle;
	}

	public String getPromotionCode() {
		return promotionCode;
	}

	public void setPromotionCode(String promotionCode) {
		this.promotionCode = promotionCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public PromotionSubTypeEntity getPromotionSubType() {
		return promotionSubType;
	}

	public void setPromotionSubType(PromotionSubTypeEntity promotionSubType) {
		this.promotionSubType = promotionSubType;
	}

	public Double getPromotionValue() {
		return promotionValue;
	}

	public void setPromotionValue(Double promotionValue) {
		this.promotionValue = promotionValue;
	}

	public Double getDiscountValue() {
		return discountValue;
	}

	public void setDiscountValue(Double discountValue) {
		this.discountValue = discountValue;
	}

	public Integer getShippingServiceCostId() {
		return shippingServiceCostId;
	}

	public void setShippingServiceCostId(Integer shippingServiceCostId) {
		this.shippingServiceCostId = shippingServiceCostId;
	}

	public Integer getTargetProductSKUId() {
		return targetProductSKUId;
	}

	public void setTargetProductSKUId(Integer targetProductSKUId) {
		this.targetProductSKUId = targetProductSKUId;
	}

	public Double getOrderCostThreshold() {
		return orderCostThreshold;
	}

	public void setOrderCostThreshold(Double orderCostThreshold) {
		this.orderCostThreshold = orderCostThreshold;
	}

	public Integer getFreeCount() {
		return freeCount;
	}

	public void setFreeCount(Integer freeCount) {
		this.freeCount = freeCount;
	}

}
