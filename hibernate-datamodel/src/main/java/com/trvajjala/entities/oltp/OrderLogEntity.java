package com.trvajjala.entities.oltp;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name = "ORDERLOG")
public class OrderLogEntity implements Serializable {

	private static final long serialVersionUID = 8225701862845166685L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderLogId;

	@ManyToOne
	@JoinColumn(name = "orderId")
	@ForeignKey(name = "FK_OrderLog_Order")
	private OrderEntity order;

	@Lob
	private String description;

	public Long getOrderLogId() {
		return orderLogId;
	}

	public void setOrderLogId(Long orderLogId) {
		this.orderLogId = orderLogId;
	}

	public OrderEntity getOrder() {
		return order;
	}

	public void setOrder(OrderEntity order) {
		this.order = order;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
