package com.trvajjala.entities.oltp;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PROMOTION_TYPE")
public class PromotionTypeEntity implements Serializable {

	private static final long serialVersionUID = 4414151032193273462L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long promotionTypeId;

	@Column(length = 100)
	private String name;

	@Column(length = 30, nullable = false, unique = true)
	private String code;

	@Column(length = 255)
	private String description;

	public Long getPromotionTypeId() {
		return promotionTypeId;
	}

	public void setPromotionTypeId(Long promotionTypeId) {
		this.promotionTypeId = promotionTypeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
