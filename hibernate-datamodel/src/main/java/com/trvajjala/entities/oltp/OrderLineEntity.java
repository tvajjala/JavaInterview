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
@Table(name = "ORDERLINE")
public class OrderLineEntity implements Serializable {

	private static final long serialVersionUID = 8225701862845166685L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderLineId;

	@ManyToOne
	@JoinColumn(name = "orderId", nullable = false)
	@ForeignKey(name = "FK_OrderLine_Order")
	private OrderEntity order;

	private Integer productId;

	private Integer quantity;

	@Column(precision = 19, scale = 4)
	private Double lineTotalPrice;

	@Column(precision = 19, scale = 4)
	private Double tax;

	@ManyToOne
	@JoinColumn(name = "deliveryStatusId", nullable = false)
	@ForeignKey(name = "FK_OrderLine_DeliveryStatus")
	private DeliveryStatusEntity deliveryStatus;

	public Integer getOrderLineId() {
		return orderLineId;
	}

	public void setOrderLineId(Integer orderLineId) {
		this.orderLineId = orderLineId;
	}

	public OrderEntity getOrder() {
		return order;
	}

	public void setOrder(OrderEntity order) {
		this.order = order;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getLineTotalPrice() {
		return lineTotalPrice;
	}

	public void setLineTotalPrice(Double lineTotalPrice) {
		this.lineTotalPrice = lineTotalPrice;
	}

	public Double getTax() {
		return tax;
	}

	public void setTax(Double tax) {
		this.tax = tax;
	}

	public DeliveryStatusEntity getDeliveryStatus() {
		return deliveryStatus;
	}

	public void setDeliveryStatus(DeliveryStatusEntity deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

}
