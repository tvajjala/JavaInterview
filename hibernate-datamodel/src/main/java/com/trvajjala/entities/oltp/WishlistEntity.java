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
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name = "WISHLIST")
public class WishlistEntity implements Serializable {

	private static final long serialVersionUID = -5371026656766836481L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer wishlistId;

	@ManyToOne
	@JoinColumn(name = "customerId", nullable = false)
	@ForeignKey(name = "FK_Wishlist_User")
	private UserEntity customer;

	@Column(nullable = false)
	private Long productId;

	private Date creationDate;

	@PrePersist
	public void onCreate() {
		creationDate = new Date();
	}

	public Integer getWishlistId() {
		return wishlistId;
	}

	public void setWishlistId(Integer wishlistId) {
		this.wishlistId = wishlistId;
	}

	public UserEntity getCustomer() {
		return customer;
	}

	public void setCustomer(UserEntity customer) {
		this.customer = customer;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

}
