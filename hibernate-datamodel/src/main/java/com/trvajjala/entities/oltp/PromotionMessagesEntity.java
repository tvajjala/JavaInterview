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
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name = "PROMOTIONMESSAGES")
public class PromotionMessagesEntity implements Serializable {

	private static final long serialVersionUID = 4414151032193273462L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer promotionMessageId;

	@ManyToOne
	@JoinColumn(name = "promotionId")
	@ForeignKey(name = "FK_PromotionMessages_Promotion")
	private PromotionEntity promotion;

	@Column(length = 255, nullable = false)
	private String promotionMessage;

	public PromotionEntity getPromotion() {
		return promotion;
	}

	public void setPromotion(PromotionEntity promotion) {
		this.promotion = promotion;
	}

	@ManyToOne
	@JoinColumn(name = "createdByUserId")
	@ForeignKey(name = "FK_PromotionMessages_User_as_CreatedBy")
	private UserEntity createdBy;

	private Date createdOn;

	@ManyToOne
	@JoinColumn(name = "modifiedByUserId")
	@ForeignKey(name = "FK_PromotionMessages_User_as_ModifiedBy")
	private UserEntity modifiedBy;

	private Date modifiedOn;

	@PrePersist
	public void onCreate() {
		createdOn = new Date();
	}

	@PreUpdate
	public void onUpdate() {
		modifiedOn = new Date();
	}

	public Integer getPromotionMessageId() {
		return promotionMessageId;
	}

	public void setPromotionMessageId(Integer promotionMessageId) {
		this.promotionMessageId = promotionMessageId;
	}

	public String getPromotionMessage() {
		return promotionMessage;
	}

	public void setPromotionMessage(String promotionMessage) {
		this.promotionMessage = promotionMessage;
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
