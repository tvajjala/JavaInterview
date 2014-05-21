package com.trvajjala.entities.oltp;

import java.io.Serializable;

import javax.persistence.CascadeType;
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
@Table(name = "CARTLINE")
public class CartLineEntity implements Serializable {

	private static final long serialVersionUID = -8543105325697750920L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cartLineId;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cartId")
	@ForeignKey(name="FK_CartLine_Cart")
	private CartEntity cart;

	private Integer productId;

	private Integer quantity;

	@Column(precision = 10, scale = 4)
	private Double lineTotalPrice;

	public Integer getCartLineId() {
		return cartLineId;
	}

	public void setCartLineId(Integer cartLineId) {
		this.cartLineId = cartLineId;
	}

	public CartEntity getCart() {
		return cart;
	}

	public void setCart(CartEntity cart) {
		this.cart = cart;
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

}
