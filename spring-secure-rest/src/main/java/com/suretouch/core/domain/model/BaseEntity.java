package com.suretouch.core.domain.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.springframework.security.core.context.SecurityContextHolder;

@MappedSuperclass
public class BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	String createdBy;
	Date createdOn;
	String updatedBy;
	Date updatedOn;

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	@PrePersist
	public void prePersist() {
		try {
			setCreatedOn(new Date());

			if (SecurityContextHolder.getContext().getAuthentication() != null) {
				setCreatedBy(SecurityContextHolder.getContext()
						.getAuthentication().getName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@PreUpdate
	public void preUpdate() {
		try {
			setUpdatedOn(new Date());
			if (SecurityContextHolder.getContext().getAuthentication() != null) {
				setUpdatedBy(SecurityContextHolder.getContext()
						.getAuthentication().getName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
