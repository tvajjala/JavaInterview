package com.trvajjala.entities.oltp;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name = "CART")
public class CartEntity implements Serializable {

	private static final long serialVersionUID = 8225701862845166685L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cartId;

	@OneToOne
	@JoinColumn(name = "customerId")
	@ForeignKey(name="FK_Cart_User")
	private UserEntity customer;

	@OneToOne
	@JoinColumn(name = "sessionInfoId")
	@ForeignKey(name="FK_Cart_SessionInfo")
	private SessionInfoEntity sessionInfo;

	@Column(precision = 10, scale = 4)
	private Double subTotal;

	@Column(precision = 10, scale = 4)
	private Double taxAmount;

	@Column(precision = 10, scale = 4)
	private Double discountValue;

	@Column(precision = 10, scale = 4)
	private Double shippingCost;

	@Column(precision = 10, scale = 4)
	private Double totalPrice;

	@ManyToOne
	@JoinColumn(name = "shippingCompanyServiceId")
	@ForeignKey(name="FK_Cart_ShippingCompanyService")
	private ShippingCompanyServiceEntity shippingCompanyService;

	@OneToOne
	@JoinColumn(name = "billingAddressId")
	@ForeignKey(name="FK_Cart_Address_as_billing")
	private AddressEntity billingAddress;

	@OneToOne
	@JoinColumn(name = "shippingAddressId")
	@ForeignKey(name="FK_Cart_Address_as_shipping")
	private AddressEntity shippingAddress;

	@Column(length = 255)
	private String email;

	@Column(length = 15)
	private String phoneNumber;

	@ManyToOne
	@JoinColumn(name = "promotionId")
	@ForeignKey(name="FK_Cart_Promotion")
	private PromotionEntity promotion;

	@Column(precision = 10, scale = 2)
	private Double totalCartWeight;

	public Integer getCartId() {
		return cartId;
	}

	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}

	public UserEntity getCustomer() {
		return customer;
	}

	public void setCustomer(UserEntity customer) {
		this.customer = customer;
	}

	public SessionInfoEntity getSessionInfo() {
		return sessionInfo;
	}

	public void setSessionInfo(SessionInfoEntity sessionInfo) {
		this.sessionInfo = sessionInfo;
	}

	public Double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}

	public Double getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(Double taxAmount) {
		this.taxAmount = taxAmount;
	}

	public Double getDiscountValue() {
		return discountValue;
	}

	public void setDiscountValue(Double discountValue) {
		this.discountValue = discountValue;
	}

	public Double getShippingCost() {
		return shippingCost;
	}

	public void setShippingCost(Double shippingCost) {
		this.shippingCost = shippingCost;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public ShippingCompanyServiceEntity getShippingCompanyService() {
		return shippingCompanyService;
	}

	public void setShippingCompanyService(
			ShippingCompanyServiceEntity shippingCompanyService) {
		this.shippingCompanyService = shippingCompanyService;
	}

	public AddressEntity getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(AddressEntity billingAddress) {
		this.billingAddress = billingAddress;
	}

	public AddressEntity getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(AddressEntity shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public Double getTotalCartWeight() {
		return totalCartWeight;
	}

	public void setTotalCartWeight(Double totalCartWeight) {
		this.totalCartWeight = totalCartWeight;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public PromotionEntity getPromotion() {
		return promotion;
	}

	public void setPromotion(PromotionEntity promotion) {
		this.promotion = promotion;
	}

}
