package com.trvajjala.entities.oltp;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;

import com.trvajjala.entities.constants.CardType;

@Entity
@Table(name = "REPLENISHMENTQUEUE")
public class ReplenishmentQueueEntity implements Serializable {

	private static final long serialVersionUID = -2078694241706530544L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer replenishmentQueueId;

	@Column(length = 100, nullable = false)
	private String replenishmentQueueTitle;

	@Column(length = 30, nullable = false, unique = true)
	private String replenishmentQueueCode;

	@ManyToOne
	@JoinColumn(name = "orderId")
	@ForeignKey(name = "FK_ReplenishmentQueue_Order")
	private OrderEntity order;

	@ManyToOne
	@JoinColumn(name = "customerId")
	@ForeignKey(name = "FK_ReplenishmentQueue_User")
	private UserEntity customer;

	@Enumerated(EnumType.STRING)
	@Column(length = 15)
	private CardType cardType;

	@ManyToOne
	@JoinColumn(name = "shippingAddressId", nullable = false)
	@ForeignKey(name = "FK_ReplenishmentQueue_Address_as_shipping")
	private AddressEntity shippingAddress;

	@ManyToOne
	@JoinColumn(name = "billingAddressId", nullable = false)
	@ForeignKey(name = "FK_ReplenishmentQueue_Address_as_billing")
	private AddressEntity billingAddress;

	@Column(nullable = false)
	private Integer skuId;

	private Integer installmentsCount;

	@Column(precision = 19, scale = 4)
	private Double installmentValue;

	private Date replenishmentStartDate;

	private Date replenishmentEndDate;

	private Date replenishmentLastSentDate;

	private Date replenishmentNextOrderDate;

	@Column(precision = 10, scale = 2)
	private Double replenishmentFrequency;

	@Column(length = 20)
	private String authorizeProfileID;

	@Column(length = 20)
	private String authorizePaymentProfileID;

	@Column(length = 30)
	private String status;

	@Column(name="isActive")
	private Boolean active;

	@Column(length = 30)
	private String promotionCode;

	@Column(name="isPromotionApplied")
	private Boolean promotionApplied;

	public Integer getReplenishmentQueueId() {
		return replenishmentQueueId;
	}

	public void setReplenishmentQueueId(Integer replenishmentQueueId) {
		this.replenishmentQueueId = replenishmentQueueId;
	}

	public String getReplenishmentQueueTitle() {
		return replenishmentQueueTitle;
	}

	public void setReplenishmentQueueTitle(String replenishmentQueueTitle) {
		this.replenishmentQueueTitle = replenishmentQueueTitle;
	}

	public String getReplenishmentQueueCode() {
		return replenishmentQueueCode;
	}

	public void setReplenishmentQueueCode(String replenishmentQueueCode) {
		this.replenishmentQueueCode = replenishmentQueueCode;
	}

	public OrderEntity getOrder() {
		return order;
	}

	public void setOrder(OrderEntity order) {
		this.order = order;
	}

	public UserEntity getCustomer() {
		return customer;
	}

	public void setCustomer(UserEntity customer) {
		this.customer = customer;
	}

	public CardType getCardType() {
		return cardType;
	}

	public void setCardType(CardType cardType) {
		this.cardType = cardType;
	}

	public AddressEntity getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(AddressEntity shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public AddressEntity getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(AddressEntity billingAddress) {
		this.billingAddress = billingAddress;
	}

	public Integer getSkuId() {
		return skuId;
	}

	public void setSkuId(Integer skuId) {
		this.skuId = skuId;
	}

	public Integer getInstallmentsCount() {
		return installmentsCount;
	}

	public void setInstallmentsCount(Integer installmentsCount) {
		this.installmentsCount = installmentsCount;
	}

	public Double getInstallmentValue() {
		return installmentValue;
	}

	public void setInstallmentValue(Double installmentValue) {
		this.installmentValue = installmentValue;
	}

	public Date getReplenishmentStartDate() {
		return replenishmentStartDate;
	}

	public void setReplenishmentStartDate(Date replenishmentStartDate) {
		this.replenishmentStartDate = replenishmentStartDate;
	}

	public Date getReplenishmentEndDate() {
		return replenishmentEndDate;
	}

	public void setReplenishmentEndDate(Date replenishmentEndDate) {
		this.replenishmentEndDate = replenishmentEndDate;
	}

	public Date getReplenishmentLastSentDate() {
		return replenishmentLastSentDate;
	}

	public void setReplenishmentLastSentDate(Date replenishmentLastSentDate) {
		this.replenishmentLastSentDate = replenishmentLastSentDate;
	}

	public Date getReplenishmentNextOrderDate() {
		return replenishmentNextOrderDate;
	}

	public void setReplenishmentNextOrderDate(Date replenishmentNextOrderDate) {
		this.replenishmentNextOrderDate = replenishmentNextOrderDate;
	}

	public Double getReplenishmentFrequency() {
		return replenishmentFrequency;
	}

	public void setReplenishmentFrequency(Double replenishmentFrequency) {
		this.replenishmentFrequency = replenishmentFrequency;
	}

	public String getAuthorizeProfileID() {
		return authorizeProfileID;
	}

	public void setAuthorizeProfileID(String authorizeProfileID) {
		this.authorizeProfileID = authorizeProfileID;
	}

	public String getAuthorizePaymentProfileID() {
		return authorizePaymentProfileID;
	}

	public void setAuthorizePaymentProfileID(String authorizePaymentProfileID) {
		this.authorizePaymentProfileID = authorizePaymentProfileID;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Boolean isActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getPromotionCode() {
		return promotionCode;
	}

	public void setPromotionCode(String promotionCode) {
		this.promotionCode = promotionCode;
	}

	public Boolean isPromotionApplied() {
		return promotionApplied;
	}

	public void setPromotionApplied(Boolean promotionApplied) {
		this.promotionApplied = promotionApplied;
	}

}
