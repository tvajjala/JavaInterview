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
@Table(name = "CUSTOMERACTIVITY")
public class CustomerActivityEntity implements Serializable {

	private static final long serialVersionUID = -8543105325697750920L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customerActivityId;

	@ManyToOne
	@JoinColumn(name = "customerId")
	@ForeignKey(name="FK_CustomerActivity_User")
	private UserEntity customer;

	private Integer guestId;

	@Column(length = 100)
	private String activityKey;

	@Column(length = 100)
	private String activityValue;

	public Integer getCustomerActivityId() {
		return customerActivityId;
	}

	public void setCustomerActivityId(Integer customerActivityId) {
		this.customerActivityId = customerActivityId;
	}

	public UserEntity getCustomer() {
		return customer;
	}

	public void setCustomer(UserEntity customer) {
		this.customer = customer;
	}

	public Integer getGuestId() {
		return guestId;
	}

	public void setGuestId(Integer guestId) {
		this.guestId = guestId;
	}

	public String getActivityKey() {
		return activityKey;
	}

	public void setActivityKey(String activityKey) {
		this.activityKey = activityKey;
	}

	public String getActivityValue() {
		return activityValue;
	}

	public void setActivityValue(String activityValue) {
		this.activityValue = activityValue;
	}

}
