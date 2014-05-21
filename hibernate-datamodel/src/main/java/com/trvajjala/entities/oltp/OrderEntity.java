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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;

import com.trvajjala.entities.constants.Country;
import com.trvajjala.entities.constants.MeasurementUnit;
import com.trvajjala.entities.constants.PaymentMode;
import com.trvajjala.entities.constants.Region;

@Entity
@Table(name = "ORDERS")
public class OrderEntity implements Serializable {

	private static final long serialVersionUID = -2078694241706530544L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderId;

	@Column(length = 50, nullable = false, unique = true)
	private String orderNumber;

	@ManyToOne
	@JoinColumn(name = "customerId")
	@ForeignKey(name = "FK_Order_User")
	private UserEntity customer;

	@Enumerated(EnumType.STRING)
	@Column(length = 10)
	private Country country;

	private String channelCode;

	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private Region region;

	@Column(precision = 18, scale = 4)
	private Double totalWeight;

	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private MeasurementUnit measurementUnit;

	@ManyToOne
	@JoinColumn(name = "shippingAddressId")
	@ForeignKey(name = "FK_Order_Address_as_shipping")
	private AddressEntity shippingAddress;

	@ManyToOne
	@JoinColumn(name = "billingAddressId")
	@ForeignKey(name = "FK_Order_Address_as_billing")
	private AddressEntity billingAddress;

	@Column(precision = 19, scale = 4)
	private Double tax;

	@Column(precision = 19, scale = 4)
	private Double discountValue;

	@Column(precision = 19, scale = 4)
	private Double shippingCost;

	@Column(precision = 19, scale = 4)
	private Double subTotal;

	@Column(precision = 19, scale = 4)
	private Double additionalFee;

	@Column(precision = 19, scale = 4)
	private Double totalPrice;

	@ManyToOne
	@JoinColumn(name = "shippingCompanyServiceId")
	@ForeignKey(name = "FK_Order_shippingCompanyService")
	private ShippingCompanyServiceEntity shippingCompanyService;

	@Column(length = 255)
	private String email;

	@Column(length = 15)
	private String phoneNumber;

	@ManyToOne
	@JoinColumn(name = "orderStatusId")
	@ForeignKey(name = "FK_Order_OrderStatus")
	private OrderStatusEntity orderStatus;

	@ManyToOne
	@JoinColumn(name = "paymentStatusId")
	@ForeignKey(name = "FK_Order_PaymentStatus")
	private PaymentStatusEntity paymentStatus;

	@ManyToOne
	@JoinColumn(name = "deliveryStatusId")
	@ForeignKey(name = "FK_Order_DeliveryStatus")
	private DeliveryStatusEntity deliveryStatus;

	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private PaymentMode paymentMode;

	@Column(nullable = true, name = "isReplenishmentOrder")
	private Boolean replenishmentOrder;

	private Integer replenishmentQueueId;

	private String orderSource;

	private Date customerPrefferedShipDate;

	@Lob
	private String shipmentComments;

	@Column(name = "isSignatureRequired")
	private Boolean signatureRequired;

	@ManyToOne
	@JoinColumn(name = "promotionId")
	@ForeignKey(name = "FK_Order_Promotion")
	private PromotionEntity promotion;

	@Column(precision = 19, scale = 4)
	private Double deliveryCost;

	private Date orderDate;

	@Column(precision = 19, scale = 4)
	private Double commission;

	@ManyToOne
	@JoinColumn(name = "sessionInfoId", nullable = true)
	@ForeignKey(name = "FK_Order_SessionInfo")
	private SessionInfoEntity sessionInfo;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public UserEntity getCustomer() {
		return customer;
	}

	public void setCustomer(UserEntity customer) {
		this.customer = customer;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public String getChannelCode() {
		return channelCode;
	}

	public void setChannelCode(String channelCode) {
		this.channelCode = channelCode;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public Double getTotalWeight() {
		return totalWeight;
	}

	public void setTotalWeight(Double totalWeight) {
		this.totalWeight = totalWeight;
	}

	public MeasurementUnit getMeasurementUnit() {
		return measurementUnit;
	}

	public void setMeasurementUnit(MeasurementUnit measurementUnit) {
		this.measurementUnit = measurementUnit;
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

	public Double getTax() {
		return tax;
	}

	public void setTax(Double tax) {
		this.tax = tax;
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

	public Double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}

	public Double getAdditionalFee() {
		return additionalFee;
	}

	public void setAdditionalFee(Double additionalFee) {
		this.additionalFee = additionalFee;
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

	public OrderStatusEntity getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatusEntity orderStatus) {
		this.orderStatus = orderStatus;
	}

	public PaymentStatusEntity getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(PaymentStatusEntity paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public DeliveryStatusEntity getDeliveryStatus() {
		return deliveryStatus;
	}

	public void setDeliveryStatus(DeliveryStatusEntity deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

	public PaymentMode getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(PaymentMode paymentMode) {
		this.paymentMode = paymentMode;
	}

	public Boolean isReplenishmentOrder() {
		return replenishmentOrder;
	}

	public void setReplenishmentOrder(Boolean replenishmentOrder) {
		this.replenishmentOrder = replenishmentOrder;
	}

	public Integer getReplenishmentQueueId() {
		return replenishmentQueueId;
	}

	public void setReplenishmentQueueId(Integer replenishmentQueueId) {
		this.replenishmentQueueId = replenishmentQueueId;
	}

	public String getOrderSource() {
		return orderSource;
	}

	public void setOrderSource(String orderSource) {
		this.orderSource = orderSource;
	}

	public Date getCustomerPrefferedShipDate() {
		return customerPrefferedShipDate;
	}

	public void setCustomerPrefferedShipDate(Date customerPrefferedShipDate) {
		this.customerPrefferedShipDate = customerPrefferedShipDate;
	}

	public String getShipmentComments() {
		return shipmentComments;
	}

	public void setShipmentComments(String shipmentComments) {
		this.shipmentComments = shipmentComments;
	}

	public Boolean isSignatureRequired() {
		return signatureRequired;
	}

	public void setSignatureRequired(Boolean signatureRequired) {
		this.signatureRequired = signatureRequired;
	}

	public PromotionEntity getPromotion() {
		return promotion;
	}

	public void setPromotion(PromotionEntity promotion) {
		this.promotion = promotion;
	}

	public Double getDeliveryCost() {
		return deliveryCost;
	}

	public void setDeliveryCost(Double deliveryCost) {
		this.deliveryCost = deliveryCost;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Double getCommission() {
		return commission;
	}

	public void setCommission(Double commission) {
		this.commission = commission;
	}

	public SessionInfoEntity getSessionInfo() {
		return sessionInfo;
	}

	public void setSessionInfo(SessionInfoEntity sessionInfo) {
		this.sessionInfo = sessionInfo;
	}

}
