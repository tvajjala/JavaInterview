package com.trvajjala.entities.oltp;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name = "PROMOTIONSCODES")
public class PromotionCodeEntity implements Serializable {

	private static final long serialVersionUID = 4414151032193273462L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer promotionCodeId;

	@Column(length = 100)
	private String promotionTitle;

	@Column(length = 100)
	private String promotionCode;

	@Column(length = 255)
	private String description;

	private Integer consumed;

	private Integer availableCount;

	private Date scdStartDate;

	private Date scdEndDate;

	@Column(nullable = false,name="isActive")
	private Boolean active;

	@ManyToOne
	@JoinColumn(name = "createdByUserId")
	@ForeignKey(name = "FK_PromotionCodes_User_as_CreatedBy")
	private UserEntity createdBy;

	private Date createdOn;

	@ManyToOne
	@JoinColumn(name = "modifiedByUserId")
	@ForeignKey(name = "FK_PromotionCodes_User_as_ModifiedBy")
	private UserEntity modifiedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modifiedOn", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	private Date modifiedOn;

	public Integer getPromotionCodeId() {
		return promotionCodeId;
	}

	public void setPromotionCodeId(Integer promotionCodeId) {
		this.promotionCodeId = promotionCodeId;
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

	public Integer getConsumed() {
		return consumed;
	}

	public void setConsumed(Integer consumed) {
		this.consumed = consumed;
	}

	public Integer getAvailableCount() {
		return availableCount;
	}

	public void setAvailableCount(Integer availableCount) {
		this.availableCount = availableCount;
	}

	public Date getScdStartDate() {
		return scdStartDate;
	}

	public void setScdStartDate(Date scdStartDate) {
		this.scdStartDate = scdStartDate;
	}

	public Date getScdEndDate() {
		return scdEndDate;
	}

	public void setScdEndDate(Date scdEndDate) {
		this.scdEndDate = scdEndDate;
	}

	public Boolean isActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public UserEntity getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(UserEntity createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public UserEntity getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(UserEntity modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

}
